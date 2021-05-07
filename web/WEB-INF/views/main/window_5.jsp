<%--
  Created by IntelliJ IDEA.
  User: s_com8599
  Date: 2021-05-07
  Time: 오전 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${Title}</title>
    <link href="/resources/css/base.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/base5.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="main_view">
        <div class="phone_input" onclick="location.href='../window18'">
            전화 번호 입력창<br>
            <input type="tel" id="phone" name="phone" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required/>
        </div>
        <br><button onclick="location.href='../window6'">확인</button>
    </div>
</body>
</html>
