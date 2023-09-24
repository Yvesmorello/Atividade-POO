package org.example;

public class Cliente {

    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public java.lang.String getDocumento() {
        return documento;
    }
}

