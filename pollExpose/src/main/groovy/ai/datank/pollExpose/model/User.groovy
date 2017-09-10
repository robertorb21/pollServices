package ai.datank.pollExpose.model

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.NotBlank
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.*
import javax.validation.constraints.NotNull
import java.time.ZonedDateTime

@Entity
@TypeChecked
@CompileStatic
@Table(name = 'users')
class User {

    @Id
    @GeneratedValue(generator = 'uuid2')
    @GenericGenerator(name = 'uuid2', strategy = 'uuid2')
    @Column(updatable = false)
    String id

    @NotBlank
    String name
}
