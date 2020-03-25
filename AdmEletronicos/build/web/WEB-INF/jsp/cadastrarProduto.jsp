<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>AdmEletronicos</title>
    </head>
    <body>
        <br><br><br><br><br><br><br><br><br><br>
        <h3 align="center">CADASTRAR PRODUTO</h3>
        <form action="cadastrarProduto" method="post">
            <table align="center">
                <tr>
                    <td>
                        Produto:
                    </td>
                    <td>
                        <input type="text" name="nome" id="nome"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Fabricante:
                    </td>
                    <td>
                        <input type="text" name="fabricante" id="fabricante" />
                    </td>
                    </tr>
                    <tr>
                  <td align="right"><input type="submit" value="Salvar"></td>    
                </tr>
                
            </table>              
        </form>
    </body>
</html>
