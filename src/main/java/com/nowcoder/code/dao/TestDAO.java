package com.nowcoder.code.dao;

import com.nowcoder.code.model.BoolTestInfo;
import com.nowcoder.code.model.TestInfo;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/30
 */
@DAO
public interface TestDAO {
    @SQL("select id, msg from test limit 1")
    public TestInfo getTestInfo();

    @SQL("insert into test(id, msg) values (:t.id, :t.msg)")
    @ReturnGeneratedKeys
    public int insertTestInfo(@SQLParam("t") TestInfo testInfo);

    @SQL("select * from booltest where id=:1")
    public BoolTestInfo getBoolTest(int id);
}
