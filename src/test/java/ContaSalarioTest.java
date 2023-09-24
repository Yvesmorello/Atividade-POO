import org.example.ContaCorrente;
import org.example.ContaSalario;
import org.example.TipoConta;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaSalarioTest {

    ContaSalario contaSalario = new ContaSalario("1234", "João Emanuel", TipoConta.SALARIO, 1000.0);

    @Test
    public void testGetTitularPrincipal() {
        Assert.assertEquals("João Emanuel", contaSalario.getTitular());
    }

    @Test
    public void testGetNumeroConta() {
        assertEquals("1234",contaSalario.getNumeroConta());
    }

    @Test
    public void testGetTipoConta() {
        assertEquals(TipoConta.SALARIO, contaSalario.getTipo());
    }

    @Test
    public void testGetSaldo(){
        assertEquals(1000.0, contaSalario.getSaldo());
    }

    @Test
    public void testSaqueContaSalarioComValorMenorQueSaldo() {
        contaSalario.sacar(800.0);
        Assert.assertNotEquals(10000.0, contaSalario.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueContaSalarioComValorMaiorQueSaldo() {

        contaSalario.sacar(2000.0);
        assertEquals(1000.0, contaSalario.getSaldo());
    }

    @Test
    public void testVerificaSaldo(){
        System.out.println("Saldo atual da conta: R$" + contaSalario.getSaldo());
        assertEquals(1000.0, contaSalario.getSaldo());
    }

    @Test
    public void testFinanciarBemSucedido() {
        ContaCorrente contaCorrente = new ContaCorrente("12345", "Titular", TipoConta.POUPANCA, 9000.0);

        double resultado = contaCorrente.financiar(5000.0, 12, 5, 1.5); // Exemplo de financiamento

        assertEquals(7958.33, contaCorrente.getSaldo(),0.01); // Verificar o saldo após o financiamento
    }
}
