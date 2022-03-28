<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
<#--    <link rel="stylesheet" type="text/css" th:href="@{static/layui/css/layui.css}">-->
</head>
<body>
<form method="POST" action="/user/login">
    <div>
        用户名：<input type="text" name="username" id="username">
    </div>
    <div>
        密码：<input type="password" name="password" id="password">
    </div>
    <div>
        <button type="submit">立即登陆</button>
    </div>
    <!-- 以下为显示认证失败等提示信息（th:if=""一定要写 ）-->
<#--    <span style="color: red;" th:if="${param.error}" th:text="${session.SPRING_SECURITY_LAST_EXCEPTION.message}"></span>-->
</form>
</body>
</html>