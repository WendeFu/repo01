package com.lagou.controller;

import com.lagou.pojo.QueryVo;
import com.lagou.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("")
public class UserController {

    @RequestMapping("/testException")
    public String testException() {
        System.out.println("test22222");
        int i = 1 / 0;
        return "success";
    }

    @RequestMapping("/quick")
    public String quick() {
        System.out.println("quick running.....");
        return "success";
    }

    @RequestMapping("/simpleParam")
    public String simpleParam(Integer id, String username) {
        System.out.println(id);
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/pojoParam")
    public String pojoParam(User user) {
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(int[] ids) {
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    @RequestMapping("/queryParam")
    public String queryParam(QueryVo queryVo) {
        System.out.println(queryVo);
        return "success";
    }

    @RequestMapping("/converterParam")
    public String converterParam(Date birthday) {
        System.out.println(birthday);
        return "success";
    }

    @RequestMapping("/findByPage")
    public String findByPage(@RequestParam(name = "pageNo", defaultValue = "1") int pageNum,
                             @RequestParam(defaultValue = "5") int pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        return "success";
    }

    @RequestMapping("/requestHead")
    public String requestHead(@RequestHeader("cookie") String cookie, @RequestHeader("host") String host) {
        System.out.println(cookie);
        System.out.println(host);
        return "success";
    }

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
        return "success";
    }

    @RequestMapping("/servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }

    @RequestMapping("/returnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setContentType("text/html;charset=utf-8");
        //response.setCharacterEncoding("utf-8");
        response.getWriter().write("拉勾网");
        System.out.println(response.getCharacterEncoding());
    }

    @RequestMapping("/testRequest")
    public void testRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "拉勾教育");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        System.out.println("testRequest: "+response.getCharacterEncoding());
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "拉勾教育");
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        System.out.println("testResponse: "+response.getCharacterEncoding());
    }

    @RequestMapping("/testResponse2")
    public void testResponse2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "拉勾教育");
        response.sendRedirect("/index.jsp"); // 错误
        System.out.println("testResponse2: "+response.getCharacterEncoding());
    }

    @RequestMapping("/forward")
    public String forward(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("username", "拉勾教育");
        System.out.println("forward: "+response.getCharacterEncoding());
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/redirect")
    public String redirect(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("username", "拉勾教育");
        System.out.println("redirect: "+response.getCharacterEncoding());
        return "redirect:/index.jsp";
    }

    @RequestMapping("/redirect2")
    public String redirect2(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("username", "拉勾教育");
        System.out.println("redirect2: "+response.getCharacterEncoding());
        return "redirect:"+request.getContextPath()+"/index.jsp";  // 错误
    }

    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView(ModelAndView modelAndView) {
        modelAndView.addObject("username", "ModelAndView");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/ajaxRequest")
    @ResponseBody
    public List<User> ajaxRequest(@RequestBody List<User> list, HttpServletResponse response) {
    //public List<User> ajaxRequest() {
        //List<User> list = new ArrayList<>();
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(list);
        list.add(new User(3,"张飞"));
        //response.setContentType("application/json;charset=UTF-8");
        return list;
    }

}
