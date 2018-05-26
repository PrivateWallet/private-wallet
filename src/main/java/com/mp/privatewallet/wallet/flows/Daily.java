package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Daily extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.DAILY;

    public Daily(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    @Override
    public Integer getComparableIntBasedOnDate(LocalDate localDate) {
        return 1;
    }

    @Override
    public List<Integer> getExecutionDays() {
        List<Integer> executionDay = new ArrayList();
        executionDay.add(1);
        return executionDay;
    }
}
