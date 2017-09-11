package ai.datank.pollExpose.redis

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

import java.util.concurrent.CountDownLatch

@Slf4j
class Receiver {

    CountDownLatch latch

    @Autowired
    Receiver(CountDownLatch latch) {
        this.latch = latch
    }

    void receiveMessage(String message) {
        log.info("Received ${message}")
        latch.countDown()
    }
}
