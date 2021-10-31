package oioi.back.oiback.domain

import java.time.LocalDateTime

class OiUser {
    var id: Int = 0
    var userId: String = ""
    var userPassword: String = ""
    var nickName: String = ""
    var createdAt: LocalDateTime = LocalDateTime.now()
    var updatedAt: LocalDateTime = LocalDateTime.now()
}
