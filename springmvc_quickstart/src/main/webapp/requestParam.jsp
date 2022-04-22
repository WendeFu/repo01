<%--
  Created by IntelliJ IDEA.
  User: fuwende
  Date: 2022/3/8
  Time: 上午9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/simpleParam?id=1&username=杰克">
        基本数据类型
    </a>

    <form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
        编号:<input type="text" name="id"> <br>
        用户名:<input type="text" name="username"> <br>
        <input type="submit" value="对象类型">
    </form>

    <form action="${pageContext.request.contextPath}/user/arrayParam">
        编号:<br>
        <input type="checkbox" name="ids" value="1">一<br>
        <input type="checkbox" name="ids" value="2">二<br>
        <input type="checkbox" name="ids" value="3">三<br>
        <input type="checkbox" name="ids" value="4">四<br>
        <input type="checkbox" name="ids" value="5">五<br>
        <input type="submit" value="数组类型">
    </form>

    <form action="${pageContext.request.contextPath}/user/queryParam" method="post">
        搜索关键字：
        <input type="text" name="keyword"/><br>
        user对象：
        <input type="text" name="user.id" placeholder="编号"/>
        <input type="text" name="user.username" placeholder="姓名"/><br>
        list集合<br>
        第一个元素:
        <input type="text" name="userList[0].id" placeholder="编号"/>
        <input type="text" name="userList[0].username" placeholder="姓名"/><br>
        第二个元素:
        <input type="text" name="userList[1].id" placeholder="编号"/>
        <input type="text" name="userList[1].username" placeholder="姓名"/><br>
        map集合<br>
        第一个元素:
        <input type="text" name="userMap['u1'].id" placeholder="编号"/>
        <input type="text" name="userMap['u1'].username" placeholder="姓名"/><br>
        第二个元素:
        <input type="text" name="userMap['u2'].id" placeholder="编号"/>
        <input type="text" name="userMap['u2'].username" placeholder="姓名"/><br>
        <input type="submit" value="复杂类型">
    </form>

    <form action="${pageContext.request.contextPath}/user/converterParam">
        生日：<input type="text" name="birthday"/>
        <input type="submit" value="自定义类型转换器">
    </form>

    <a href="${pageContext.request.contextPath}/user/findByPage?pageNo=2">
        分页查询
    </a><br>
    <a href="${pageContext.request.contextPath}/user/requestHead">
        获取请求头的数据
    </a><br>
    <a href="${pageContext.request.contextPath}/user/cookieValue">
        获取cookie中的数据
    </a><br>

    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <button id="btn1">ajax异步提交</button>
    <button id="btn2">ajax异步提交2</button>
    <script>
        $("#btn1").click(function () {
            let url = '${pageContext.request.contextPath}/user/ajaxRequest';
            let data = '[{"id":1,"username":"张三"},{"id":2,"username":"李四"}]';
            $.ajax({
                    type: 'POST',
                    url: url,
                    data: data,
                    contentType: 'application/json;charset=utf-8',
                    success: function (resp) {
                        alert(JSON.stringify(resp));
                        alert(resp);
                    }
                })
            })
        $("#btn2").click(function () {
            let url = '${pageContext.request.contextPath}/user/ajaxRequest';
            let data = '[{"id":1,"username":"张三"},{"id":2,"username":"李四"}]';
            $.ajax({
                type: 'POST',
                url: url,
                data: data,
                contentType: 'application/json;charset=utf-8',
                dataType:"text",
                success: function (resp) {
                    /*alert(JSON.stringify(resp))*/
                    alert(resp);
                }
            })
        })
    </script>
</body>
</html>
