package com.mp.privatewallet.wallet.collections;

import java.time.LocalDate;
import java.util.List;

public interface ImpactStrategy {

    List<LocalDate> getExecutionDays(final LocalDate from, final LocalDate to);
}
