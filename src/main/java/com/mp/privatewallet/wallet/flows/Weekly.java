package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Weekly extends CashFlow {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.WEEKLY;

    /**
     *  Default value for execution day is monday.
     */
    private Integer dayOfWeek = 1;

    public Weekly(final Double amount, final Comparable period) {
        super(amount, periodicity, period);
    }

    public Weekly(final Double amount, final Comparable period, final Integer dayOfWeek) {
        super(amount, periodicity, period);
        //TODO: exception when value is x < 1 && x > 7, eg. 'WrongExecutionValueException'
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public Set getExecutionDays() {
        final Set setOfExecutionDays = new HashSet();
        setOfExecutionDays.add(dayOfWeek);
        return setOfExecutionDays;
    }

}

