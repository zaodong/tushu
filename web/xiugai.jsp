<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/6/10
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="commin.jsp"></jsp:include>
<div align="center">
    <form action="/product" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td>图书名称</td>
                <td><input type="text" name="BTitle" value="${product.BTitle}"></td>
            </tr>
            <tr>
                <td>图书作者</td>
                <td><input type="text" name="BAuthor" value="${product.BAuthor}"></td>
            </tr>
            <tr>
                <td>图书分类</td>
                <td><select name="BCategoryID" id="tbodysss">
                    <c:forEach items="${category}" var="c">
                        <option value="${c.CID}" <c:if test="${product.BCategoryID==c.CID}">selected="selected"</c:if>>${c.CName}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>图书售价</td>
                <td><input type="text" name="BPrice" value="${product.BPrice}"></td>
            </tr>
            <tr>
                <td>图书出版社</td>
                <td><input type="text" name="BPublisher" value="${product.BPublisher}"></td>
            </tr>
            <tr>
            <td>图书图片</td>
            <td><img src="${product.BPhoto}" id="imgurl" style="width: 100px;height: 120px"></td>
        </tr>
            <tr>
                <td>新图书图片</td>
                <td><input type="file" name="BPhoto" id="fisels"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="hidden" name="method" value="updateProduct">
                    <input type="hidden" name="BID" value="${product.BID}">
                    <input type="submit" value="保存" ></td>

            </tr>

        </table>

    </form>
</div>
<script src="js/jquery-3.4.1.js"></script>
<script>

</script>
</body>
</html>
