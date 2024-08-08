package Models.Entities;

import Models.Enums.EClientType;
import Models.Enums.EPaymentMethod;

public class TotalAmountCalculator {
    private final Cart cart;

    public TotalAmountCalculator(Cart cart) {
        this.cart = cart;
    }

    public double calculate() {
        double totalAmountBeforeDiscount = cart.getTotalPrice() + cart.getIcms() + cart.getMunicipalTax() + cart.getShippingCost();
        double totalAmountAfterDiscount = totalAmountBeforeDiscount - cart.getDiscount();

        double cashbackBalance = 0.0;

        if (cart.getClient().getClientType() == EClientType.PRIME && cart.getPaymentMethod() != EPaymentMethod.CASHBACK) {
            cashbackBalance += cart.calculateCashback(totalAmountAfterDiscount);
        } else if (cart.getClient().getClientType() != EClientType.PRIME && cart.getPaymentMethod() == EPaymentMethod.CASHBACK) {
            cashbackBalance += cart.calculateCashback(totalAmountAfterDiscount);
        }

        return totalAmountAfterDiscount + cashbackBalance;
    }
}
