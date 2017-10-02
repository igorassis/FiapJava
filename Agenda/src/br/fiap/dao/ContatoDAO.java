package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.contato.Contato;

public class ContatoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement p;
	private ResultSet rs;
	
	public void inserir(Contato contato){
		sql="insert into java_agenda values(?, ?, ?, ?)";
		try{
			connection = Conexao.getConnection();
			p = connection.prepareStatement(sql);
			p.setString(1, contato.getNome());
			p.setString(2, contato.getEmail());
			p.setString(3, contato.getEndereco());
			p.setString(4, contato.getDtaNasc());
			p.execute();
		}catch(SQLException e){
			
		}
	}
	
	private List<Contato> listarContato(){
		List<Contato> lista = null;
		String nome, email, endereco, DtaNasc;
		
		sql = "select * from java_agenda";
		try{
			connection = Conexao.getConnection();
			p = connection.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()){
				nome = rs.getString("nome");
				email = rs.getString("email");
				endereco = rs.getString("endereco");
				DtaNasc = rs.getString("dtanasc");
				lista.add(new Contato(nome, email, endereco, DtaNasc));
			}
		}catch(SQLException e){
			
		}
		return lista;
	}
	
}
