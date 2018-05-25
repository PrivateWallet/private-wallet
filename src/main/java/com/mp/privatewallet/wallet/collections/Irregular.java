package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Irregular extends CashFlow implements ImpactStrategy {

    public static PeriodicityEnum periodicity = PeriodicityEnum.IRREGULAR;

    private final List<LocalDate> executionDays;

    public Irregular(Double amount, LocalDate start, LocalDate end, List<LocalDate> executionDays) {
        super(amount, periodicity, start, end);
        this.executionDays = executionDays;
    }

    @Override
    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to) {
        return  executionDays;
    }

}
