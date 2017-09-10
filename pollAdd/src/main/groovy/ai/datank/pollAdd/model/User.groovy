package ai.datank.pollAdd.model

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.*

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
