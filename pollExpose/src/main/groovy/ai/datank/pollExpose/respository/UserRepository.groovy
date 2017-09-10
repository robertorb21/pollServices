package ai.datank.pollExpose.respository

import ai.datank.pollExpose.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, String> {

}