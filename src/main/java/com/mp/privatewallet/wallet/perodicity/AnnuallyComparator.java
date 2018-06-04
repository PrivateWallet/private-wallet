package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnnuallyComparator implements ExecutionDaysComparator {

    private Integer defaultDayOfYear = 1;

    @Override
    public List<LocalDate> getMatchingDays(List executionDays, Comparable period) {
        Integer dayOfYear = defaultDayOfYear;
        final List<LocalDate> daysList = new ArrayList<>();
        final LocalDate from = period.getFrom();
        final LocalDate to  = period.getTo();

        if(executionDays.get(0) instanceof Integer) {
            dayOfYear = (Integer) executionDays.get(0);
        }

        LocalDate dayToCompare = LocalDate.ofYearDay(from.getYear(), dayOfYear);

        while(to.isAfter(dayToCompare)) {
            if(from.isBefore(dayToCompare) || from.isEqual(dayToCompare)) {
                daysList.add(dayToCompare);
            }
            dayToCompare = dayToCompare.plusYears(1);
        }
        return daysList;
    }
}
