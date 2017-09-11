package ai.datank.pollExpose.respository

import ai.datank.pollExpose.model.Poll
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface PollRepository extends JpaRepository<Poll, String> {

    Optional<Poll> findById(@Param('pollId') String pollId)
}