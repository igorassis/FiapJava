/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author paesv
 */
public class UsuarioDAO {
    private Connection connection;
    private PreparedStatement p;
    private ResultSet rs;
    private String sql;
    
    public boolean pesquisarUsuario(Usuario usuario) throws SQLException{
        boolean achou = false;
        
        sql = "select * from java_usuario where login = ? and password = ?";
        
        try {
            connection = Conexao.getConnection();
            p = connection.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getSenha());
            rs = p.executeQuery();
            achou = rs.next();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         
        return achou;
    }
}
