package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.contato.Contato;
import br.fiap.dao.ContatoDAO;

@WebServlet("/adicionarContato")
public class AdicionarContato extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dtaNasc = request.getParameter("dtaNasc");
		
		new ContatoDAO().inserir(new Contato(nome, email, endereco, dtaNasc));
	
	}
}
