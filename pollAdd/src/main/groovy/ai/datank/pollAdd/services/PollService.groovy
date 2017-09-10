package ai.datank.pollAdd.services

import ai.datank.pollAdd.api.model.PollCommand
import ai.datank.pollAdd.model.Poll
import ai.datank.pollAdd.model.PollOption
import ai.datank.pollAdd.model.User
import ai.datank.pollAdd.repository.PollOptionRepository
import ai.datank.pollAdd.repository.PollRepository
import ai.datank.pollAdd.repository.UserRepository
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

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
    PollOptionRepository pollOptionRepository

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

        log.info('-->-->' + poll.pollOptions*.toMap())
        poll
    }

}
