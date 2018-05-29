package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeeklyComparator implements ExecutionDaysComparator {

    @Override
    public List<LocalDate> getMatchingDays(List executionDays, Comparable period) {
        final List<LocalDate> daysList = new ArrayList<>();
        final LocalDate from = period.getFrom();
        final LocalDate to  = period.getTo();
        Integer dayOfWeek= 1;

        if(executionDays.get(0) instanceof Integer) {
            dayOfWeek = (Integer) executionDays.get(0);
        }
        LocalDate dayToCompare = LocalDate.of(from.getYear(), from.getMonth(), dayOfWeek);
        while(to.isAfter(dayToCompare)) {
            if(from.isBefore(dayToCompare)) {
                daysList.add(dayToCompare);
            }
            dayToCompare = dayToCompare.plusWeeks(1);
        }
        return daysList;
    }

}
