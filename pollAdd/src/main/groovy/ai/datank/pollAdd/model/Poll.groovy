package ai.datank.pollAdd.model

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import javax.persistence.*
import java.time.ZonedDateTime

@Entity
@TypeChecked
@CompileStatic
class Poll {

    @Id
    @GeneratedValue(generator = 'uuid2')
    @GenericGenerator(name = 'uuid2', strategy = 'uuid2')
    @Column(updatable = false)
    String id

    @Version
    Long version

    @Column(name = 'created_at', nullable = true)
    @CreatedDate
    @Type(type = 'org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime')
    ZonedDateTime createdAt

    @Column(name = 'last_modified_at', nullable = true)
    @LastModifiedDate
    @Type(type = 'org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime')
    ZonedDateTime lastModifiedAt

    String name
}
