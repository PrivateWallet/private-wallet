package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Once extends CashFlow implements ImpactStrategy {

    public static PeriodicityEnum periodicity = PeriodicityEnum.ONCE;

    private final LocalDate executionDay;

    public Once(Double amount, LocalDate start, LocalDate end, LocalDate executionDay) {
        super(amount, periodicity, start, end);
        this.executionDay = executionDay;
    }

    @Override
    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to) {
        final List<LocalDate> executionDays = new ArrayList();
        executionDays.add(executionDay);
        return executionDays;
    }

}
