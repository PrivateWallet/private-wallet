package com.mp.privatewallet.wallet.period;

import com.mp.privatewallet.wallet.period.exceptions.WrongPeriodException;

import java.time.LocalDate;

public class Period implements Comparable {

    private LocalDate from;

    private LocalDate to;

    public Period(final LocalDate from, final LocalDate to) {
        validateDates(from, to);
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

    private void validateDates(final LocalDate from, final LocalDate to) {
        if(from.isAfter(to)) {
            throw new WrongPeriodException("'Date from': " + from + " is later than 'date to': " + to);
        }
    }
}
