    <%-- 
    Document   : cadastro-salvar
    Created on : 04/06/2020, 12:31:39
    Author     : eduardo.reis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros Web - Cadastro Salvar</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <style>
            div {
                padding: 10px;
            }
        </style>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col-6 text-center">
                    <h3>Dados do livro salvos com sucesso!</h3>
                    <!-- Botão responsável por redirecionar para a página com a lista de livros cadastrados. -->
                    <a type="button" class="btn btn-primary btn-block" href="lista">Ver lista</a>
                    <!-- Botão responsável por redirecionar para a página principal do programa. -->
                    <a type="button" class="btn btn-primary btn-block" href="index">Página inicial</a>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </body>
</html>
