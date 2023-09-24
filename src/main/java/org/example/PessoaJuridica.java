package org.example;

public class PessoaJuridica extends Cliente {

    private String cnpj;

    public PessoaJuridica(String nome, String documento, String cnpj) {
        super(nome, documento);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

}
