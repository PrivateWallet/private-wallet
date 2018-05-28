package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Irregular extends CashFlow {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.IRREGULAR;

    private final List<LocalDate> executionDates;

    public Irregular(final Double amount, final Comparable period, final List<LocalDate> executionDates) {
        super(amount, periodicity, period);
        this.executionDates = executionDates;
    }

    @Override
    public Set getExecutionDays() {
        final Set setOfExecutionDays = new HashSet();
        executionDates.stream().forEach(date -> setOfExecutionDays.add(date));
        return setOfExecutionDays;
    }

}

