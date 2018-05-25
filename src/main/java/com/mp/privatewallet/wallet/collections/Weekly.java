package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Weekly extends CashFlow implements ImpactStrategy {

    public static PeriodicityEnum periodicity = PeriodicityEnum.WEEKLY;

    /**
     *  Default value for execution day is monday.
     */
    private Integer dayOfWeek = 1;

    public Weekly(Double amount, LocalDate start, LocalDate end) {
        super(amount, periodicity, start, end);
    }

    public Weekly(Double amount, LocalDate start, LocalDate end, Integer dayOfWeek) {
        super(amount, periodicity, start, end);
        //TODO: exception when value is x < 1 && x > 7, eg. 'WrongExecutionValueException'
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to) {
        return null;
    }
}
