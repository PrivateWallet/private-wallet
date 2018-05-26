package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Irregular extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.IRREGULAR;

    private final List<LocalDate> executionDates;

    public Irregular(final Double amount, final LocalDate start, final LocalDate end, final List<LocalDate> executionDates) {
        super(amount, periodicity, start, end);
        this.executionDates = executionDates;
    }

    @Override
    public Integer getComparableIntBasedOnDate(LocalDate localDate) {
        return localDate.getDayOfYear();
    }

    @Override
    public List<Integer> getExecutionDays() {
        final List<Integer> mapedDatesToDaysOfYear = new ArrayList();
        executionDates.forEach(date -> mapedDatesToDaysOfYear.add(date.getDayOfYear()));
        return mapedDatesToDaysOfYear;
    }
}

