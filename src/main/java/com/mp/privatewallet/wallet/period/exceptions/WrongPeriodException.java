package com.mp.privatewallet.wallet.period.exceptions;

public class WrongPeriodException extends RuntimeException {

    public WrongPeriodException(final String message) {
        super(message);
    }

    private WrongPeriodException(final String message, final Exception exception) {
        super(message, exception);
    }

}
