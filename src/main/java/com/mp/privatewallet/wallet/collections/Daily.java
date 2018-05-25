package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Daily extends CashFlow implements ImpactStrategy {

    public static PeriodicityEnum periodicity = PeriodicityEnum.DAILY;

    public Daily(Double amount, LocalDate start, LocalDate end) {
        super(amount, periodicity, start, end);
    }

    @Override
    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to) {
        return null;
    }
}
