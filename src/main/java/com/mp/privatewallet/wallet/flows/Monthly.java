package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Monthly extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.MONTHLY;

    /**
     *  Default value for the execution day is first day of month.
     */
    private Integer dayOfMonth = 1;

    public Monthly(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    public Monthly(final Double amount, final LocalDate start, final LocalDate end, final Integer dayOfMonth) {
        super(amount, periodicity, start, end);
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public Set getExecutionDays() {
        Set setOfExecutionDays = new HashSet();
        setOfExecutionDays.add(dayOfMonth);
        return setOfExecutionDays;
    }
}
