package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements TransacaoBancaria {

    private String numeroConta;
    private double saldo;
    private String titular;
    private TipoConta tipoConta;
    private double valorDeposito;  private double valorSaque;

    public Conta(String numeroConta, String titular, TipoConta tipoConta, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.saldo = saldo; // Saldo inicial zerado
    }

    public double financiar(double valorFinanciamento, int parcelas, int anosPagamento , double taxaJuros) {

        if (valorFinanciamento <= 0) {
            System.out.println("Valor de financiamento inválido.");
            return 0;
        }
        double valorParcelas = valorFinanciamento/parcelas;
        double jurosMes = valorParcelas*taxaJuros;
        double totalMensal = jurosMes+valorParcelas;
        double totalFinanciamento = totalMensal*parcelas;
        double totalJuros = parcelas*jurosMes;

        if (totalMensal > getSaldo()) {
            System.out.println("Saldo insuficiente para o financiamento.");
            return 0;
        }

        // Realize o financiamento subtraindo o total financiado do saldo da conta.
        setSaldo(getSaldo() - totalMensal);

        DecimalFormat formato = new DecimalFormat("#.##");

        String totalMensalFormatado = formato.format(totalMensal);
        String totalFinanciamentoFormatado = formato.format(totalFinanciamento);

        String saldoFormatado = formato.format(getSaldo());

        System.out.println("Financiamento de R$" + valorFinanciamento + " realizado com sucesso.");
        System.out.println("Valor pago por mês: R$" + totalMensal);
        System.out.println("Total do valor em juros: R$" + totalJuros);

        return 0;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
            double novoSaldo = getSaldo() + valor;
            System.out.println("Saldo Disponível: " + novoSaldo);
        }
        else
        {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo()) {
            System.out.println("Saque de R$" + valor + " realizado com sucesso da conta salário.");
            double novoSaldo = getSaldo() - valor;
            System.out.println("Saldo disponível: " + novoSaldo);
        } else {
            System.out.println("Saque de R$" + valor + " inválido. Saldo insuficiente.");
            System.out.println("Saldo disponível: " + getSaldo());
        }
    }

    public double verificarSaldo(){
        System.out.println("Saldo atual da conta: R$" + getSaldo());
        return getSaldo();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    DecimalFormat formato = new DecimalFormat("#.##");

    public double getSaldo() {
        return saldo;
    }

    public String getTitular(){
        return titular;
    }

    public TipoConta getTipo() {
        return tipoConta;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

}
