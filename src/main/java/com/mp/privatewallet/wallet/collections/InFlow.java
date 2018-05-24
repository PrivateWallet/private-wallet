package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.Direction;
import com.mp.privatewallet.wallet.enums.Periodicity;
import lombok.Data;

@Data
public class InFlow extends CashFlow {

    private final static Direction DIRECTION = Direction.IN;


    public InFlow(final Double amount, final Periodicity periodicity) {
        super(amount, periodicity, DIRECTION);
    }
}
