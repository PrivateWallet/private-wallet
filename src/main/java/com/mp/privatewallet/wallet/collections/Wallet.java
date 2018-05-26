package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.flows.CashFlow;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Data
public class Wallet {

    @Id
    public String id;

    public String ownerName;

    public Double accountBalance;

    public Collection<CashFlow> flows;

    public Wallet(final String ownerName, final Double accountBalance, final Collection<CashFlow> flows) {
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
        this.flows = flows;
    }
}
