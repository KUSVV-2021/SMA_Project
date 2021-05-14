<%--
  Created by IntelliJ IDEA.
  User: s_com8599
  Date: 2021-05-13
  Time: 오후 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>${Title}</title>
    <link href="/resources/css/base.css" rel="stylesheet" type="text/css">
    <link href="/resources/css/payment.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<!--// mode : development or production-->
<script src="https://nsp.pay.naver.com/sdk/js/naverpay.min.js"
        data-client-id="u86j4ripEt8LRfPGzQ8"
        data-mode="production"
        data-merchant-user-key="가맹점 사용자 식별키"
        data-merchant-pay-key="가맹점 주문 번호"
        data-product-name="상품명을 입력하세요"
        data-total-pay-amount="1000"
        data-tax-scope-amount="1000"
        data-tax-ex-scope-amount="0"
        data-return-url="../payment">
</script>

</body>
</html>

<body>

</body>
</html>
