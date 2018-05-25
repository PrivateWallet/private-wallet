package com.mp.privatewallet.wallet.collections;

import java.time.LocalDate;
import java.util.List;

public interface ImpactStrategy {

    public List<LocalDate> getExecutionDays(LocalDate from, LocalDate to);
}
