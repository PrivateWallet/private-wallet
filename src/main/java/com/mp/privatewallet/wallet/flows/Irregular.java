package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Irregular extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.IRREGULAR;

    private final List<LocalDate> executionDates;

    public Irregular(final Double amount, final LocalDate start, final LocalDate end, final List<LocalDate> executionDates) {
        super(amount, periodicity, start, end);
        this.executionDates = executionDates;
    }

    @Override
    public Set getExecutionDays() {
        final Set setOfExecutionDays = new HashSet();
        executionDates.stream().forEach(date -> setOfExecutionDays.add(date));
        return setOfExecutionDays;
    }

}

