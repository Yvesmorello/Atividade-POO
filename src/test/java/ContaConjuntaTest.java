import org.example.Conta;
import org.example.ContaConjunta;
import org.example.ContaCorrente;
import org.example.TipoConta;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaConjuntaTest {

    ContaConjunta contaConjunta = new ContaConjunta("12345", "João Emanuel", "Roberta", TipoConta.CONJUNTA, 1000.0);

    @Test
    public void testVerificaSaldo(){
        System.out.println("Saldo atual da conta: R$" + contaConjunta.getSaldo());
        assertEquals(1000.0, contaConjunta.getSaldo());
    }

    @Test
    public void testGetTitularPrincipal() {
        Assert.assertEquals("João Emanuel", contaConjunta.getTitular());
    }

    @Test
    public void testGetTitularSecundario() {
        assertEquals("Roberta", contaConjunta.getTitulareSecundario());
    }

    @Test
    public void testGetNumeroConta() {
        assertEquals("12345",contaConjunta.getNumeroConta());
    }

    @Test
    public void testGetTipoConta() {
        assertEquals(TipoConta.CONJUNTA, contaConjunta.getTipo());
    }
    @Test
    public void testGetSaldo(){
        assertEquals(1000.0, contaConjunta.getSaldo());
    }

    @Test
    public void testDepositoContaCorrenteComValorPositivo() {
        contaConjunta.depositar(500.0);
        Assert.assertNotEquals(1500.0, contaConjunta.getSaldo(), 0.001);
    }

    @Test
    public void testDepositoContaCorrenteComValorNegativo() {
        contaConjunta.depositar(-200.0);
        assertEquals(1000.0, contaConjunta.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueContaCorrenteComValorMenorQueSaldo() {
        contaConjunta.sacar(800.0);
        assertNotEquals(200, contaConjunta.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueContaCorrenteComValorMaiorQueSaldo() {
        contaConjunta.sacar(1500.0);
        assertEquals(1000.0, contaConjunta.getSaldo(), 0.001);
    }

    @Test
    public void testFinanciarBemSucedido() {
        ContaCorrente contaCorrente = new ContaCorrente("12345", "Titular", TipoConta.POUPANCA, 9000.0);

        double resultado = contaCorrente.financiar(5000.0, 12, 5, 1.5); // Exemplo de financiamento

        assertEquals(7958.33, contaCorrente.getSaldo(),0.01); // Verificar o saldo após o financiamento
    }
}
