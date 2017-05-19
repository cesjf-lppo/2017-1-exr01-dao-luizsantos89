package br.cesjf.lppo.dao;

import br.cesjf.lppo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PedidoDAO {
     private final PreparedStatement opNovo;
     private final PreparedStatement opListar;
     private final PreparedStatement opListarFiltro;
     private final PreparedStatement opListarDono;
     private final PreparedStatement opValorTotalPedido;
     private final PreparedStatement opValorTotalDono;
     private final PreparedStatement opValorTotal;
     private final PreparedStatement opListaPedido;
     private final PreparedStatement opAtualiza;
     
     
     public PedidoDAO ()throws Exception{
        Connection conexao = ConnectionFactory.createConnection();
        opNovo  = conexao.prepareStatement("INSERT INTO Pedido (pedido, dono, valor, nome) VALUES(?, ?, ?, ?)");
        opListar = conexao.prepareStatement("SELECT * FROM Pedido");
        opValorTotal = conexao.prepareStatement("SELECT SUM(valor) FROM Pedido");
        opListarFiltro = conexao.prepareStatement("SELECT * FROM Pedido WHERE pedido = ?");
        opListarDono = conexao.prepareStatement("SELECT * FROM Pedido WHERE dono = ?");
        opValorTotalPedido = conexao.prepareStatement("SELECT SUM(valor) AS total FROM Pedido WHERE pedido = ?");
        opValorTotalDono = conexao.prepareStatement("SELECT SUM(valor) AS total FROM Pedido WHERE dono = ?");  
        opListaPedido = conexao.prepareStatement("SELECT * FROM Pedido WHERE Id = ?");
        opAtualiza = conexao.prepareStatement("UPDATE Pedido SET pedido = ?, dono = ?, valor = ?, nome = ?, atualizacao =  CURRENT_TIMESTAMP WHERE id = ?");
     }
     
    public void cria(Pedido novoPedido) throws Exception {
        try{
        opNovo.setInt(1, novoPedido.getPedido());
        opNovo.setString(2, novoPedido.getDono());
        opNovo.setFloat(3, novoPedido.getValor());
        opNovo.setString(4, novoPedido.getNome()); 
        opNovo.executeUpdate();
        
        }catch (SQLException ex){
            throw new Exception("Erro ao inserir o contato", ex);
        }
    }
    
    public void atualiza(Pedido novoPedido) throws Exception {
        try{
        opAtualiza.clearParameters();
        opAtualiza.setInt(1, novoPedido.getPedido());
        opAtualiza.setString(2, novoPedido.getDono());
        opAtualiza.setDouble(3, novoPedido.getValor());
        opAtualiza.setString(4, novoPedido.getNome());   
        opAtualiza.setLong(5,novoPedido.getId());
        opAtualiza.executeUpdate();
        
        }catch (SQLException ex){
            throw new Exception("Erro ao inserir o contato", ex);
        }
    }
    
    public Pedido listUnicoPedido(Long id) throws Exception{ 
        Pedido pedido = new Pedido();
        opListaPedido.setLong(1, id);
        ResultSet resultado = opListaPedido.executeQuery();        
        while(resultado.next()){
            pedido.setId(resultado.getLong(1));
            pedido.setPedido(resultado.getInt(2));
            pedido.setDono(resultado.getString(3));
            pedido.setValor(resultado.getLong(4));
            pedido.setNome(resultado.getString(5));
            pedido.setAtualizacao(resultado.getDate(6));
        }
        return pedido;
    }
     
    public List<Pedido> listAll() throws Exception{
        try {
            List<Pedido> pedidos = new ArrayList<>();
            ResultSet resultado = opListar.executeQuery();
                while(resultado.next()){
                    Pedido novoPedido = new Pedido();
                    novoPedido.setId(resultado.getLong("id"));
                    novoPedido.setPedido(resultado.getInt("pedido"));
                    novoPedido.setDono(resultado.getString("dono"));
                    novoPedido.setValor(resultado.getFloat("valor"));
                    novoPedido.setNome(resultado.getString("nome"));
                    novoPedido.setAtualizacao(resultado.getTimestamp("atualizacao"));                    
                    pedidos.add(novoPedido);
                }
            
            return pedidos;
        } catch (SQLException ex){
            throw new Exception("Erro ao listar contatos no banco", ex);
        }
    }
    
    public double totalPedido() throws Exception{
        try {
            ResultSet resultado = opValorTotal.executeQuery();
            double valor = 0;
            while(resultado.next()){
                valor = resultado.getDouble(1);
            }
            
            return valor;
        } catch (SQLException ex){
            throw new Exception("Erro ao retornar o valor total dos pedidos", ex);
        }
    }
    
    public double totalPedidoFiltro(Long filtro) throws Exception{
        try {
            double valor = 0;
            opValorTotalPedido.setLong(1, filtro);
            System.out.println(opValorTotalPedido);
            ResultSet resultado = opValorTotalPedido.executeQuery();
            while(resultado.next()){
                valor = resultado.getDouble(1);
            }            
            return valor;
        } catch (SQLException ex){
            throw new Exception("Erro ao retornar o valor total dos pedidos", ex);
        }
    }  
    
    public double totalPedidoDono(String filtro) throws Exception{
        try {
            double valor = 0;
            opValorTotalDono.setString(1, filtro);
            ResultSet resultado = opValorTotalDono.executeQuery();
            while(resultado.next()){
                valor = resultado.getDouble(1);
            }            
            return valor;
        } catch (SQLException ex){
            throw new Exception("Erro ao retornar o valor total dos pedidos", ex);
        }
    }   
    
    public List<Pedido> listPedido(Long filtro) throws Exception{
        try {
            List<Pedido> pedidos = new ArrayList<>();
            opListarFiltro.setLong(1, filtro);
            ResultSet resultado = opListarFiltro.executeQuery();
                while(resultado.next()){
                    Pedido novoPedido = new Pedido();
                    novoPedido.setId(resultado.getLong("id"));
                    novoPedido.setPedido(resultado.getInt("pedido"));
                    novoPedido.setDono(resultado.getString("dono"));
                    novoPedido.setValor(resultado.getFloat("valor"));
                    novoPedido.setNome(resultado.getString("nome"));
                    novoPedido.setAtualizacao(resultado.getTimestamp("atualizacao"));                    
                    pedidos.add(novoPedido);
                }            
            return pedidos;
        } catch (SQLException ex){
            throw new Exception("Erro ao listar contatos no banco", ex);
        }
    }
    
    public List<Pedido> listDono(String filtro) throws Exception{
        try {
            List<Pedido> pedidos = new ArrayList<>();
            opListarDono.setString(1, filtro);
            ResultSet resultado = opListarDono.executeQuery();
                while(resultado.next()){
                    Pedido novoPedido = new Pedido();
                    novoPedido.setId(resultado.getLong("id"));
                    novoPedido.setPedido(resultado.getInt("pedido"));
                    novoPedido.setDono(resultado.getString("dono"));
                    novoPedido.setValor(resultado.getFloat("valor"));
                    novoPedido.setNome(resultado.getString("nome"));
                    novoPedido.setAtualizacao(resultado.getTimestamp("atualizacao"));                    
                    pedidos.add(novoPedido);
                }            
            return pedidos;
        } catch (SQLException ex){
            throw new Exception("Erro ao listar contatos no banco", ex);
        }
    }
}
