package com.mp.privatewallet.wallet.enums;

public enum PeriodicityEnum {

    DAILY(new IrregularComparator()),
    WEEKLY(new WeeklyComparator()),
    MONTHLY(new MonthlyComparator()),
    ANNUALLY(new AnnuallyComparator()),
    ONCE(new IrregularComparator()),
    IRREGULAR(new IrregularComparator()),;

    private ExecutionDaysComparator executionDaysComparator;

    private PeriodicityEnum(final ExecutionDaysComparator executionDaysComparator) {
        this.executionDaysComparator = executionDaysComparator;
    }

    public ExecutionDaysComparator getComparator() {
        return this.executionDaysComparator;
    }

}
