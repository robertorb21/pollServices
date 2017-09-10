package ai.datank.pollAdd.repository

import ai.datank.pollAdd.model.PollOption
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface PollOptionRepository extends JpaRepository<PollOption, String> {

    Optional<PollOption> findById(@Param('voteId') String voteId)

}