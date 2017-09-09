package ai.datank.pollAdd.repository

import ai.datank.pollAdd.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, String> {

}