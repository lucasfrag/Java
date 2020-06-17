<%-- 
    Document   : livros
    Created on : 04/06/2020, 16:22:14
    Author     : eduardo.reis
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros Web - Lista de Livros</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center">
                    <h1>Lista de Livros</h1>
                    
                    <!-- Tabela com as informações de cada livro cadastrado no sistema. -->
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Título</th>
                            <th>Autor</th>
                            <th>Ano de Lançamento</th>
                            <th>Estado de Conservação</th>
                            <th>Disponível</th>
                        </tr>
                        <!-- Criação da variável 'listaLivros', que é iterada pelo parâmetro 'forEach' de 'c'. 
                            Também é criada uma variável livro, que representará um objeto 'Livro' e alimentará os 
                            atributos da mesma classe.
                        -->
                        <c:forEach items="${listaLivros}" var="livro">
                            <tr>
                                <td>${livro.titulo}</td>
                                <td>${livro.autor}</td>
                                <td>${livro.anoLancamento}</td>
                                <td>${livro.estadoConservacao}</td>
                                <td>${livro.disponivel}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    
                    <a href="index" class="btn btn-secondary">Página inicial</a>
                </div>
            </div>
        </div>
    </body>
</html>
