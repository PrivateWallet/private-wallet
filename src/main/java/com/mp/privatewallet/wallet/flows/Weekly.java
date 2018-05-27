package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Weekly extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.WEEKLY;

    /**
     *  Default value for execution day is monday.
     */
    private Integer dayOfWeek = 1;

    public Weekly(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    public Weekly(final Double amount, final LocalDate start, final LocalDate end, final Integer dayOfWeek) {
        super(amount, periodicity, start, end);
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

