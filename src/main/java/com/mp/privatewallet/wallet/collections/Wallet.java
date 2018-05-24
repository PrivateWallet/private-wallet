package com.mp.privatewallet.wallet.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Collection;

@Data
public class Wallet {

    @Id
    public String id;

    public String ownerName;

    public BigDecimal accountBalance;

    public Collection<CashFlow> flows;

    public Wallet( String ownerName, BigDecimal accountBalance, Collection<CashFlow> flows) {
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
        this.flows = flows;
    }
}
