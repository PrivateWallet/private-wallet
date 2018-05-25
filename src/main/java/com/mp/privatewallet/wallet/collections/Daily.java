package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Daily extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.DAILY;

    public Daily(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    @Override
    public List<LocalDate> getExecutionDays(final LocalDate from, final LocalDate to) {
        return null;
    }
}
