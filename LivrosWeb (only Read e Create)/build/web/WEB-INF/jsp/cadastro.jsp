<%-- 
    Document   : cadastro
    Created on : 04/06/2020, 15:56:45
    Author     : eduardo.reis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros Web - Cadastro de Livros</title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col-sm-6">
                    <h1 class="text-center">Cadastro de Livros</h1>
                    <!-- Formulário para cadastro de novos livros -->
                    <form action="cadastro-salvar" method="POST">
                        <!-- Campo de texto responsável por receber o nome do livro. -->
                        <div class="form-group">
                            <label for="exampleInputEmail">Título:</label>
                            <input type="text" class="form-control" id="titulo" name="titulo"/>
                        </div>
                        <!-- Campo de texto responsável por receber o nome do autor do livro. -->
                        <div class="form-group">
                            <label for="autor">Autor:</label>
                            <input type="text" class="form-controle" id="autor" name="autor"/>
                        </div>
                        <!-- Campo numérico responsável por receber o ano de lançamento do livro. -->
                        <div class="form-group">
                            <label for="ano">Ano de lançamento</label>
                            <input type="number" min="1970" max="2050" class="form-control" id="ano" name="ano"/>
                        </div>
                        <!-- Select responsável por indicar o estado de conservação do livro. -->
                        <div class="form-group">
                            <label for="estado">Estado de conservação:</label>
                            <select class="form-control" id="estado" name="estado">
                                <option value="conservado">Conservado</option>
                                <option value="avariado">Avariado</option>
                            </select>
                        </div>
                        <!-- Radio-Buttons responsáveis por indicar a disponibilidade do livro. -->
                        <div class="form-group form-check">
                            <p>Disponível</p>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="disponivel" id="disponivel"/>
                                <label class="form-check-input" for="disponivel">Sim</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="disponivel" id="disponivel"/>
                                <label class="form-check label" for="disponivel">Não</label>
                            </div>
                        </div>
                        <!-- Botão responsável pelo envio dos dados do formulário. -->
                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <!-- Botão responsável por redirecionar para a página principal do programa. -->
                        <a href="index" class="btn btn-secondary" value="Voltar">Voltar</a>
                    </form>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </body>
</html>
