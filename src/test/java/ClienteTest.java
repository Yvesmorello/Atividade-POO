import org.example.Cliente;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {


        Cliente cliente = new Cliente("João", "123456789");

    @Test
    public void testGetTitular() {
        assertEquals("João", cliente.getNome());
    }

    @Test
    public void testGetDocumento() {
        assertEquals("123456789", cliente.getDocumento());
    }

    @Test
    public void testConstrutor() {
        assertEquals("João", cliente.getNome());
        assertEquals("123456789", cliente.getDocumento());
    }


}
