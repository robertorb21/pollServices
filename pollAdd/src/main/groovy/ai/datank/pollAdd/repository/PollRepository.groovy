package ai.datank.pollAdd.repository

import ai.datank.pollAdd.model.Poll
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface PollRepository extends JpaRepository<Poll, String> {


}