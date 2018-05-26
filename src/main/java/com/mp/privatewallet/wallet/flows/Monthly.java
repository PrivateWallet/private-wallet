package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public Integer getComparableIntBasedOnDate(LocalDate localDate) {
        return localDate.getDayOfMonth();
    }

    @Override
    public List<Integer> getExecutionDays() {
        List<Integer> executinDayOfMonth = new ArrayList();
        executinDayOfMonth.add(dayOfMonth);
        return executinDayOfMonth;
    }
}
