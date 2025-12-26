package com.example.demo.mybatis;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(@Param("id") Long id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(@Param("id") Long id);

    @Insert("INSERT INTO users(id, first_name, last_name) " +
            " VALUES (#{id}, #{firstName}, #{lastName})")
    int createNew(User item);

    @Update("Update users set first_name=#{firstName}, " +
            " last_name=#{lastName} where id=#{id}")
    int update(User item);
}
