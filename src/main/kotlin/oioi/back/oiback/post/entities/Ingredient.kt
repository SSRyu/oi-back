package oioi.back.oiback.post.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ingredient")
class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "amount", nullable = true)
    var amount: String
)
