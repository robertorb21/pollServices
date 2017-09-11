package ai.datank.pollExpose.redis

import ai.datank.pollExpose.api.model.PollCommand
import ai.datank.pollExpose.services.PollExposeService
import com.google.gson.Gson
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
class Receiver {
    @Autowired
    PollExposeService pollExposeService
    @Autowired
    Gson gson

    PollCommand pollCommand

    @Autowired
    Receiver(PollCommand pollCommand) {
        this.pollCommand = pollCommand
    }

    void receiveMessage(String message) {
        log.info("Received ${message}")
        pollExposeService.savePoll(gson.fromJson(message, PollCommand))
    }
}
