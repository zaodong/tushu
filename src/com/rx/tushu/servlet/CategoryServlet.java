package com.rx.tushu.servlet;

import com.alibaba.fastjson.JSON;
import com.rx.tushu.model.Admininfo;
import com.rx.tushu.model.Categoryinfo;
import com.rx.tushu.service.CategoryService;
import com.rx.tushu.service.Impl.CategoryServiceImpl;
import com.rx.tushu.service.Impl.UserServiceImpl;
import com.rx.tushu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
      if (categoryService==null){
          categoryService=new CategoryServiceImpl();
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("addCategory".equals(method)){
            addCategory(req,resp);
        }else if ("deleteCategory".equals(method)){
            deleteCategory(req,resp);
        }else if ("selectCategoryAll".equals(method)){
            selectCategoryAll(req,resp);
        }
    }

    private void selectCategoryAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Categoryinfo> list =categoryService.selectCategoryAll();
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(JSON.toJSONString(list));
        writer.flush();
        writer.close();
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cName = req.getParameter("CName");
        boolean b = categoryService.addCategory(cName);
        if (!b==false){
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write("重复");
            writer.flush();
            writer.close();
        }

    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String CID = req.getParameter("CID");
        Integer integer = Integer.valueOf(CID);
        categoryService.deleteCategory(integer);

    }
}
