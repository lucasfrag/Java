<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>AdmEletronicos</title>
    </head>    
    <body>
        <form action="filtrarProdutos" method="post">
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
                  <td></td>
                  <td><input type="submit" value="Buscar"></td>    
              </tr>
          </table>              
      </form>
        <div align="center">
            <a href="novoProduto">CRIAR NOVO PRODUTO</a>
        </div>
       

      <br /> <br />        

      <c:if test="${produtos.size() > 0}">
        <table align="center" border="1px" text-align="center">
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Fabricante</th> 
          <th>Status</th>
          <th></th>
          <th></th>
        </tr>
        <c:forEach items="${produtos}" var="p">
          <tr align="center">
            <td>${p.id}</td>
            <td>${p.nome}</td>
            <td>${p.fabricante}</td>
            <td>${p.status}</td>
            <td><a href="mostrarProduto?id=${p.id}">EDITAR</a></td>
            <td><a href="removerProduto?id=${p.id}">EXCLUIR</a></td>
          </tr>
        </c:forEach>
        </table>

      </c:if>
    </body>
</html>
