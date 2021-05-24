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
    <link href="/resources/css/base2.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <table class="menu_ui">
            <tr>
                <td colspan="3">
                    <button onclick="addButton()" class="admin_btn">추가</button>
                    <button id="openDelMenu" class="admin_btn">삭제</button>
                    <button id="getPaymentList" class="admin_btn">판매 내역 확인</button>
                    <button onclick="location.href='../window1'" class="admin_btn">x</button>
                </td>
            </tr>
            <tr><td><div class="drink" id="1"></div></td>
                <td><div class="drink" id="2"></div></td>
                <td><div class="drink" id="3"></div></td></tr>
            <tr><td><div class="drink" id="4"></div></td>
                <td><div class="drink" id="5"></div></td>
                <td><div class="drink" id="6"></div></td></tr>
            <tr><td><div class="drink" id="7"></div></td>
                <td><div class="drink" id="8"></div></td>
                <td><div class="drink" id="9"></div></td></tr>
            <tr>
                <td colspan="3">
                    <div class="fit_contents">
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <span style="display: none" id="Data">${Data}</span>
    <script src="/resources/js/DVM.js"></script>
    <script src="/resources/js/window_12.js"></script>
</body>
</html>
