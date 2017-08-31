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
import static javax.swing.JOptionPane.showMessageDialog;

public class ClienteDAO {
    private Connection connection;
    private PreparedStatement p;
    private ResultSet rs;
    private String sql;
    
    public void inserir(Cliente cliente){
        sql = "insert into java_cliente values(?, ?, ?, ?, ?, ?)";
        try {
            connection =  Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, cliente.getCpf());
            p.setString(2, cliente.getNome());
            p.setString(3, cliente.getEndereco());
            p.setDate(4, cliente.getNascimento());
            p.setString(5, cliente.getFone());
            p.setString(6, cliente.getFoto());
            p.execute();
        } catch (SQLException ex) {
                showMessageDialog(null, "Login ou Senha inválidos.");
        }
        
    }
    
    public Cliente pesquisar(String cpf){
        Cliente aux = null;
            
        sql = "select * from java_cliente where cpf = ?";
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(0, cpf);
            
            rs = p.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                Date nascimento = rs.getDate("nascimento");
                String fone = rs.getString("fone");
                String foto = rs.getString("fone");
                aux = new Cliente(cpf, nome, endereco, nascimento, fone, foto);
            }
            
        } catch (SQLException ex) {
            
        }
        
        return aux;
    }
}
