<%-- 
    Document   : editar
    Created on : 09/11/2019, 07:50:38
    Author     : vanessa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1>Edição de Livros</h1>
        <form method="POST" action="editarBD">
            <input type="hidden" name="id" value="${id}"/>
            <legend>Título</legend>
            <input type="text" name="titulo" value="${titulo}"/>
            <legend>Autor</legend>
            <input type="text" name="autor" value="${autor}"/>
            <input type="submit" value="Editar"/>
        </form>
    </body>
</html>
