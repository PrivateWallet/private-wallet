package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.period.Comparable;

import java.time.LocalDate;
import java.util.List;

public interface ExecutionDaysCalculator {

    List<LocalDate> getExecutionDaysForShorterPeriod(final Comparable period);
    List<LocalDate> getExecutionDays();


}
