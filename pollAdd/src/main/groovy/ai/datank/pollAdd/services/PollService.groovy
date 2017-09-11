package ai.datank.pollAdd.services

import ai.datank.pollAdd.api.model.PollCommand
import ai.datank.pollAdd.api.model.PollRedisCommand
import ai.datank.pollAdd.model.Poll
import ai.datank.pollAdd.model.PollOption
import ai.datank.pollAdd.model.User
import ai.datank.pollAdd.repository.PollOptionRepository
import ai.datank.pollAdd.repository.PollRepository
import ai.datank.pollAdd.repository.UserRepository
import com.google.gson.Gson
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

import javax.transaction.Transactional
import org.springframework.data.redis.core.StringRedisTemplate

@Slf4j
@Service
@Transactional
@TypeChecked
@CompileStatic
class PollService {
    @Autowired
    UserRepository userRepository
    @Autowired
    PollRepository pollRepository
    @Autowired
    PollOptionService pollOptionService
    @Autowired
    PollOptionRepository pollOptionRepository
    @Autowired
    Gson gson
    @Autowired
    ApplicationContext ctx

    Poll savePoll(PollCommand pollCommand) {

        User user = new User(name: pollCommand.user)
        userRepository.save(user)

        Poll poll = new Poll(name: pollCommand.pollName, owner: user)
        pollRepository.save(poll)

        List<PollOption> pollOptions = []
        pollCommand.pollOptions.each {
            PollOption pollOption = new PollOption(
                    name: it,
                    poll: poll,
            )
            pollOptionRepository.save(pollOption)
            pollOptions.add(pollOption)
        }
        poll.pollOptions = pollOptions

        sendMessage(pollCommand, poll.id)

        poll
    }

    PollOption addVote(String pollOptionId) {


        PollOption pollOption = pollOptionService.getPollOption(pollOptionId)
        pollOption.votes = pollOption.votes+1
        pollOptionRepository.save(pollOption)

    }

    void sendMessage(PollCommand pollCommand, String pollId) {
        PollRedisCommand pollRedisCommand = new PollRedisCommand(
                id: pollId,
                user: pollCommand.user,
                pollName: pollCommand.pollName,
                pollOptions: pollCommand.pollOptions
        )
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate)
        template.convertAndSend("chat", gson.toJson(pollRedisCommand))
    }


}
