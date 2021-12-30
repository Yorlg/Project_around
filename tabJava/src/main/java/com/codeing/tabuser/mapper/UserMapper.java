package com.codeing.tabuser.mapper;

import com.codeing.tabuser.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author Yorlg
 * @data 2021-12-28
 * @apiNote
 */

@Repository
public interface UserMapper extends Mapper<User> {
    /**
     * 插入语句
     */
    @Insert("INSERT into tab_user(name,password) VALUES (#{name},#{password})")
    int savaUser(@Param("name") String name, @Param("password") String password);

    /**
     * 条件查询语句
     */
    @Select("select id,name,password from tab_user where name=#{name}")
    User selectUser(@Param("name") String name);


    @Select("select * from tab_user")
    List<User> allUser();

    /**
     * 删除语句
     */
    @Select("delete from tab_user where id= #{id}")
    User delUser(@Param("id") int id);

    /**
     * 修改语句
     */
    @Select("update tab_user SET name = #{name},password = #{password} WHERE id = #{id}")
    User editUser(@Param("name") String name, @Param("password") String password, @Param("id") int id);

}
