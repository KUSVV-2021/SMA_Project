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
    <link href="/resources/css/base4.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <div class="choice_menu_text">음료가 ${LO}, ${LA}에 준비 되어 있습니다.</div>
        <br><button onclick="location.href='../window6'">선결제</button><button onclick="moveTo2()">취소</button>
    </div>
<script src="/resources/js/window_4.js"></script>
</body>
</html>
