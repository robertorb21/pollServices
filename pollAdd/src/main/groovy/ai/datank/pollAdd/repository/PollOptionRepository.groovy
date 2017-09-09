package ai.datank.pollAdd.repository

import ai.datank.pollAdd.model.PollOption
import org.springframework.data.jpa.repository.JpaRepository

interface PollOptionRepository extends JpaRepository<PollOption, String> {

}