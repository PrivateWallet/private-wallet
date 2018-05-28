package com.mp.privatewallet.wallet.period;

import java.time.LocalDate;

public class Period implements Comparable {

    private LocalDate from;

    private LocalDate to;

    public Period(final LocalDate from, final LocalDate to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public LocalDate getFrom() {
        return from;
    }

    @Override
    public LocalDate getTo() {
        return to;
    }
}
