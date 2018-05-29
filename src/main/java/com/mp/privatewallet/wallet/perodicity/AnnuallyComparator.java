package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnnuallyComparator implements ExecutionDaysComparator {

    @Override
    public List<LocalDate> getMatchingDays(List executionDays, Comparable period) {
        final List<LocalDate> daysList = new ArrayList<>();
        final LocalDate from = period.getFrom();
        final LocalDate to  = period.getTo();
        Integer dayOfYear = 1;
        if(executionDays.get(0) instanceof Integer) {
            dayOfYear = (Integer) executionDays.get(0);
        }

        LocalDate dayToCompare = LocalDate.ofYearDay(period.getFrom().getYear(), dayOfYear);

        while(to.isAfter(dayToCompare)) {
            if(from.isBefore(dayToCompare)) {
                daysList.add(dayToCompare);
            }
            dayToCompare = dayToCompare.plusYears(1);
        }
        return daysList;
    }
}
