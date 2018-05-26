package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Weekly extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.WEEKLY;

    /**
     *  Default value for execution day is monday.
     */
    private Integer dayOfWeek = 1;

    public Weekly(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    public Weekly(final Double amount, final LocalDate start, final LocalDate end, final Integer dayOfWeek) {
        super(amount, periodicity, start, end);
        //TODO: exception when value is x < 1 && x > 7, eg. 'WrongExecutionValueException'
        this.dayOfWeek = dayOfWeek;
    }


    @Override
    public Integer getComparableIntBasedOnDate(LocalDate localDate) {
        return localDate.getDayOfWeek().getValue();
    }

    @Override
    public List<Integer> getExecutionDays() {
        List<Integer> executionDayOfWeek = new ArrayList();
        executionDayOfWeek.add(dayOfWeek);
        return executionDayOfWeek;
    }
}

