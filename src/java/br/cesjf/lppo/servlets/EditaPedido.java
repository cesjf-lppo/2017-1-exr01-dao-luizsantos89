
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Pedido;
import br.cesjf.lppo.dao.PedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditaPedido", urlPatterns = {"/edita.html"})
public class EditaPedido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Pedido pedido = new Pedido();
        try {
            PedidoDAO dao = new PedidoDAO();
            pedido = dao.listUnicoPedido(id);
        } catch (Exception ex) {
            Logger.getLogger(ListaPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
            pedido = new Pedido();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("pedido", pedido);
        request.getRequestDispatcher("/WEB-INF/edita-pedido.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pedido novoPedido = new Pedido();
        novoPedido.setPedido(Integer.parseInt(request.getParameter("pedido")));
        novoPedido.setDono(request.getParameter("dono"));
        novoPedido.setValor(Float.parseFloat(request.getParameter("valor")));
        novoPedido.setNome(request.getParameter("nome"));
        novoPedido.setId(Long.parseLong(request.getParameter("id")));
        
        try {
            PedidoDAO dao = new PedidoDAO();
            dao.atualiza(novoPedido);
        } catch (Exception ex) {
            Logger.getLogger(ListaPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
            novoPedido = new Pedido();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        response.sendRedirect("pedidos.html");
    }
}
