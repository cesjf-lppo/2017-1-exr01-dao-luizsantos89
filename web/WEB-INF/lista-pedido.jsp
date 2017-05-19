<%-- 
    Document   : lista-pedido
    Created on : 08/05/2017, 22:12:55
    Author     : alunoces
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Pedido</title>
    </head>
    <body>
        <h1>Lista Pedido</h1>
         <table border="1">
            
            <tr>
                <th>ID</th>
                <th>Pedido</th>
                <th>Dono</th>
                <th>Nome</th>
                <th>Atualizacao</th>
                <th>Valor</th>
                
            </tr>
            <c:forEach var="pedido" items="${pedidos}">
                <tr>
                    <td>
                        <a href="edita.html?id=${pedido.id}" 
                           title="Edita os dados desse pedido">
                        ${pedido.id} </a>
                    </td> 
                    <td>
                        <a href="detalhes.html?pedido=${pedido.pedido}" 
                           title="Buscar todos os itens relacionados a este pedido">
                        ${pedido.pedido}</a></td> 
                    <td><a href="detalhes.html?dono=${pedido.dono}" 
                           title="Buscar todos os itens relacionados a este dono">
                            ${pedido.dono}</a></td> 
                    <td>${pedido.nome}</td>
                    <td>${pedido.atualizacao}</td>
                    <td>${pedido.valor}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">Total:</td>
                <td>
                    ${resultado}                  
                </td>
            </tr>
         </table>
        <a href="novo.html">Novo Pedido</a>
    </body>
</html>
