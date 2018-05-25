package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Irregular extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.IRREGULAR;

    private final List<LocalDate> executionDays;

    public Irregular(final Double amount, final LocalDate start, final LocalDate end, final List<LocalDate> executionDays) {
        super(amount, periodicity, start, end);
        this.executionDays = executionDays;
    }

    @Override
    public List<LocalDate> getExecutionDays(final LocalDate from, final LocalDate to) {
        return  executionDays;
    }

}
