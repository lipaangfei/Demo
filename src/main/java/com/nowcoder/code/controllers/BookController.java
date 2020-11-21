package com.nowcoder.code.controllers;

import com.nowcoder.code.model.BookInfo;
import com.nowcoder.code.service.BookService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.WebUtils;
import static org.apache.commons.lang.StringUtils.isEmpty;
import javax.servlet.http.Cookie;
import java.util.List;

@LoginRequired
@Path("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Get("show-all-books")
    public String getBookListRequest(Invocation inv){
        List<BookInfo> bookInfoList = bookService.getBookList();
        Cookie cookie = WebUtils.getCookie(inv.getRequest(), "email");
        System.out.println("request: " + inv.getRequest());
        System.out.println("response: " + inv.getResponse());
        String email = cookie == null? null : cookie.getValue();
        inv.addModel("bookList", bookInfoList);
        inv.addModel("email", email);
        return "book/book_list";
    }

    @Get("add-a-book")
    public String addBookEditRequest(Invocation inv){
        inv.addModel("type", "add");
        return "book/one_book";
    }
    /**
     * Add a book from one_book.vm
     */
    @Post("add")
    public String addBook(Invocation inv, BookInfo bookInfo){
        return bookService.addBook(bookInfo)? "@add succeed" : "@add failed";
    }

    @Get("{id:[0-9]+}")
    public String getBookInfo(Invocation inv, @Param("id") int id){
        BookInfo bookInfo = bookService.getBookInfoById(id);
        inv.addModel("type", "update");
        inv.addModel("book", bookInfo);
        return "book/one_book";
    }
    /**
     * Update a book from one_book.vm
     */
    @Post("{id:[0-9]+}/update")
    public String updateBook(Invocation inv, BookInfo bookInfo){
        return bookService.updateBook(bookInfo)? "@modify succeed" : "@modify failed";
    }

    @Post("{id:[0-9]+}/delete")
    public String deleteBook(Invocation inv,@Param("id") int id){
        return bookService.deleteBook(id)? "@delete succeed" : "@delete failed";
    }

    @Post("{id:[0-9]+}/remove")
    public String removeBook(Invocation inv,@Param("id") int id){
        return bookService.removeBook(id)? "@remove succeed" : "@remove failed";
    }
    @Post("{id:[0-9]+}/recover")
    public String recoverBook(Invocation inv, @Param("id") int id){
        return bookService.recoverBook(id)? "@recover success" : "@recover failed";
    }

    @Get("{id:[0-9]+}/delete")
    public String deleteBookRequest(Invocation inv, @Param("id") int id){
        return bookService.deleteBook(id)? "@delete from db succeed" : "@";
    }

    @Get("search-book")
    public String searchBookRequest(Invocation inv){
        Cookie cookie = WebUtils.getCookie(inv.getRequest(), "email");
        System.out.println("request: " + inv.getRequest());
        System.out.println("response: " + inv.getResponse());
        String email = cookie == null? null : cookie.getValue();
        inv.addModel("email", email);
        return "book/search_book";
    }

    @Post("search-book")
    public String searchBook(Invocation inv, @Param("bookName") String bookName, @Param("author") String author,
                             @Param("lowerPrice") double lowerPrice, @Param("upperPrice") double upperPrice,
                             @Param("statusName") String statusName){ //@Param("bookName")表示String bookName是前端的便利变量
        //List<BookInfo> bookInfoList = bookService.getBookListByBookName(bookName);
        int status = (isEmpty(statusName) || statusName.equals("已出库"))? -1 : 0;
        System.out.println("statusName: " + statusName);
        //lowerPrice = Math.max(0, lowerPrice);
        //upperPrice = Math.max(0, upperPrice);
        List<BookInfo> bookInfoList = bookService.getBookListBySearch(bookName, author, lowerPrice, upperPrice, status);
        Cookie cookie = WebUtils.getCookie(inv.getRequest(), "email");
        System.out.println("request: " + inv.getRequest());
        System.out.println("response: " + inv.getResponse());
        String email = cookie == null? null : cookie.getValue();
        inv.addModel("email", email);
        inv.addModel("bookName", bookName);
        inv.addModel("author", author);
        inv.addModel("lowerPrice", lowerPrice);
        inv.addModel("upperPrice", upperPrice);
        inv.addModel("isInStore", status == 0);
        inv.addModel("bookList", bookInfoList);
        return "book/search_book";
    }
}
