<%-- 
    Document   : novo-pedido
    Created on : 08/05/2017, 21:54:52
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Pedido</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <h1>Novo Pedido</h1>
        <div style ="color: red;">${mensagem}</div>
        <form method="post">
            <table>
                <tr>
                    <td>Pedido: </td>
                    <td><input type="text" name="pedido" placeholder="digite o pedido"/></td>
                </tr>
                <tr>
                    <td>Dono: </td>
                    <td><input type="text" name="dono" placeholder="digite o dono"/></td>
                </tr>
                <tr>
                    <td>Valor: </td>
                    <td><input type="text" name="valor" placeholder="digite o valor"/></td>
                </tr>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nome" placeholder=" digite o nome"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><button type="submit">Enviar</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
