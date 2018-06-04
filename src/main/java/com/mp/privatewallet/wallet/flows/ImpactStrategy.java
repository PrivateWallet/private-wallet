package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import java.util.List;

/**
 * An interface for cashflows
 */
public interface ImpactStrategy {

    List<Object> getExecutionDays();

    PeriodicityEnum getPeriodicity();

    Comparable getPeriod();

    Double getAmount();

}
