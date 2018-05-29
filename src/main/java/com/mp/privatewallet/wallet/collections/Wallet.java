package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.flows.CashFlow;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document(collection = "wallets")
public class Wallet {

    @Id
    private String id;

    private String ownerName;

    private Double accountBalance;

    private Collection<CashFlow> flows;

    public Wallet(final String ownerName, final Double accountBalance, final Collection<CashFlow> flows) {
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
        this.flows = flows;
    }
}
