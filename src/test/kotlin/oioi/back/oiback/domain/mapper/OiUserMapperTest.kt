package oioi.back.oiback.domain.mapper

import oioi.back.oiback.BaseDBTest
import oioi.back.oiback.domain.OiUser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class OiUserMapperTest : BaseDBTest() {

    @Autowired
    private lateinit var oiUserMapper: OiUserMapper

    @Test
    fun testSample() {
        val newOiUser = OiUser()
        newOiUser.userId = "userId"
        newOiUser.userPassword = "password"
        newOiUser.nickName = "nickName"

        oiUserMapper.insert(newOiUser)

        val selectedOiUser = oiUserMapper.select(newOiUser.id)
        assertEquals(newOiUser.id, selectedOiUser.id)
        assertEquals(newOiUser.userId, selectedOiUser.userId)
        assertEquals(newOiUser.userPassword, selectedOiUser.userPassword)
        assertEquals(newOiUser.nickName, selectedOiUser.nickName)
        assertNotNull(selectedOiUser.createdAt)
        assertNotNull(selectedOiUser.updatedAt)

        selectedOiUser.nickName = "oioiMaster"
        oiUserMapper.update(selectedOiUser)

        val updatedOiUser = oiUserMapper.select(newOiUser.id)
        assertEquals(selectedOiUser.id, updatedOiUser.id)
        assertEquals(selectedOiUser.userId, updatedOiUser.userId)
        assertEquals(selectedOiUser.userPassword, updatedOiUser.userPassword)
        assertEquals(selectedOiUser.nickName, updatedOiUser.nickName)
        assertEquals(selectedOiUser.nickName, updatedOiUser.nickName)
        assertNotEquals(selectedOiUser.updatedAt, updatedOiUser.updatedAt)
    }
}
