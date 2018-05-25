package com.mp.privatewallet.wallet.collections;


import com.mp.privatewallet.wallet.enums.PeriodicityEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Document
public abstract class CashFlow {

    private Double amount;

    //This field will allows to find CashFlow By type
    private PeriodicityEnum periodicity;

    //We should consider to create a separate class for time management
    private LocalDate creationDate;

    private LocalDate start;

    private LocalDate end;

    public CashFlow(final Double amount, final PeriodicityEnum periodicity, final LocalDate start, final LocalDate end) {
        this.amount = amount;
        this.periodicity = periodicity;
        this.creationDate = LocalDate.now();
        this.start = start;
        this.end = end;
    }
}
