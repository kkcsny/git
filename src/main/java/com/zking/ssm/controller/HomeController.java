package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/home/index.kkhtml")
    public  String toIndex(){
        return "/index.jsp";
    }

    @RequestMapping("/toHome")
    public String toHome(Book book, HttpServletRequest req,
                         @RequestParam String sex,
                         @RequestParam HashMap<String,Object> params,
                         Model model){
        System.out.println("aaaa");
        System.out.println("Aaaaaa");
        System.out.println(req.getRequestURI());
        System.out.println(params);
        model.addAttribute("rows",params);
        return "redirect:toHome1";
    }


    @RequestMapping("/toHome1")
    public String toHome1(Model model){
        return "celcome";
    }


}
