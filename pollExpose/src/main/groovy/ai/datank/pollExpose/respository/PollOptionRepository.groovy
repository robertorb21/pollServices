package ai.datank.pollExpose.respository

import ai.datank.pollExpose.model.PollOption
import org.springframework.data.jpa.repository.JpaRepository

interface PollOptionRepository extends JpaRepository<PollOption, String> {

}