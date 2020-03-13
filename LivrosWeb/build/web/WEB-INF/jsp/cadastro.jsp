<%-- 
    Document   : cadastro
    Created on : 
    Author     : vanessa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros Web - Cadastro de Livros</title>
    </head>
    <body>
        <font face="Calibri">
        <h1 align= "center"> Cadastro de Livro</h1>
        <form action="cadastro-salvar">
            <table border="1" align="center">
                <tr bgcolor="B0 E0 E6">
                    <td>
                        <br>
                        <b>Título:</b><br>
                        <input type="text" name="titulo" size="50" maxlength="100"> <br> <br>
                        <b>Autor:</b><br>
                        <input type="text" name="autor" size="50" maxlength="100"> <br> <br>
                        <b>Ano de Lançamento:</b><br>
                        <input type="number" name="ano" min= "1700" max="2050" size= "50" maxlength="100"> <br> <br>
                        <b>Estado de Conservação:</b><br>
                        <select name="estado">
                            <option value="Danificado">Danificado</option>
                            <option value="Regular">Regular</option>
                            <option value="Bom">Bom</option>
                            <option value="Excelente">Excelente</option>
                        </select> <br> <br>
                       <b>Disponível:</b><br>
                        <input type="radio" name="disponivel" value="sim"> Sim <br> 
                        <input type="radio" name="disponivel" value="não"> Não <br> <br>
                    </td>
                </tr>
            </table>
            <br> <br>
            <div align="center">
                <button align="center">Salvar</button> <br> <br>
                <a href="index">Página Inicial</a>
             </div>
        </form>
        <a href="index" align="center" value="< Voltar"></a>      
      </font>
      
     </body>
     
</html>
