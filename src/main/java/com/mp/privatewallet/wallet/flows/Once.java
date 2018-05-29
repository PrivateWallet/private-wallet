package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Once extends CashFlow {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.ONCE;

    private final LocalDate executionDay;

    public Once(final Double amount, final Comparable period, final LocalDate executionDay) {
        super(amount, periodicity, period);
        this.executionDay = executionDay;
    }

    @Override
    public List getExecutionDays() {
        final List<LocalDate> executionDays = new ArrayList<>();
        executionDays.add(executionDay);
        return executionDays;
    }

}

