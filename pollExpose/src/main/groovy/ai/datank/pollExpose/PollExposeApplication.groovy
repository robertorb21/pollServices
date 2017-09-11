package ai.datank.pollExpose

import ai.datank.pollExpose.redis.Receiver
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.listener.PatternTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter

import java.util.concurrent.CountDownLatch

@Slf4j
@SpringBootApplication
class PollExposeApplication {

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer()
        container.setConnectionFactory(connectionFactory)
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"))

        return container
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage")
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch)
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1)
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory)
    }

    static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run PollExposeApplication, args

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate)
        CountDownLatch latch = ctx.getBean(CountDownLatch)

        log.info("Sending message")
        template.convertAndSend("chat", "heyy.. I'm the best")
        latch.wait()
    }
}
