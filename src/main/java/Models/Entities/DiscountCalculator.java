package Models.Entities;

import Models.Entities.Abstract.Client;
import Models.Enums.EClientType;
import Models.Enums.EPaymentMethod;

public class DiscountCalculator {
    private Client client;
    private double totalPrice;
    private double icms;
    private double municipalTax;
    private EPaymentMethod paymentMethod;

    public DiscountCalculator(Client client, double totalPrice, double icms, double municipalTax, EPaymentMethod paymentMethod) {
        this.client = client;
        this.totalPrice = totalPrice;
        this.icms = icms;
        this.municipalTax = municipalTax;
        this.paymentMethod = paymentMethod;
    }

    public double calculate(String card) {
        double initialDiscount = 0.0;
        double realValueWithTaxes = totalPrice + icms + municipalTax;

        if (client.getClientType() == EClientType.ESPECIAL) {
            initialDiscount += realValueWithTaxes * 0.10;
        }

        if (paymentMethod == EPaymentMethod.CREDITCARD && isStoreCard(card)) {
            initialDiscount += realValueWithTaxes * 0.10;
        }

        return initialDiscount;
    }

    private boolean isStoreCard(String card) {
        String prefix = "4296 13";
        return card.startsWith(prefix);
    }
}
