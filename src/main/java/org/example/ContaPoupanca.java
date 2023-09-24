package org.example;

import java.text.DecimalFormat;

public class ContaPoupanca extends Conta {

    private double saldo;


    public ContaPoupanca(String numeroConta, String titular, TipoConta tipoConta, double saldo) {
        super(numeroConta, titular, TipoConta.POUPANCA, saldo);
    }

    @Override
    public double verificarSaldo(){
        System.out.println("Saldo atual da conta: R$" + getSaldo());
        return getSaldo();
    }

    @Override
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
        System.out.println("Valor pago por mês: R$" + totalMensalFormatado);
        System.out.println("Valor total do financiamento: R$" + totalFinanciamentoFormatado);
        System.out.println("Total do valor em juros: R$" + totalJuros);

        System.out.println("Saldo: "+ saldoFormatado);

        return 0;
    }

        public double abrirConta(){
           if (getSaldo() < 50.0) {
                System.out.println("A conta poupança deve ser aberta com um saldo mínimo de R$50.0" );
                System.out.println("Valor apresentado para abertura da conta: R$" + getSaldo() + ".");
             }
           else if (getSaldo() >= 50.0){
               System.out.println("Conta Poupança aberta com sucesso!");
               System.out.println("Saldo disponível: R$" + getSaldo() + ".");
           }
           return getSaldo();
        }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo()) {
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            double novoSaldo = getSaldo() - valor;
            System.out.println("Saldo disponível: " + novoSaldo);
        } else {
            System.out.println("Saque de R$" + valor + " inválido. Saldo insuficiente.");
            System.out.println("Saldo disponível: " + getSaldo());
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            double novoSaldo = getSaldo() + valor; // Calcula o novo saldo
            setSaldo(novoSaldo); // Atualiza o saldo da conta
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public void setSaldo(double novoSaldo) {}
}

