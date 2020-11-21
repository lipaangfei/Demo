package com.nowcoder.code.service;

import com.nowcoder.code.dao.TestDAO;
import com.nowcoder.code.model.BoolTestInfo;
import com.nowcoder.code.model.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/30
 */
@Service
public class TestService {
    @Autowired
    private TestDAO testDAO;

    public TestInfo getTest(){
        return testDAO.getTestInfo();
    }
    public int insertTestInfo(TestInfo testInfo){
        return testDAO.insertTestInfo(testInfo);
    }

    public BoolTestInfo getBoolTestInfo(int id){
        return testDAO.getBoolTest(id);
    }
}
