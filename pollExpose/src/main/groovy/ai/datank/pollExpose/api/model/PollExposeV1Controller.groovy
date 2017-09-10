package ai.datank.pollExpose.api

import ai.datank.pollExpose.services.PollExposeService
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Slf4j
@TypeChecked
@CompileStatic
@RestController
class PollExposeV1Controller {
    @Autowired
    PollExposeService pollExposeService

    @GetMapping(value = '/v1/poll/{pollId}')
    HttpEntity<Map> getPoll(@PathVariable('pollId') String pollId) {

    }
}
