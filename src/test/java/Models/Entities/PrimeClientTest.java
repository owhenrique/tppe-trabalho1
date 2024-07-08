
package Models.Entities.Client;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeClientTest {
    private Client primeClient;

    @Before
    public void setUp() {
        primeClient = new PrimeClient("Jim Doe", "11223344556", EClientType.PRIME, "TX", EAddress.CAPITAL, "South");
    }

    @Test
    public void testPrimeClientCreation() {
        assertNotNull(primeClient.getId());
        assertEquals("Jim Doe", primeClient.getName());
        assertEquals("11223344556", primeClient.getCpf());
        assertEquals(EClientType.PRIME, primeClient.getClientType());
        assertEquals("TX", primeClient.getClientAddress().getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameValidation() {
        primeClient.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCpfValidation() {
        primeClient.setCpf("");
    }
}
