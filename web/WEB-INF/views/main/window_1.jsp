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
    <link href="/resources/css/base1.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        결제 카드를 삽입해주세요<br>
        <input onclick="location.href='../window3'" class="input_code" type="text" placeholder="선결제 코드 입력"/>
        <br><br><br>
        <button onclick="chgDVMNumber()">DVM바꾸기</button><button onclick="openKeyPad()">보안코드입력</button>
    </div>
    <script src="/resources/js/window_1.js"></script>
</body>
</html>
