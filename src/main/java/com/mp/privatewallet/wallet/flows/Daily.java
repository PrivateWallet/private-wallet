package com.mp.privatewallet.wallet.flows;

import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.perodicity.PeriodicityEnum;
import lombok.Data;
import java.util.Collections;
import java.util.List;

@Data
public class Daily extends CashFlow {

    public final static PeriodicityEnum periodicity = PeriodicityEnum.DAILY;

    public Daily(final Double amount, final Comparable period) {
        super(amount, periodicity, period);
    }

    @Override
    public List getExecutionDays() {
        return Collections.emptyList();
    }

}
