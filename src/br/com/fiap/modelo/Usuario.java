package br.com.fiap.modelo;

public class Usuario {
private String cpf;
private String nome;
private String login;
private String senha;

    public Usuario(String cpf, String nome, String login, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
 
    
 
}