<%--
  Created by IntelliJ IDEA.
  User: zd
  Date: 2020/6/10
  Time: 11:24
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
    <table border="1" style="border: 1px solid darkorange">
        <thead>
        <tr style="background-color: darkorange">
        <th style="width: 200px;">
            图书分类
        </th>
        <th style="width:50px;">
            操作
        </th>
        </tr>
        </thead>
        <tbody id="tbodys" align="center">

        </tbody>
    </table>
</div>
<div style="margin-left: 800px;margin-top: 40px">
    <input type="text" name="CName" id="CName">
    <input type="button" value="添加" onclick="addCategory()">
</div>

<script src="js/jquery-3.4.1.js"></script>
<script>
    $(selectCategoryAll())
    function selectCategoryAll() {
        $.ajax({
            url:"category?method=selectCategoryAll",
            method:"get",
            success:function (resp) {
                $("#tbodys").empty()
                for (var i=0;i<resp.length;i++) {
                    var r=resp[i];
                    var p="<tr>\n" +
                        "                <td>"+r.cName+"</td>\n" +
                        "                <td><a href=\"#\" onclick=\"deleteCategory("+r.cID+")\">删除</a></td>\n" +
                        "            </tr>"
                    $("#tbodys").append(p)
                }
            }
        })
    }
    function addCategory() {
        var cname=$("#CName").val()
        $.ajax({
            url:"category?method=addCategory&CName="+cname,
            method:"get",
            success:function (resp) {

                if (resp=="") {
                    alert("该数据重复")
                    var cname=$("#CName").val("")
                }
                selectCategoryAll();
                var cname=$("#CName").val("")
            }
        })
    }
    function deleteCategory(CID) {

        $.ajax({
            url:"category?method=deleteCategory&CID="+CID,
            method:"get",
            success:function (resp) {

                selectCategoryAll();
            }
        })
    }
</script>
</body>
</html>
