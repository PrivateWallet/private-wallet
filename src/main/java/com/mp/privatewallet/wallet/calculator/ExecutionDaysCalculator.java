package com.mp.privatewallet.wallet.calculator;

import java.time.LocalDate;
import java.util.List;

public interface ExecutionDaysCalculator {

    List<LocalDate> getExecutionDays(LocalDate from, LocalDate to);

}
