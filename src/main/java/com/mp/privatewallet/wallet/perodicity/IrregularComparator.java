package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IrregularComparator implements ExecutionDaysComparator {

    @Override
    public List<LocalDate> getMatchingDays(List executionDays, Comparable period) {
        List<LocalDate> castedExecutionDaysList = new ArrayList<>(executionDays);
        List<LocalDate> matchingDays = new ArrayList<>();
        castedExecutionDaysList.stream().forEach(data -> {
            if((data.isEqual(period.getFrom())) || data.isAfter(period.getFrom()) &&  data.isBefore(period.getTo())) {
                matchingDays.add(data);
            }
        });
        return matchingDays;
    }

}
