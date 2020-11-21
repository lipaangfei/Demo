package com.nowcoder.code.service;

import com.nowcoder.code.dao.UserDAO;
import com.nowcoder.code.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/29
 */

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<UserInfo> getUserList(){
        return userDAO.getUserList();
    }

    public UserInfo getUserInfoById(int id){
        return userDAO.getUserInfoById(id);
    }

    public UserInfo getUserInfoByEmail(String email){
        return userDAO.getUserInfoByEmail(email);
    }

    public boolean addUser(UserInfo userInfo){
        return userDAO.addUser(userInfo) > 0;
    }
}
