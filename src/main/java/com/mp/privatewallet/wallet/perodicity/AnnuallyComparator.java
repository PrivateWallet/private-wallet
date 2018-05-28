package com.mp.privatewallet.wallet.perodicity;

import java.time.LocalDate;
import java.util.Set;

public class AnnuallyComparator implements ExecutionDaysComparator {

    @Override
    public boolean isDateMatching(final Set executionDays, final LocalDate dayToMatch) {
        return executionDays.contains(dayToMatch.getDayOfYear());
    }
}
