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
</head>
<body>
    <div class="main_view">
        <div class="img">
            <img id="img_result" src="${Drink}.png">
            <br>ㅇㅇ상품을 삭제하시겠습니까?
            <br><br><br>
            <button onclick="location.href = '../window12'">확인</button><button onclick="location.href = '../window14'">취소</button>
        </div>
    </div>
</body>
</html>
