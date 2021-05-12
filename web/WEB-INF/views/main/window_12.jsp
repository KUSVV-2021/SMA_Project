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
    <link href="/resources/css/base12.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <table class="menu_ui">
            <tr>
                <td colspan="3">
                    <button onclick="addButton()" class="admin_btn">추가</button>
                    <button onclick="location.href='../window14'" class="admin_btn">삭제</button>
                    <button onclick="location.href='../window17'" class="admin_btn">판매 내역 확인</button>
                    <button onclick="location.href='../window1'" class="admin_btn">x</button>
                </td>
            </tr>
            <tr><td><img src="/resources/img/pepsi.png"></td><td><img src="/resources/img/coke.png"></td><td><img src="/resources/img/pepsi.png"></td></tr>
            <tr><td><img src="/resources/img/coke.png"></td><td><img src="/resources/img/pepsi.png"></td><td><img src="/resources/img/coke.png"></td></tr>
            <tr><td><img src="/resources/img/pepsi.png"></td><td><img src="/resources/img/coke.png"></td><td><img src="/resources/img/pepsi.png"></td></tr>
            <tr>
                <td colspan="3">
                    <div class="fit_contents">
                        <button class="round_btn menu_btn">1</button>
                        <button class="round_btn menu_btn">2</button>
                        <button class="round_btn menu_btn">3</button>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <script src="/resources/js/window_12.js"></script>
</body>
</html>
