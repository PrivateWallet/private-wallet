package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.Direction;
import com.mp.privatewallet.wallet.enums.Periodicity;

import java.math.BigDecimal;

public class OutFlow extends CashFlow {

    private static Direction DIRECTION = Direction.OUT;

    public OutFlow(Double amount, Periodicity periodicity) {
        super(amount, periodicity, DIRECTION);
    }

}
