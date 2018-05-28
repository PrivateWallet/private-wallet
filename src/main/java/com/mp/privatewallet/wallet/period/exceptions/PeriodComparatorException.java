package com.mp.privatewallet.wallet.period.exceptions;

public class PeriodComparatorException extends RuntimeException {

    public PeriodComparatorException(final String message) {
        super(message);
    }

    private PeriodComparatorException(final String message, final Exception exception) {
        super(message, exception);
    }

}
