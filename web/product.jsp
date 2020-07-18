<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/6/10
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="commin.jsp"></jsp:include>
<div align="center" style="display: inline;float: left;margin-left: 400px">
    <form>
        <table border="1" style="border: 1px solid darkorange">
            <thead>
            <tr style="background-color: darkorange">
                <th>书名</th>
                <th>作者</th>
                <th>类型</th>
                <th>单价</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="tbodys">

            </tbody>
        </table>

    </form>
</div>
<div style="margin-left: 800px;">
    <form action="/product" enctype="multipart/form-data" method="post" id="jjviav">
       <%--<label>图书名</label> <input type="text" name="BTitle"><br>--%>
        <%--<label>图书作者</label><input type="text" name="BAuthor"><br>--%>
        <%--<label>图书分类</label>--%>
        <%--<select name="BCategoryID" id="tbodysss">--%>

        <%--</select>--%>
        <%--<br>--%>
        <%--<label>图书售价</label> <input type="text" name="BPrice"><br>--%>
        <%--<label>图书出版社</label><input type="text" name="BPublisher"><br>--%>
        <%--<label>图书图片</label><input type="file" name="BPhoto"><br>--%>
        <%--<input type="hidden" name="method" value="addProduct">--%>
        <%--<input type="button" value="保存" onclick="addProduct()">--%>

        <table>
            <tr>
                <td>图书名称</td>
                <td><input type="text" name="BTitle"></td>
            </tr>
            <tr>
                <td>图书作者</td>
                <td><input type="text" name="BAuthor"></td>
            </tr>
            <tr>
                <td>图书分类</td>
                <td>
                    <select name="BCategoryID" id="tbodysss">

                </select></td>
            </tr>
            <tr>
                <td>图书售价</td>
                <td><input type="text" name="BPrice"</td>
            </tr>
            <tr>
                <td>图书出版社</td>
                <td><input type="text" name="BPublisher"></td>
            </tr>
            <tr>
                <td>图书图片</td>
                <td><input type="file" name="BPhoto" id="fisels"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="hidden" name="method" value="addProduct">
                    <input type="button" value="保存" onclick="addProduct()"></td>

            </tr>

        </table>
    </form>
</div>
<script src="js/jquery-3.4.1.js"></script>
<script>
    $(selectProductAll(),
    selectCategoryAll())
    function selectProductAll() {
        $.ajax({
            url:"/product?method=selectProductAll",
            method:"get",
            success:function (resp) {
                $("#tbodys").empty()
                for (var i=0;i<resp.length;i++) {
                    var r=resp[i];
                    var p="<tr>\n" +
                        "                    <td>"+r.bTitle+"</td>\n" +
                        "                    <td>"+r.bAuthor+"</td>\n" +
                        "                    <td>"+r.categoryinfo.cName+"</td>\n" +
                        "                    <td>"+r.bPrice+"</td>\n" +
                        "                    <td><a href=\"#\" onclick='deleteProduct("+r.bID+")'>删除</a>&nbsp;&nbsp;<a href=\"/product?method=selectOne&BID="+r.bID+"\">编辑</a></td>\n" +
                        "\n" +
                        "                </tr>"
                    $("#tbodys").append(p)
                }
            }
        })
    }
    function selectCategoryAll() {
        $.ajax({
            url:"category?method=selectCategoryAll",
            method:"get",
            success:function (resp) {
                $("#tbodysss").empty()
                for (var i=0;i<resp.length;i++) {
                    var r=resp[i];
                    var p="<option value=\""+r.cID+"\">"+r.cName+"</option>"
                    $("#tbodysss").append(p)
                }
            }
        })
    }
    function addProduct() {
       $("#jjviav").submit();
      selectProductAll();

    }
    function deleteProduct(BID) {
        $.ajax({
            url:"product?method=deleteProduct&BID="+BID,
            method:"get",
            success:function (resp) {
                selectProductAll();
            }
        })


    }
</script>
</body>
</html>
