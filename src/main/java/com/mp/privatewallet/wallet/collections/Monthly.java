package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Monthly extends CashFlow implements ImpactStrategy {

    public static PeriodicityEnum periodicity = PeriodicityEnum.MONTHLY;

    /**
     *  Default value for execution day is first day of month.
     */
    private Integer dayOfMonth = 1;

    public Monthly(Double amount, LocalDate start, LocalDate end) {
        super(amount, periodicity, start, end);
    }

    public Monthly(Double amount, LocalDate start, LocalDate end, Integer dayOfMonth) {
        super(amount, periodicity, start, end);
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to) {
        return null;
    }
}
