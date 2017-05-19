package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Pedido;
import br.cesjf.lppo.dao.PedidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetalhesPedido", urlPatterns = {"/detalhes.html"})
public class DetalhesPedido extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long pedido = null;
        
        if (request.getParameter("pedido")!=null) {
            pedido = Long.parseLong(request.getParameter("pedido"));    
        }
        
        String dono = request.getParameter("dono");
        
        System.out.println(dono);
        
        List<Pedido> pedidos;
        String resultado = null;
        
        if (dono==null) {
            try {
                PedidoDAO dao = new PedidoDAO();
                pedidos = dao.listPedido(pedido);
                resultado = dao.totalPedidoFiltro(pedido);
            } catch (Exception ex) {
                Logger.getLogger(ListaPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
                pedidos = new ArrayList<>();
                request.setAttribute("mensagem", ex.getLocalizedMessage());
            }
            request.setAttribute("pedido", pedido);
            request.setAttribute("pedidos" , pedidos);
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("/WEB-INF/detalha-pedido.jsp").forward(request, response);
        } else {
            try {
                PedidoDAO dao = new PedidoDAO();
                pedidos = dao.listDono(dono);
                resultado = dao.totalPedidoDono(dono);
            } catch (Exception ex) {
                Logger.getLogger(ListaPedidoServlet.class.getName()).log(Level.SEVERE, null, ex);
                pedidos = new ArrayList<>();
                request.setAttribute("mensagem", ex.getLocalizedMessage());
            }
            request.setAttribute("dono", dono);
            request.setAttribute("pedidos" , pedidos);
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("/WEB-INF/detalha-dono.jsp").forward(request, response);
        }

            
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
