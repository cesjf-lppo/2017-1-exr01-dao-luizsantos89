
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pedido</title>
        <link rel="stylesheet" href="CSS/estilo.css"/>
    </head>
    <body>
    <center>
        <div id="pagina">
        <%@include file="jspf/menu.jspf" %>
        <h1> Editar pedido ${pedido.pedido} </h1>
        
        <form method="post">
            <table>
                <tr>
                    <td>Pedido: </td>
                    <td><input type="text" name="pedido" value="${pedido.pedido}"/></td>
                </tr>
                <tr>
                    <td>Dono: </td>
                    <td><input type="text" name="dono" value="${pedido.dono}"/></td>
                </tr>
                <tr>
                    <td>Valor: </td>
                    <td><input type="text" name="valor" value="${pedido.valor}"/></td>
                </tr>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nome" value="${pedido.nome}"/></td>
                </tr>
                <tr>
                    <td><a href="lista.html"><button>Cancelar</button></a></td>
                    <td align="right"><button type="submit">Enviar</button></td>
                </tr>
                <input type="hidden" name="id" value="${pedido.id}" />
            </table>   
        </form>
        </div>
    </center>
    </body>
</html>
