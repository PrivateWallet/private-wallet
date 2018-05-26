package com.mp.privatewallet.wallet.flows;

import java.time.LocalDate;
import java.util.List;

/**
 * An interface for cashflows
 */
public interface ImpactStrategy {

    /**
     * @param localDate
     * @return Based on cash flow type localDate should be mapped to day of week, month or year.
     */
    Integer getComparableIntBasedOnDate(LocalDate localDate);

    /**
     * @return Based on cash flow type this method should returns list of days of week, month, or year mapped to Integer
     */
    List<Integer> getExecutionDays();
}
