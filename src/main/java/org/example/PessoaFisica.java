package org.example;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String documento, String cpf){
        super(nome, documento);
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

}
