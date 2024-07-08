package Models.Entities;

import Models.Entities.Address;
import Models.Enums.EAddress;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddressTest {

    private String state;
    private EAddress isCapital;
    private String region;
    private String expectedState;
    private EAddress expectedIsCapital;
    private String expectedRegion;

    @Parameters
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][] {
                {"DF", EAddress.CAPITAL, "Centro-Oeste", "DF", EAddress.CAPITAL, "Centro-Oeste"},
                {"SP", EAddress.INTERIOR, "Sudeste", "SP", EAddress.INTERIOR, "Sudeste"},
                {"MG", EAddress.CAPITAL, "Sudeste", "MG", EAddress.CAPITAL, "Sudeste"},
                {"RJ", EAddress.CAPITAL, "Sudeste", "RJ", EAddress.CAPITAL, "Sudeste"},
        });
    }

    public AddressTest(String state, EAddress isCapital, String region, String expectedState, EAddress expectedIsCapital, String expectedRegion) {
        this.state = state;
        this.isCapital = isCapital;
        this.region = region;
        this.expectedState = expectedState;
        this.expectedIsCapital = expectedIsCapital;
        this.expectedRegion = expectedRegion;
    }

    @Test
    public void testAddressCreation() {
        Address address = new Address(state, isCapital, region);
        assertEquals(expectedState, address.getState());
        assertEquals(expectedIsCapital, address.getIsCapital());
        assertEquals(expectedRegion, address.getRegion());
    }
}
