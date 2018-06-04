package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MonthlyComparator implements ExecutionDaysComparator {

    @Override
    public List<LocalDate> getMatchingDays(List executionDays, Comparable period) {
        final List<LocalDate> daysList = new ArrayList<>();
        final LocalDate from = period.getFrom();
        final LocalDate to  = period.getTo();
        Integer dayOfMonth = 1;

        if(executionDays.get(0) instanceof Integer) {
            dayOfMonth = (Integer) executionDays.get(0);
        }

        LocalDate initialDate = LocalDate.of(from.getYear(), from.getMonth(), dayOfMonth);
        LocalDate dayToCompare = LocalDate.of(from.getYear(), from.getMonth(), dayOfMonth);
        int monthsToAdd = 1;

        while(to.isAfter(dayToCompare)) {
            if(from.isBefore(dayToCompare) || from.isEqual(dayToCompare)) {
                daysList.add(dayToCompare);
            }
            dayToCompare = initialDate.plusMonths(monthsToAdd);
            monthsToAdd++;
        }
        return daysList;
    }
}
