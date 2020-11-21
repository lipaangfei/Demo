package com.nowcoder.code.service;

import com.nowcoder.code.dao.BookDAO;
import com.nowcoder.code.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lipf
 * @version 1.0
 * @date 2020/10/28
 */

@Service
public class BookService {
    @Autowired
    private BookDAO bookDao;

    public List<BookInfo> getBookList(){
        return bookDao.getBookList();
    }

    public BookInfo getBookInfoById(int id){
        return bookDao.getBookInfoById(id);
    }

    public boolean addBook(BookInfo bookInfo){
        return bookDao.add(bookInfo) > 0;
    }

    public boolean updateBook(BookInfo bookInfo){
        bookDao.update(bookInfo);
        //BookInfo newBookInfo = bookDao.getBookInfoById(bookInfo.getId());
        //System.out.println(newBookInfo.equals(bookInfo));
        return true;
    }

    public boolean removeBook(int id){
        bookDao.remove(id);
        return true;
    }
    public boolean deleteBook(int id){
        BookInfo bookInfo = bookDao.getBookInfoById(id);
        if(bookInfo == null){
            System.out.println(id + " not exists");
            return false;
        }
        bookDao.delete(id);
        return true;
    }
    public boolean recoverBook(int id){
        bookDao.recover(id);
        return true;
    }

    public List<BookInfo> getBookListByBookName(String bookName){
        return bookDao.getBookListByBookName("%" + bookName + "%");
    }
    public List<BookInfo> getBookListBySearch(String bookName, String author, double lowerPrice, double upperPrice, int status){
        bookName = "%" + bookName + "%";
        author = "%" + author + "%";
        return bookDao.getBookListBySearch(bookName, author, lowerPrice, upperPrice, status);
    }
}
