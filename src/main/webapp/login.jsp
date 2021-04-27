<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">

</form>

</body>

</html>