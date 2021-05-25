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
    <link href="/resources/css/base6.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
    <div class="main_view">
        <div class="location_dvm">
            <div id="map"></div>
        </div>
        <div class="pre_code">
            선결제 코드 : ${RandomCode}
        </div>
    </div>
    <span style="display: none" id="LO">${LO}</span>
    <span style="display: none" id="LA">${LA}</span>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyARjEdHGJxyp7iLr6GYMAJWWhDQADh8hGc" async defer>
    </script>
    <script src="/resources/js/DVM.js"></script>
    <script src="/resources/js/window_6.js"></script>
</body>
</html>
