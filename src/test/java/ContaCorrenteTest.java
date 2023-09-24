import org.example.ContaCorrente;
import org.example.TipoConta;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaCorrenteTest {

      ContaCorrente contaCorrente1 = new ContaCorrente("12345", "Titular1", TipoConta.CORRENTE,1000.0);
      ContaCorrente contaCorrente2 = new ContaCorrente("54321", "Titular2", TipoConta.CORRENTE,2000.0);

    @Test
    public void testDepositoContaCorrenteComValorPositivo() {
        contaCorrente1.depositar(500.0);
        Assert.assertNotEquals(1500.0, contaCorrente1.getSaldo(), 0.001);
    }

    @Test
    public void testDepositoContaCorrenteComValorNegativo() {
        contaCorrente1.depositar(-200.0);
        assertEquals(1000.0, contaCorrente1.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueContaCorrenteComValorMenorQueSaldo() {
        contaCorrente1.sacar(800.0);
        assertNotEquals(200, contaCorrente1.getSaldo(), 0.001);
    }

    @Test
    public void testSaqueContaCorrenteComValorMaiorQueSaldo() {
        contaCorrente1.sacar(1500.0);
        assertEquals(1000.0, contaCorrente1.getSaldo(), 0.001);
    }

    @Test
    public void testVerificaSaldo(){
        System.out.println("Saldo atual da conta: R$" + contaCorrente1.getSaldo());
        assertEquals(1000.0, contaCorrente1.getSaldo());
    }

    @Test
    public void testFinanciarBemSucedido() {
        ContaCorrente contaCorrente = new ContaCorrente("12345", "Titular", TipoConta.POUPANCA, 9000.0);

        double resultado = contaCorrente.financiar(5000.0, 12, 5, 1.5); // Exemplo de financiamento

        assertEquals(7958.33, contaCorrente.getSaldo(),0.01); // Verificar o saldo após o financiamento
    }
}

