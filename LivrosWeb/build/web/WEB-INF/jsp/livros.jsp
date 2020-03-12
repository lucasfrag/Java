<%-- 
    Document   : livros
    Author     : vanessa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros Web - Lista de Livros</title>
    </head>
    <body>
        <font face="Calibri">
        <h1 align="center">Lista de Livros</h1>
        <table border=1 align="center">
                <th bgcolor="B0 C4 DE">Título</th>
                <th bgcolor="B0 C4 DE">Autor</th>
                <th bgcolor="B0 C4 DE">Ano de Lançamento</th>
                <th bgcolor="B0 C4 DE">Estado de Conservação</th>
                <th bgcolor="B0 C4 DE">Disponivel</th>
                <th bgcolor="B0 C4 DE">Ação</th>
                <th bgcolor="B0 C4 DE">Ação</th>
            
            <c:forEach items="${listaLivros}" var="livro">
                <tr align="center" bgcolor="B0 E0 E6"> 
                    <td>${livro.titulo}</td>
                    <td>${livro.autor}</td>
                    <td>${livro.ano}</td>
                    <td>${livro.estado}</td>
                    <td>${livro.disponivel}</td>
                    <td><a href="editar?id=${livro.id}&autor=${livro.autor}&titulo=${livro.titulo}">Alterar</a></td>
                    <td><a href="removerProduto?id=${livro.id}">Remover</a></td>
                </tr>
            </c:forEach>
        </table> <br> <br>
        <div align="center">
                <a href="index">Página Inicial</a>
             </div>
        </font>
    </body>
</html>