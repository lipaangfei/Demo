package com.nowcoder.code.dao;

import com.nowcoder.code.model.UserInfo;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.web.annotation.Param;

import java.util.List;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */
@DAO
public interface UserDAO {
    @SQL("select * from user where email=:1")
    public UserInfo getUserInfoByEmail(String email);

    @SQL("select * from user where id=:1")
    public UserInfo getUserInfoById(int id);

    @SQL("select * from user")
    public List<UserInfo> getUserList();

    @SQL("select login_token from user where id=:1")
    public String getLoginTokerById(int id);

    @SQL("update user set login_token=:2 where id=:1")
    public void updateLoginTokenById(int id, String loginToken);

    @SQL("insert into user (email, password, nickname, phone) values(:user.email, :user.password, :user.nickname, :user.phone)")
    @ReturnGeneratedKeys
    //public int addUser(@Param("user") UserInfo userInfo);
    public int addUser(@SQLParam("user") UserInfo userInfo); //注意是SQLParam, 不是Param

}
