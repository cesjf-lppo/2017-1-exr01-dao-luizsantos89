
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Pedido</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
        <%@include file="jspf/menu.jspf" %>
        <h1>Novo Pedido</h1>
        <div style ="color: red;">${mensagem}</div>
        <form method="post">
            <table>
                <tr>
                    <td>Pedido: </td>
                    <td><input type="text" name="pedido" placeholder="Digite o Pedido"/></td>
                </tr>
                <tr>
                    <td>Dono: </td>
                    <td><input type="text" name="dono" placeholder="Digite o Dono"/></td>
                </tr>
                <tr>
                    <td>Valor: </td>
                    <td><input type="text" name="valor" placeholder="Digite o Valor"/></td>
                </tr>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nome" placeholder="Digite o Nome"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right"><button type="submit">Enviar</button></td>
                </tr>
            </table>
        </form>
        </div>
    </center>
    </body>
</html>
