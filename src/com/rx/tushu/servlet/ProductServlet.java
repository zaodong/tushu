package com.rx.tushu.servlet;

import com.alibaba.fastjson.JSON;
import com.rx.tushu.model.Bookinfo;
import com.rx.tushu.model.Categoryinfo;
import com.rx.tushu.service.CategoryService;
import com.rx.tushu.service.Impl.CategoryServiceImpl;
import com.rx.tushu.service.Impl.ProductServiceImpl;
import com.rx.tushu.service.ProductService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/product")
@MultipartConfig
public class ProductServlet extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
      if (productService==null){
          productService=new ProductServiceImpl();
      }
      if (categoryService==null){
          categoryService=new CategoryServiceImpl();
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("deleteProduct".equals(method)){
            deleteProduct(req,resp);
        }else if ("selectProductAll".equals(method)){
            selectProductAll(req,resp);
        }else if ("selectOne".equals(method)){
            selectOne(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("addProduct".equals(method)){
            addProduct(req,resp);
        }else if ("updateProduct".equals(method)){
            updateProduct(req,resp);
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        Integer bid = Integer.valueOf(req.getParameter("BID"));
        String bTitle = new String(req.getParameter("BTitle").getBytes("ISO-8859-1"), "UTF-8");
        String bAuthor = new String(req.getParameter("BAuthor").getBytes("ISO-8859-1"), "UTF-8");
        Integer bPrice = Integer.valueOf(req.getParameter("BPrice"));
        Integer bCategoryID = Integer.valueOf(req.getParameter("BCategoryID"));
        String bPublisher = new String(req.getParameter("BPublisher").getBytes("ISO-8859-1"), "UTF-8");

        Part bPhoto1 = req.getPart("BPhoto");


            String submittedFileName = bPhoto1.getSubmittedFileName();
            String url = "img/" + submittedFileName;
            IOUtils.copy(bPhoto1.getInputStream(), new FileOutputStream(req.getServletContext().getRealPath("/") + url));
            productService.updateProduct(bid,bTitle,bAuthor,bPrice,bCategoryID,bPublisher,url);


        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }

    private void selectOne(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //查询当前图书
        Integer bid = Integer.valueOf(req.getParameter("BID"));
        Bookinfo bookinfo=productService.selectProductOne(bid);
        //查询分类
        List<Categoryinfo> list = categoryService.selectCategoryAll();
        req.setAttribute("product",bookinfo);
        req.setAttribute("category",list);
        req.getRequestDispatcher("xiugai.jsp").forward(req,resp);
    }



    private void selectProductAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Bookinfo> list =productService.selectProductAll();
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(JSON.toJSONString(list));
        writer.flush();
        writer.close();
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        String bTitle = new String(req.getParameter("BTitle").getBytes("ISO-8859-1"), "UTF-8");
        String bAuthor = new String(req.getParameter("BAuthor").getBytes("ISO-8859-1"), "UTF-8");
        Integer bPrice = Integer.valueOf(req.getParameter("BPrice"));
        Integer bCategoryID = Integer.valueOf(req.getParameter("BCategoryID"));
        String bPublisher = new String(req.getParameter("BPublisher").getBytes("ISO-8859-1"), "UTF-8");

        Part bPhoto1 = req.getPart("BPhoto");
        String submittedFileName = bPhoto1.getSubmittedFileName();
        String url="img/"+submittedFileName;
        IOUtils.copy(bPhoto1.getInputStream(),new FileOutputStream(req.getServletContext().getRealPath("/")+url));
        productService.addProduct(bTitle,bAuthor,bPrice,bCategoryID,bPublisher,url);
        resp.sendRedirect("product.jsp");

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String BID = req.getParameter("BID");
        Integer integer = Integer.valueOf(BID);
        productService.deleteProduct(integer);

    }
}
