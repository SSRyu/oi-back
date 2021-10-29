package oioi.back.oiback.domain.mapper

import oioi.back.oiback.domain.OiUser
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface OiUserMapper {
    @Insert("""
        INSERT INTO oi_user
            (user_id, user_password, nick_name)
        VALUES
            (#{userId}, #{userPassword}, #{nickName})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(oiUser: OiUser)

    @Select("""
        SELECT
            id, 
            user_id as userId, 
            user_password as userPassword, 
            nick_name as nickName, 
            created_at as createdAt, 
            updated_at as updatedAt
        FROM
            oi_user
        WHERE
            id = #{id}
    """)
    fun select(id: Int): OiUser

    @Update("""
        UPDATE oi_user
        SET
            user_id = #{userId},
            user_password = #{userPassword},
            nick_name = #{nickName}
        WHERE
            id = #{id};

    """)
    fun update(oiUser: OiUser)
}