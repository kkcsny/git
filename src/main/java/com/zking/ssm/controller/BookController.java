package com.zking.ssm.controller;

import com.github.pagehelper.Page;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.BookType;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @ModelAttribute
    public void init(Model model){
        List<BookType> lis = new ArrayList<>();
        lis.add(new BookType("言情","言情"));
        lis.add(new BookType("武侠","武侠"));
        lis.add(new BookType("恐怖","恐怖"));
        lis.add(new BookType("不良人","不良人"));
        model.addAttribute("rows",lis);
        Book book = new Book();
        model.addAttribute("book",book);

    }

    @RequestMapping("/toAdd")
    public String toAddBook(){
        return "book/addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book,Model model){
        System.out.println(book);
        int insert = bookService.insert(book);
        if(insert>0){
            model.addAttribute("massage","新增书本成功！");
        }else{
            model.addAttribute("massage","新增书本失败！");
        }
        return "redirect:toAdd";
    }

    @RequestMapping("/toList")
    public String toList(Book book, HttpServletRequest req,Model model){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Book> books = bookService.queryBookPager(book, pageBean);
        model.addAttribute("lis",books);
        model.addAttribute("pagebean",pageBean);
        return "book/bookList";
    }

}
