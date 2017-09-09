package ai.datank.pollExpose.respository

import ai.datank.pollExpose.model.Poll
import org.springframework.data.jpa.repository.JpaRepository

interface PollExposeRespository extends JpaRepository<Poll, String> {

}