package ai.datank.pollAdd.services

import ai.datank.pollAdd.model.PollOption
import ai.datank.pollAdd.repository.PollOptionRepository
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Slf4j
@Service
@TypeChecked
@CompileStatic
@Transactional
class PollOptionService {
    @Autowired
    PollOptionRepository pollOptionRepository

    Optional<PollOption> findPollOption(String pollOptionId) {
        pollOptionRepository.findById(pollOptionId)
    }

    PollOption getPollOption(String pollOptionId) {
        findPollOption(pollOptionId).orElseThrow{
            log.error("No se encontro el registro con id${pollOptionId}")
        }
    }
}
