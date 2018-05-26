package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Once extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.ONCE;

    private final LocalDate executionDay;

    public Once(final Double amount, final LocalDate start, final LocalDate end, final LocalDate executionDay) {
        super(amount, periodicity, start, end);
        this.executionDay = executionDay;
    }

    @Override
    public Integer getComparableIntBasedOnDate(LocalDate localDate) {
        return localDate.getDayOfYear();
    }

    @Override
    public List<Integer> getExecutionDays() {
        List<Integer> executionDayOfYear = new ArrayList();
        executionDayOfYear.add(executionDay.getDayOfYear());
        return executionDayOfYear;
    }
}

