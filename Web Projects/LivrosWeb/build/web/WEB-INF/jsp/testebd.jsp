<%-- 
    Document   : testebd
    Created on : 17/06/2019, 06:55:44
    Author     : vanessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste de operação BD</title>
    </head>
    <body>
        <h1>Teste de produtos</h1>
        <c:forEach items="${listaLivros}" var="livro">
            <p>$(livro.titulo) - $(livro.autor), $(livro.ano)</p>
            </c:forEach>
    </body>
</html>
