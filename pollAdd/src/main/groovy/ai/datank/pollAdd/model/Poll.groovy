package ai.datank.pollAdd.model

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.hibernate.annotations.GenericGenerator

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@TypeChecked
@CompileStatic
@Table(name = "polls")
class Poll {

    @Id
    @GeneratedValue(generator = 'uuid2')
    @GenericGenerator(name = 'uuid2', strategy = 'uuid2')
    @Column(updatable = false)
    String id

    String name

    @OneToMany(mappedBy = 'poll')
    List<PollOption> pollOptions = []

    @NotNull
    @ManyToOne
    @JoinColumn(name = 'user_id', nullable = false)
    User owner

    Map toMap() {
        [
                id: id,
                name: name,
                pollOptions: pollOptions*.toMap(),
        ]
    }
}
