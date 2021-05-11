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
    <link href="/resources/css/base13.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <div class="img">
            이미지
            <br><img id="img_result"><br><input type="file" id="img" name="img" accept="image/png, image/jpeg">
            <br>상품명 : <input type="text" id="name">
            <br>상품 가격 : <input type="number" id="price">
            <br><br><br>
            <button onclick="addItem()">확인</button><button onclick="location.href = '../window12'">취소</button>
        </div>
    </div>
    <script src="/resources/js/window_13.js"></script>
</body>
</html>
