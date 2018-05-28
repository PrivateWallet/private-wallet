package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
public abstract class CashFlow implements ImpactStrategy {

    private Double amount;

    private PeriodicityEnum periodicity;

    //We should consider to create a separate class for time management
    private final LocalDate creationDate;

    private Comparable period;

    public CashFlow(final Double amount, final PeriodicityEnum periodicity, final Comparable period) {
        this.amount = amount;
        this.periodicity = periodicity;
        this.creationDate = LocalDate.now();
        this.period = period;
    }

    @Override
    public PeriodicityEnum getPeriodicity() {
        return periodicity;
    }

    @Override
    public Comparable getPeriod() {
        return period;
    }
}
