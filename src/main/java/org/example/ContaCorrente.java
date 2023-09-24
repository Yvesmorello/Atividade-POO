package org.example;

import java.text.DecimalFormat;

import static java.lang.Math.ceil;

public class ContaCorrente extends Conta {



    public ContaCorrente(String numeroConta, String titular, TipoConta tipoConta ,double saldo) {
        super(numeroConta, titular, TipoConta.CORRENTE, saldo);
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
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            double novoSaldo = getSaldo() - valor;
            System.out.println("Saldo disponível: " + novoSaldo);
        } else {
            System.out.println("Saque de R$" + valor + " inválido. Saldo insuficiente.");
            System.out.println("Saldo disponível: " + getSaldo());
        }
    }
}
