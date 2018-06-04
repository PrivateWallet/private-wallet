package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyComparator implements ExecutionDaysComparator {

    @Override
    public List<LocalDate> getMatchingDays(List executionDays, Comparable period) {
        List<LocalDate> daysList = new ArrayList<>();
        LocalDate dateToCompare = period.getFrom();

        while((period.getFrom().isEqual(dateToCompare) || period.getFrom().isBefore(dateToCompare))
                && (period.getTo().isAfter(dateToCompare))) {
            daysList.add(dateToCompare);
            dateToCompare = dateToCompare.plusDays(1);
        }
        return daysList;
    }

}
