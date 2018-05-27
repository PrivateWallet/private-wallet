package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Data
public class Daily extends CashFlow implements ImpactStrategy {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.DAILY;

    public Daily(final Double amount, final LocalDate start, final LocalDate end) {
        super(amount, periodicity, start, end);
    }

    @Override
    public Set getExecutionDays() {
        return Collections.emptySet();
    }

}
