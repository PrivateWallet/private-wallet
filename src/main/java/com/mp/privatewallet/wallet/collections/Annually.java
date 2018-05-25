package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class Annually extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.ANNUALLY;

    /**
     *  Default value for execution day is 1 january.
     */
    private Integer dayOfYear = 1;

    public Annually(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    public Annually(final Double amount, final LocalDate start, final LocalDate end, final Integer dayOfYear) {
        super(amount, periodicity, start, end);
        this.dayOfYear = dayOfYear;
    }

    @Override
    public List<LocalDate> getExecutionDays(final LocalDate from, final LocalDate to) {
        return null;
    }
}
