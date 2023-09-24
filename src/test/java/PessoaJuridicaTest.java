import static org.junit.Assert.*;

import org.example.PessoaFisica;
import org.example.PessoaJuridica;
import org.junit.Before;
import org.junit.Test;

public class PessoaJuridicaTest {


       PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa XYZ", "987654321", "12345678901234");

    @Test
    public void testGetNome() {
        assertEquals("Empresa XYZ", pessoaJuridica.getNome());
    }

    @Test
    public void testGetDocumento() {
        assertEquals("987654321", pessoaJuridica.getDocumento());
    }

    @Test
    public void testGetCnpj() {
        assertEquals("12345678901234", pessoaJuridica.getCnpj());
    }
}
