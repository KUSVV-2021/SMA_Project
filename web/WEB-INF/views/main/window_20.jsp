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
</head>
<body>
    <div class="main_view">
        <div class="number">
            입력하신 번호는<br>
            ${Number} 입니다.
        </div>
        <br><button onclick="location.href='../window7'">확인</button><button onclick="location.href='../window${PageNum}'">취소</button>
    </div>
    <script src="/resources/js/window_7.js"></script>
</body>
</html>
