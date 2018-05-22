package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.Direction;
import com.mp.privatewallet.wallet.enums.Periodicity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class InFlow extends CashFlow {

    private static Direction DIRECTION = Direction.IN;


    public InFlow(Double amount, Periodicity periodicity) {
        super(amount, periodicity, DIRECTION);
    }
}
