package com.mp.privatewallet.wallet.perodicity;

import java.time.LocalDate;
import java.util.Set;

public class IrregularComparator implements ExecutionDaysComparator {

    @Override
    public boolean isDateMatching(Set executionDays, LocalDate dayToMatch) {
       return executionDays.contains(dayToMatch);
    }

}
