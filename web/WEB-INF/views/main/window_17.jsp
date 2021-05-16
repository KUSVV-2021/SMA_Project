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
    <link href="/resources/css/base17.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <div class="list">
            <table>
                <tr>
                    <th>음료</th><th>개수</th><th>총 금액</th>
                </tr>
                <tr><td><div class="drink" id="1"></div></td><td><div class="count" id="count1"></div></td><td><div class="sum" id="sum1"></div></td></tr>
                <tr><td><div class="drink" id="2"></div></td><td><div class="count" id="count2"></div></td><td><div class="sum" id="sum2"></div></td></tr>
                <tr><td><div class="drink" id="3"></div></td><td><div class="count" id="count3"></div></td><td><div class="sum" id="sum3"></div></td></tr>
                <tr><td><div class="drink" id="4"></div></td><td><div class="count" id="count4"></div></td><td><div class="sum" id="sum4"></div></td></tr>
                <tr><td><div class="drink" id="5"></div></td><td><div class="count" id="count5"></div></td><td><div class="sum" id="sum5"></div></td></tr>
                <tr><td><div class="drink" id="6"></div></td><td><div class="count" id="count6"></div></td><td><div class="sum" id="sum6"></div></td></tr>
                <tr><td><div class="drink" id="7"></div></td><td><div class="count" id="count7"></div></td><td><div class="sum" id="sum7"></div></td></tr>
                <tr><td><div class="drink" id="8"></div></td><td><div class="count" id="count8"></div></td><td><div class="sum" id="sum8"></div></td></tr>
                <tr><td><div class="drink" id="9"></div></td><td><div class="count" id="count9"></div></td><td><div class="sum" id="sum9"></div></td></tr>
                <tr>
                    <td colspan="3">
                        <div class="fit_contents">
                        </div>
                    </td>
                </tr>
            </table>
            <button onclick="backToPage()">확인</button>
        </div>
    </div>
    <span style="display: none" id="Data">${Data}</span>
<script src="/resources/js/window_17.js"></script>
</body>
</html>
