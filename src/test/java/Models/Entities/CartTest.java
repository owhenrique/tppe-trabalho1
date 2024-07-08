package Models.Entities;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;
import Models.Enums.EPaymentMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CartTest {

    private Client client;
    private List<Product> products;
    private EPaymentMethod paymentMethod;
    private String card;
    private double cashbackBalance;
    private double expectedTotalAmount;

    @Parameters
    public static Collection<Object[]> getParameters() {
        Client client1 = new Client("João", "12345678900", EClientType.STANDARD, "DF", EAddress.CAPITAL, "Centro-Oeste");
        Client client2 = new Client("André", "12345678901", EClientType.STANDARD, "SP", EAddress.INTERIOR, "Sudeste");
        Client client3 = new Client("Maria", "12345678902", EClientType.ESPECIAL, "MG", EAddress.CAPITAL, "Sudeste");

        List<Product> products1 = Arrays.asList(
                new Product("P001", "Notebook", 2000.00, "unidade"),
                new Product("P002", "Fita Métrica", 25.00, "metro")
        );

        List<Product> products2 = Arrays.asList(
                new Product("P003", "Celular", 1256.92, "unidade"),
                new Product("P005", "Caneta Preta", 10.00, "unidade")
        );

        List<Product> products3 = Arrays.asList(
                new Product("P004", "Notebook Gamer", 6350.00, "unidade"),
                new Product("P005", "Caneta Preta", 10.00, "unidade")
        );

        return Arrays.asList(new Object[][]{
                {client1, products1, EPaymentMethod.CREDITCARD, "4296 1312 3456 7890", 0.0, 2197.0},
                {client2, products2, EPaymentMethod.CASHBACK, "1234 5678 9012 3456", 50.0, 1524.017},
                {client3, products3, EPaymentMethod.CREDITCARD, "4296 1321 9432 2331", 0.0, 6107.7}
        });
    }

    public CartTest(Client client, List<Product> products, EPaymentMethod paymentMethod, String card, double cashbackBalance, double expectedTotalAmount) {
        this.client = client;
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.card = card;
        this.cashbackBalance = cashbackBalance;
        this.expectedTotalAmount = expectedTotalAmount;
    }

    @Test
    public void testCalculateTotalAmount() {
        Cart cart = new Cart(client, products, card, paymentMethod);
        double totalAmount = cart.calculateTotalAmount();
        assertEquals(expectedTotalAmount, totalAmount, 0.01);
    }
}
