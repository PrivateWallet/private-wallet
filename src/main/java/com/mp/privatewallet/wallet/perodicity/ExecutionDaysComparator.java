package com.mp.privatewallet.wallet.perodicity;

import java.time.LocalDate;
import java.util.Set;

public interface ExecutionDaysComparator {

    boolean isDateMatching(Set executionDays, LocalDate dayToMatch);
}
