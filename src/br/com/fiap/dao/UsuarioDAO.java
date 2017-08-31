package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.*;

public class UsuarioDAO {
    private Connection connection;
    private PreparedStatement p;
    private ResultSet rs;
    private String sql;
    
    public boolean pesquisarUsuario(Usuario u){
       boolean compara = false;
       sql = "select * from JAVA_USUARIO WHERE login = ? and senha = ?";
       try{
           connection = Conexao.getConnection();
           p = connection.prepareStatement(sql);
           p.setString(1,u.getLogin());
           p.setString(2,u.getSenha());
           rs = p.executeQuery();
           compara = rs.next();
       } catch (SQLException ex) {
                showMessageDialog(null, "Login ou Senha inválidos.");
        }
       return compara;
        
    }

   
    
    
    
}
