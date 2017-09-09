package ai.datank.pollAdd.services

import ai.datank.pollAdd.api.model.PollCommand
import ai.datank.pollAdd.model.Poll
import ai.datank.pollAdd.repository.PollRepository
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
    PollRepository pollRepository

    Poll savePoll(PollCommand pollCommand) {

        Poll poll = new Poll(name: pollCommand.name)
        pollRepository.save(poll)

    }

}
