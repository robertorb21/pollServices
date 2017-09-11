package ai.datank.pollExpose.api

import ai.datank.pollExpose.model.Poll
import ai.datank.pollExpose.services.PollExposeService
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.ResponseEntity.ok

@Slf4j
@TypeChecked
@CompileStatic
@RestController
class PollExposeV1Controller {
    @Autowired
    PollExposeService pollExposeService

    @GetMapping(value = '/v1/poll/{pollId}')
    ResponseEntity<Map> giveMePoll(@PathVariable('pollId') String pollId) {
        Poll poll = pollExposeService.giveMePoll(pollId)
        ok(poll.toMap())
    }
}
