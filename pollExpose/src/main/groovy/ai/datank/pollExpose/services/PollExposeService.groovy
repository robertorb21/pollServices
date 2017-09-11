package ai.datank.pollExpose.services

import ai.datank.pollExpose.model.Poll
import ai.datank.pollExpose.respository.PollOptionRepository
import ai.datank.pollExpose.respository.PollRepository
import ai.datank.pollExpose.respository.UserRepository
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Slf4j
@TypeChecked
@CompileStatic
@Service
@Transactional
class PollExposeService {
    @Autowired
    UserRepository userRepository
    @Autowired
    PollRepository pollRepository
    @Autowired
    PollOptionRepository pollOptionRepository

    Poll giveMePoll(String pollId) {
        findPoll(pollId).orElseThrow {
            new Throwable("No se encontro información de la encuesta con id ${pollId}")
        }
    }

    Optional<Poll> findPoll(String pollId) {
        pollRepository.findById(pollId)
    }
}
