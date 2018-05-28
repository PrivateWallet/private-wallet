package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import java.util.Set;

/**
 * An interface for cashflows
 */
public interface ImpactStrategy {

    Set<Object> getExecutionDays();

    PeriodicityEnum getPeriodicity();

    Comparable getPeriod();

}
