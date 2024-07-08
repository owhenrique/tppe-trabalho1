
package Models.Entities;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ClientTest {

    private String name;
    private String cpf;
    private EClientType clientType;
    private String state;
    private EAddress isCapital;
    private String region;
    private double purchases;
    private double cashbackBalance;
    private EClientType expectedClientType;

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
                {"João", "12345678900", EClientType.STANDARD, "DF", EAddress.CAPITAL, "Centro-Oeste", 50.0, 0.0, EClientType.STANDARD},
                {"André", "12345678901", EClientType.STANDARD, "SP", EAddress.INTERIOR, "Sudeste", 150.0, 0.0, EClientType.ESPECIAL},
                {"Maria", "12345678902", EClientType.ESPECIAL, "MG", EAddress.CAPITAL, "Sudeste", 200.0, 0.0, EClientType.ESPECIAL},
                {"Ana", "12345678903", EClientType.PRIME, "RJ", EAddress.CAPITAL, "Sudeste", 0.0, 20.00, EClientType.PRIME},
                {"Analice", "12345678904", EClientType.STANDARD, "RJ", EAddress.CAPITAL, "Sudeste", 0.0, 20.00, EClientType.PRIME},
                {"Ana Clara", "12345678905", EClientType.ESPECIAL, "RJ", EAddress.CAPITAL, "Sudeste", 0.0, 20.00, EClientType.PRIME},
                {"Júlia", "12345678906", EClientType.ESPECIAL, "RJ", EAddress.CAPITAL, "Sudeste", 0.0, 0.0, EClientType.STANDARD},
                {"Vitória", "12345678907", EClientType.PRIME, "RJ", EAddress.CAPITAL, "Sudeste", 0.0, 0.0, EClientType.STANDARD},
        });
    }

    public ClientTest(String name, String cpf, EClientType clientType, String state, EAddress isCapital, String region, double purchases, double cashbackBalance, EClientType expectedClientType) {
        this.name = name;
        this.cpf = cpf;
        this.clientType = clientType;
        this.state = state;
        this.isCapital = isCapital;
        this.region = region;
        this.purchases = purchases;
        this.cashbackBalance = cashbackBalance;
        this.expectedClientType = expectedClientType;
    }

    @Test
    public void testClientCreation() {
        Client client = new Client(name, cpf, clientType, state, isCapital, region);
        client.setPurchases(purchases);
        client.setCashbackBalance(cashbackBalance);
        assertEquals(expectedClientType, client.getClientType());
    }
}