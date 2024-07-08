
package Models.Entities.Client;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EspecialClientTest {
    private Client especialClient;

    @Before
    public void setUp() {
        especialClient = new EspecialClient("Jane Doe", "09876543211", EClientType.ESPECIAL, "NY", EAddress.INTERIOR, "East");
    }

    @Test
    public void testEspecialClientCreation() {
        assertNotNull(especialClient.getId());
        assertEquals("Jane Doe", especialClient.getName());
        assertEquals("09876543211", especialClient.getCpf());
        assertEquals(EClientType.ESPECIAL, especialClient.getClientType());
        assertEquals("NY", especialClient.getClientAddress().getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameValidation() {
        especialClient.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCpfValidation() {
        especialClient.setCpf("");
    }
}
