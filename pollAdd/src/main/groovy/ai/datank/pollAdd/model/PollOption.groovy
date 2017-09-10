package ai.datank.pollAdd.model

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.NotBlank

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@TypeChecked
@CompileStatic
@Table(name = 'poll_options')
class PollOption {

    @Id
    @GeneratedValue(generator = 'uuid2')
    @GenericGenerator(name = 'uuid2', strategy = 'uuid2')
    @Column(updatable = false)
    String id

    @Version
    Long version

    @NotBlank
    String name

    @NotNull
    @ManyToOne
    @JoinColumn(name = 'poll_id', nullable = false)
    Poll poll

    @NotNull
    @ManyToOne
    @JoinColumn(name = 'user_id', nullable = false)
    User user
}
