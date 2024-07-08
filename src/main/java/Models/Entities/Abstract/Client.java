
package Models.Entities.Abstract;

import java.util.UUID;
import Models.Entities.Address;
import Models.Enums.EAddress;
import Models.Enums.EClientType;

public class Client {
    private final UUID id;
    private String name;
    private String cpf;
    private EClientType clientType;
    private Address clientAddress;
    private Double purchases;
    private double cashbackBalance;

    public Client(String name, String cpf, EClientType clientType, String state, EAddress isCapital, String region) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.clientType = clientType;
        this.clientAddress = new Address(state, isCapital, region);
        this.purchases = 0.0;
        this.cashbackBalance = 0.0;
    }

    // Getters and setters...

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EClientType getClientType() {
        return clientType;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public Double getPurchases() {
        return purchases;
    }

    public void setPurchases(Double purchases) {
        this.purchases = purchases;
    }

    public double getCashbackBalance() {
        return cashbackBalance;
    }

    public void setCashbackBalance(double cashbackBalance) {
        this.cashbackBalance = cashbackBalance;
    }
}
