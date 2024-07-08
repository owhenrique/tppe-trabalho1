package Models.Entities;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;
import Models.Enums.EPaymentMethod;

import java.util.Date;
import java.util.List;

public class Cart {
    private Client client;
    private List<Product> products;
    private EPaymentMethod paymentMethod;
    private double totalPrice;
    private double discount;
    private double shippingCost;
    private double icms;
    private double municipalTax;
    private Date date;
    private double cashback;
    private double cashbackValue;

    public Cart(Client client, List<Product> products, String card, EPaymentMethod paymentMethod) {
        this.client = client;
        this.products = products;
        this.paymentMethod = paymentMethod;
        this.totalPrice = calculateTotalPrice();
        this.discount = calculateDiscount(card);
        this.shippingCost = calculateShippingCost();
        this.icms = calculateICMS();
        this.municipalTax = calculateMunicipalTax();
        this.date = new Date();
        this.cashback = 0;
        this.cashbackValue = 0;
    }

    // Getters
    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public EPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public double getIcms() {
        return icms;
    }

    public double getMunicipalTax() {
        return municipalTax;
    }

    public Date getDate() {
        return date;
    }

    public double getCashback() {
        return cashback;
    }

    public double getCashbackValue() {
        return cashbackValue;
    }

    // Setters - Note: Consider removing setters if not needed for external modification

    // Utils

    public double calculateTotalAmount() {
        double totalAmountBeforeDiscount = totalPrice + icms + municipalTax + shippingCost;
        double totalAmountAfterDiscount = totalAmountBeforeDiscount - discount;

        double cashbackBalance = 0.0;

        if (client.getClientType() == EClientType.PRIME && paymentMethod != EPaymentMethod.CASHBACK) {
            cashbackBalance += calculateCashback(totalAmountAfterDiscount);
        } else if (client.getClientType() != EClientType.PRIME && paymentMethod == EPaymentMethod.CASHBACK) {
            cashbackBalance += calculateCashback(totalAmountAfterDiscount);
        }

        return totalAmountAfterDiscount + cashbackBalance;
    }

    private double calculateDiscount(String card) {
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

    private double calculateCashback(double totalAmountAfterDiscount) {
        double cashbackPercentage = (client.getClientType() == EClientType.PRIME) ? 0.05 : 0.03;
        double cashbackValue = totalAmountAfterDiscount * cashbackPercentage;

        return Math.round(cashbackValue * 100.0) / 100.0;
    }

    private double calculateTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    private double calculateShippingCost() {
        double shippingCost = 0.0;

        switch (client.getClientAddress().getRegion()) {
            case "Distrito-Federal":
                shippingCost = 5.00;
                break;
            case "Centro-Oeste":
                shippingCost = client.getClientAddress().getIsCapital() == EAddress.CAPITAL ? 10.00 : 13.00;
                break;
            case "Nordeste":
                shippingCost = client.getClientAddress().getIsCapital() == EAddress.CAPITAL ? 15.00 : 18.00;
                break;
            case "Norte":
                shippingCost = client.getClientAddress().getIsCapital() == EAddress.CAPITAL ? 20.00 : 25.00;
                break;
            case "Sudeste":
                shippingCost = client.getClientAddress().getIsCapital() == EAddress.CAPITAL ? 7.00 : 10.00;
                break;
            case "Sul":
                shippingCost = client.getClientAddress().getIsCapital() == EAddress.CAPITAL ? 10.00 : 13.00;
                break;
        }

        return client.getClientType() == EClientType.ESPECIAL ? shippingCost * 0.3 : shippingCost;
    }

    private double calculateICMS() {
        return client.getClientAddress().getState().equals("DF") ? calculateTotalPrice() * 0.18 : calculateTotalPrice() * 0.12;
    }

    private double calculateMunicipalTax() {
        return client.getClientAddress().getState().equals("DF") ? 0 : calculateTotalPrice() * 0.04;
    }

    private boolean isStoreCard(String card) {
        String prefix = "4296 13";
        return card.startsWith(prefix);
    }
}
