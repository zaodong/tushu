<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/6/10
  Time: 10:43
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
