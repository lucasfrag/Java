<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AdmEletronicos</title>
    </head>
    <body>
        <br><br><br><br><br><br><br><br><br><br>
        <h3 align="center">ALTERAR PRODUTO</h3>
        <form action="alterarProduto" method="post">
            <input type="hidden" name="id" value="${produto.id}" />
            <table align="center">
                <tr>
                    <td>
                        Produto:
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome" value="${produto.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Fabricante:
                    </td>
                    <td>
                        <input type="text" name="fabricante" id="fabricante" value="${produto.fabricante}" />
                    </td>
                </tr> 
                <tr>
                     <td>
                        Status:
                    </td>
                    <td>
                        <input checked="ok" type="radio" name="status" value='A'> Ativo
                        <input type="radio" name="status" id="status" value='I'/> Inativo
                        
                    </td>
                </tr> 
                <tr>
                    <td></td>
                    <td><input type="submit" value="Alterar"></td>    
                </tr>
            </table>              
        </form>
    </body>
</html>

