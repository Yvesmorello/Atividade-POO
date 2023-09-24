import org.example.ContaCorrente;
import org.example.ContaPoupanca;
import org.example.ContaSalario;
import org.example.TipoConta;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaPoupancaTest {

    ContaPoupanca contaPoupanca = new ContaPoupanca("1234", "João Emanuel", TipoConta.POUPANCA, 1000.0);


    @Test
    public void testeAbrirContaValido(){

        ContaPoupanca contaPoupanca1 = new ContaPoupanca("1234", "Marcos Vinicius", TipoConta.POUPANCA, 100.0);

        assertEquals(100.0, contaPoupanca1.abrirConta());
    }

    @Test
    public void testeAbrirContaInvalido(){

        ContaPoupanca contaPoupanca1 = new ContaPoupanca("1234", "Marcos Vinicius", TipoConta.POUPANCA, 20.0);

        assertEquals(20.0, contaPoupanca1.abrirConta());
    }

    @Test
    public void testVerificaSaldo(){
        System.out.println("Saldo atual da conta: R$" + contaPoupanca.getSaldo());
        assertEquals(1000.0, contaPoupanca.getSaldo());
    }

    @Test
    public void testGetTitularPrincipal() {
        Assert.assertEquals("João Emanuel", contaPoupanca.getTitular());
    }

    @Test
    public void testGetNumeroConta() {
        assertEquals("1234",contaPoupanca.getNumeroConta());
    }

    @Test
    public void testGetTipoConta() {
        assertEquals(TipoConta.POUPANCA, contaPoupanca.getTipo());
    }

    @Test
    public void testGetSaldo(){
        assertEquals(1000.0, contaPoupanca.getSaldo());
    }

    @Test
    public void testSaqueContaSalarioComValorMenorQueSaldo() {
        contaPoupanca.sacar(800.0);
        Assert.assertNotEquals(10000.0, contaPoupanca.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueContaSalarioComValorMaiorQueSaldo() {

        contaPoupanca.sacar(2000.0);
        assertEquals(1000.0, contaPoupanca.getSaldo());
    }

    @Test
    public void testFinanciarBemSucedido() {
        ContaCorrente contaCorrente = new ContaCorrente("12345", "Titular", TipoConta.POUPANCA, 9000.0);

        double resultado = contaCorrente.financiar(5000.0, 12, 5, 1.5); // Exemplo de financiamento

        assertEquals(7958.33, contaCorrente.getSaldo(),0.01); // Verificar o saldo após o financiamento
    }


}

