package com.rx.tushu.servlet;

import com.rx.tushu.model.Admininfo;
import com.rx.tushu.service.Impl.UserServiceImpl;
import com.rx.tushu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
      if (userService==null){
          userService=new UserServiceImpl();
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("login".equals(method)){
            login(req,resp);
        }else if ("logout".equals(method)){
            logout(req,resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        Cookie[] cookies = req.getCookies();
        for (int i=0;i<cookies.length;i++){
            if (cookies[i].getName().equals("TU")){
                Cookie cookie = cookies[i];
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        resp.sendRedirect("/");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String aLoginID = req.getParameter("ALoginID");
        String aLoginPSW = req.getParameter("ALoginPSW");
        String autoLog = req.getParameter("autoLog");
        Admininfo admininfo =userService.selectOne(aLoginID,aLoginPSW);
        if (admininfo!=null){
            req.getSession().setAttribute("user",admininfo);
            if (autoLog!=null){
                Cookie cookie = new Cookie("TU",admininfo.getALoginID()+"&"+admininfo.getALoginPSW());
                cookie.setMaxAge(60*60*24);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
            resp.sendRedirect("houtai.jsp");
        }else {
            resp.sendRedirect("/");
        }

    }
}
