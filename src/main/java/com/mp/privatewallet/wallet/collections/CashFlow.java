package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.enums.Direction;
import com.mp.privatewallet.wallet.enums.Periodicity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public abstract class CashFlow {

    private Double amount;

    private Periodicity periodicity;

    private Direction direction;

    private LocalDate creationDate;

    public CashFlow(final Double amount, final Periodicity periodicity, final Direction direction) {
        this.amount = amount;
        this.periodicity = periodicity;
        this.direction = direction;
        this.creationDate = LocalDate.now();
    }

}
