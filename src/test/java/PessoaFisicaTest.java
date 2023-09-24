import static org.junit.Assert.*;

import org.example.PessoaFisica;
import org.junit.Before;
import org.junit.Test;

public class PessoaFisicaTest {

        PessoaFisica pessoaFisica = new PessoaFisica("João", "123456789", "987654321");

    @Test
    public void testGetNome() {
        assertEquals("João", pessoaFisica.getNome());
    }

    @Test
    public void testGetDocumento() {
        assertEquals("123456789", pessoaFisica.getDocumento());
    }

    @Test
    public void testGetCpf() {
        assertEquals("987654321", pessoaFisica.getCpf());
    }
}
