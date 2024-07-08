package Models.Entities.Client;

import Models.Entities.Abstract.Client;
import Models.Enums.EAddress;
import Models.Enums.EClientType;

public class StandardClient extends Client {
    public StandardClient(String name, String cpf, EClientType clientType, String state, EAddress isCapital, String region) {
        super(name, cpf, clientType, state, isCapital, region);
    }
}
