
package br.com.fiap.modelo;

import java.sql.Date;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private Date nascimento;
    private String fone;
    private String foto;

    public Cliente(String cpf, String nome, String endereco, Date nascimento, String fone, String foto) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.fone = fone;
        this.foto = foto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
