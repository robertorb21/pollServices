package ai.datank.pollAdd.services

import ai.datank.pollAdd.repository.UserRepository
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.transaction.Transactional

@Slf4j
@Service
@Transactional
@TypeChecked
@CompileStatic
class UserService {

    @Autowired
    UserRepository userRepository
}
