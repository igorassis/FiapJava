/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author logonpf
 */
public class ClienteDAO {
    private Connection connection;
    private PreparedStatement p;
    private ResultSet rs;
    private String sql;
    
    public boolean inserir(Cliente cliente) {
        boolean status = false;
        sql = "insert into java_cliente values (?, ?, ?, ?, ?, ?)";
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, cliente.getCpf());
            p.setString(2, cliente.getNome());
            p.setString(3, cliente.getEndereco());
            p.setDate(4, cliente.getNascimento());
            p.setString(5, cliente.getFone());
            p.setString(6, cliente.getFoto());
            p.execute(); //p.executeUpdate();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente\n"+ex);
        }
        return status;
    }
    
    public Cliente pesquisar(String cpf) {
        Cliente aux = null;
        sql = "select * from java_cliente where cpf = ?";
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, cpf);
            rs = p.executeQuery();
            if(rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                Date nascimento = rs.getDate("nascimento");
                String fone = rs.getString("fone");
                String foto = rs.getString("foto");
                aux = new Cliente(cpf, nome, endereco, nascimento, fone, foto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aux;
    }

    public boolean alterar(Cliente cliente){
        boolean status = false;
        sql = "update java_cliente set nome = ?, endereco = ?, nascimento = ?, fone = ?, foto = ? where cpf = ?";
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);          
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setDate(3, cliente.getNascimento());
            p.setString(4, cliente.getFone());
            p.setString(5, cliente.getFoto());
            p.setString(6, cliente.getCpf());
            p.execute();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados do cliente no banco\n"+ex);
        }
        return status;
    }
    
    public List<Cliente> listarCliente() {
        List<Cliente> lista = null;
        connection = Conexao.getConnection();
        sql = "select * from java_cliente";
        try {
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();
            lista = gerarLista(rs);
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos os clientes\n"+e);
        }
        return lista;
    }

    public List<Cliente> gerarLista(ResultSet rs) throws SQLException {
        List<Cliente> lista = new ArrayList();
        String cpf, nome, endereco, foto, fone;
        Date nascimento;
        while(rs.next()) {
            cpf = rs.getString("cpf");
            nome = rs.getString("nome");
            endereco = rs.getString("endereco");
            nascimento = rs.getDate("nascimento");
            fone = rs.getString("fone");
            foto = rs.getString("foto");
            lista.add(new Cliente(cpf, nome, endereco, nascimento, fone, foto));            
        }
        return lista;
    }
    
    public boolean excluir(String cpf){
        boolean status = false;
        sql = "delete from java_cliente where cpf = ?";
        try{
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, cpf);
            p.execute();
            status = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!");
        }
        return status;
    }

}
