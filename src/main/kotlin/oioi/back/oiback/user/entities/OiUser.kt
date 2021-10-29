package oioi.back.oiback.user.entities

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "oi_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator::class, property = "id")
class OiUser(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long = 0L,

    @Column(name = "user_id", nullable = false, unique = true)
    val userId: String,
    @Column(name = "user_password", nullable = false)
    var userPassword: String,
    @Column(name = "nick_name", nullable = false, unique = true)
    var nickName: String,
)
