package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.Direction;
import com.mp.privatewallet.wallet.enums.Periodicity;

public class OutFlow extends CashFlow {

    private final static Direction DIRECTION = Direction.OUT;

    public OutFlow(final Double amount, final Periodicity periodicity) {
        super(amount, periodicity, DIRECTION);
    }

}
