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
    <link href="/resources/css/base16.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <div class="img"><br>
            <span id="Drink">${Drink}</span>
            <br><br>현재 가격 : <input type="number" id="price" onclick="openKeyPad('price')">
            <br><br>현재 재고 : <input type="number" id="left" onclick="openKeyPad('left')">
            <br><br><br>
            <button onclick="changeStock()">확인</button><button onclick="backToPage()">취소</button>
        </div>
    </div>
    <script src="/resources/js/DVM.js"></script>
    <script src="/resources/js/window_16.js"></script>
</body>
</html>
