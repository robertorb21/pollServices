package ai.datank.pollAdd.api

import ai.datank.pollAdd.api.model.PollCommand
import ai.datank.pollAdd.model.Poll
import ai.datank.pollAdd.services.PollService
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

import static org.springframework.http.ResponseEntity.created
import static org.springframework.http.ResponseEntity.ok
import static org.springframework.web.util.UriComponentsBuilder.fromUriString

@Slf4j
@TypeChecked
@CompileStatic
@RestController
class PollAddV1Controller {
    @Autowired
    PollService pollService

    @PutMapping(value = '/v1/poll')
    HttpEntity addPoll(@RequestBody PollCommand pollCommand) {
        Poll poll = pollService.savePoll(pollCommand)

        URI uri = fromUriString("/v1/poll/${poll.id}").build().toUri()
        created(uri).body(poll.toMap())
    }

    @PutMapping(value = '/v1/poll/{pollOptionId}/vote')
    HttpEntity<Map> addVote(@PathVariable('pollOptionId') String pollOptionId) {
        pollService.addVote(pollOptionId)
        ok([ok: true])
    }
}
