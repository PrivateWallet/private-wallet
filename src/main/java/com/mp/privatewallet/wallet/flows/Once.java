package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Once extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.ONCE;

    private final LocalDate executionDay;

    public Once(final Double amount, final LocalDate start, final LocalDate end, final LocalDate executionDay) {
        super(amount, periodicity, start, end);
        this.executionDay = executionDay;
    }


    @Override
    public Set getExecutionDays() {
        final Set setOfExecutionDays = new HashSet();
        setOfExecutionDays.add(executionDay.getDayOfYear());
        return setOfExecutionDays;
    }
}

