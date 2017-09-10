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

        Poll poll = new Poll(name: pollCommand.pollName)
        pollRepository.save(poll)

        User user = new User(name: pollCommand.user)
        userRepository.save(user)

        pollCommand.pollOptions.each {
            log.info('-->-->' + it)
            PollOption pollOption = new PollOption(
                    name: it,
                    poll: poll,
                    user: user

            )
            pollOptionRepository.save(pollOption)
        }

        poll
    }

}
