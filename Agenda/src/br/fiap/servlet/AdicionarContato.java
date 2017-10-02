package br.fiap.servlet;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

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
		
		//Enviar uma mensagem para o navegador
		PrintWriter out = response.getWriter();
		out.println("<html><body>"
					+ "<head><style>body{ font-family: Helvetica;background: linear-gradient(to bottom right,#3498DB,#36D7B7);background-repeat: no-repeat;background-attachment: fixed;color: #fff;text-shadow: 1px 1px 5px black;}h1{text-align: left;}input{margin-top: 10px;box-shadow: 1px 1px 4px black;}.btnSalvar{margin-top: -10px;box-shadow: 1px 1px 1px black;}</style></head>"
					+ "Dados do "+nome+" inseridos com sucesso!"
					+ "</body></html>");
	}
}
