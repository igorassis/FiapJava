package br.fiap.contato;

public class Contato {
	private String nome;
	private String email;
	private String endereco;
	private String dtaNasc;
	
	public Contato(String nome, String email, String endereco, String dtaNasc) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dtaNasc = dtaNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDtaNasc() {
		return dtaNasc;
	}

	public void setDtaNasc(String dtaNasc) {
		this.dtaNasc = dtaNasc;
	}
	
	
	
}
