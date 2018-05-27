package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Annually extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.ANNUALLY;

    /**
     *  Default value for execution day is 1 january.
     */
    private LocalDate dayOfYear;

    public Annually(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
        dayOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
    }

    public Annually(final Double amount, final LocalDate start, final LocalDate end, final LocalDate dayOfYear) {
        super(amount, periodicity, start, end);
        this.dayOfYear = dayOfYear;
    }

    @Override
    public Set getExecutionDays() {
        Set setOfExecutionDays = new HashSet();
        setOfExecutionDays.add(dayOfYear.getDayOfYear());
        return setOfExecutionDays;
    }
}

