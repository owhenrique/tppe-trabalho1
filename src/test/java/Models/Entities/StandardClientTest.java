
package Models.Entities.Client;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardClientTest {
    private Client standardClient;

    @Before
    public void setUp() {
        standardClient = new StandardClient("John Doe", "12345678900", EClientType.STANDARD, "CA", EAddress.CAPITAL, "South");
    }

    @Test
    public void testStandardClientCreation() {
        assertNotNull(standardClient.getId());
        assertEquals("John Doe", standardClient.getName());
        assertEquals("12345678900", standardClient.getCpf());
        assertEquals(EClientType.STANDARD, standardClient.getClientType());
        assertEquals("CA", standardClient.getClientAddress().getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameValidation() {
        standardClient.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCpfValidation() {
        standardClient.setCpf("");
    }
}
