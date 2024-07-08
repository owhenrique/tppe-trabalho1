package Models.Entities;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ProductTest {

    String code;
    String info;
    double price;
    String unit;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] data = new Object[][] {
                {"P001", "Notebook", 2000.00, "unit"},
                {"P002", "Cellphone", 1200.00, "unit"},
                {"P003", "Bluetooth Earphone", 45.00, "piece"},
                {"P004", "Measuring Tape", 20.00, "meter"}
        };
        return Arrays.asList(data);
    }

    public ProductTest(String code, String info, double price, String unit){
        this.code = code;
        this.info = info;
        this.price = price;
        this.unit = unit;
    }

    @Test
    public void testProductCreation(){
        Product product = new Product(code, info, price, unit);
        assertEquals(code, product.getCode());
        assertEquals(info, product.getInfo());
        assertEquals(price, product.getPrice(), 0.01);
        assertEquals(unit, product.getUnit());
    }
}