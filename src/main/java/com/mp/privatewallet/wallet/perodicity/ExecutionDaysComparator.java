package com.mp.privatewallet.wallet.perodicity;

import com.mp.privatewallet.wallet.period.Comparable;
import java.time.LocalDate;
import java.util.List;

public interface ExecutionDaysComparator {

    List<LocalDate> getMatchingDays(List executionDays, Comparable period);

}
