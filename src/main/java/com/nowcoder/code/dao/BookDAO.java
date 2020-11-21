package com.nowcoder.code.dao;

import com.nowcoder.code.model.BookInfo;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import net.paoding.rose.web.annotation.Param;

import java.util.List;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/28
 */

@DAO
public interface BookDAO {

    @SQL("select * from book where id=:id")
    public BookInfo getBookInfoById(@SQLParam("id") int id);

    @SQL("select * from book")
    public List<BookInfo> getBookList();

    @SQL("insert into book (author, name, price) values(:bookInfo.author, :bookInfo.name, :bookInfo.price)")
    @ReturnGeneratedKeys
    public int add(@SQLParam("bookInfo") BookInfo bookInfo);

    @SQL("update book set author=:bookInfo.author, name=:bookInfo.name, price=:bookInfo.price where id=:bookInfo.id")
    public void update(@SQLParam("bookInfo") BookInfo bookInfo);

    @SQL("delete from book where id=:id")
    public void delete(@SQLParam("id") int id);

    @SQL("update book set status=-1 where id=:id")
    public void remove(@SQLParam("id") int id);

    @SQL("update book set status=0 where id=:id")
    public void recover(@SQLParam("id") int id);

    //@SQL("select * from book where name = %:name%")
    //@SQL("select * from book where name like %:name%")
    //public List<BookInfo> getBookListByBookName(@SQLParam("name") String bookName);

    @SQL("select * from book where name like :name")
    public List<BookInfo> getBookListByBookName(@SQLParam("name") String bookName);

    @SQL("select * from book where name like :name and author like :author and price between :lowerPrice and :upperPrice" +
            " and status = :status")
    public List<BookInfo> getBookListBySearch(@SQLParam("name") String bookName, @SQLParam("author") String author,
                                              @SQLParam("lowerPrice") double lowerPrice, @SQLParam("upperPrice") double upperPrice,
                                              @SQLParam("status") int status);
}
