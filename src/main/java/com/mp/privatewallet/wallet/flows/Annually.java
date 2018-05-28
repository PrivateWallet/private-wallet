package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Annually extends CashFlow {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.ANNUALLY;

    /**
     *  Default value for annually execution day is 1st january.
     */
    private LocalDate dayOfYear;

    public Annually(final Double amount, final Comparable period) {
        super(amount, periodicity, period);
        dayOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
    }

    public Annually(final Double amount, final Comparable period, final LocalDate dayOfYear) {
        super(amount, periodicity, period);
        this.dayOfYear = dayOfYear;
    }

    @Override
    public Set getExecutionDays() {
        Set setOfExecutionDays = new HashSet();
        setOfExecutionDays.add(dayOfYear.getDayOfYear());
        return setOfExecutionDays;
    }

}

