package com.mp.privatewallet.wallet.perodicity;

public enum PeriodicityEnum {

    DAILY(new DailyComparator()),
    WEEKLY(new WeeklyComparator()),
    MONTHLY(new MonthlyComparator()),
    ANNUALLY(new AnnuallyComparator()),
    ONCE(new IrregularComparator()),
    IRREGULAR(new IrregularComparator()),;

    private ExecutionDaysComparator executionDaysComparator;

    PeriodicityEnum(final ExecutionDaysComparator executionDaysComparator) {
        this.executionDaysComparator = executionDaysComparator;
    }

    public ExecutionDaysComparator getComparator() {
        return this.executionDaysComparator;
    }

}
