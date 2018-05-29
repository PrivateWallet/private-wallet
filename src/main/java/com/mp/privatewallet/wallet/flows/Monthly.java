package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Monthly extends CashFlow {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.MONTHLY;

    /**
     *  Default value for the execution day is first day of month.
     */
    private Integer dayOfMonth = 1;

    public Monthly(final Double amount, final Comparable period) {
        super(amount, periodicity, period);
    }

    public Monthly(final Double amount, final Comparable period, final Integer dayOfMonth) {
        super(amount, periodicity, period);
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public List getExecutionDays() {
        final List<Integer> executionDays = new ArrayList<>();
        executionDays.add(dayOfMonth);
        return executionDays;
    }

}
