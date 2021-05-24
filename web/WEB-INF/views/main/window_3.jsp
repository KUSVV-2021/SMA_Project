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
    <link href="/resources/css/base3.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <input class="input_code" type="text" placeholder="선결제 코드 입력" onclick="openKeyPad()"/>
        <br><button onclick="answerPrecodeInfo();">확인</button><button onclick="location.href='../window1'">취소</button>
    </div>
    <span style="display: none" id="Info">${Info}</span>
    <script src="/resources/js/DVM.js"></script>
    <script src="/resources/js/window_3.js"></script>
</body>
</html>
