package ai.datank.pollAdd.model

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.hibernate.annotations.GenericGenerator

import javax.persistence.*

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

    @Version
    Long version

    String name

    @OneToMany(mappedBy = 'poll')
    List<PollOption> pollOptions

    Map toMap() {
        [
                id: id,
                name: name,
        ]
    }
}
