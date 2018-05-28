package com.mp.privatewallet.wallet.period;

import com.mp.privatewallet.wallet.period.exceptions.WrongPeriodException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PeriodTest {


    @Test(expected = WrongPeriodException.class)
    public void shouldThrowWrongPeriodExceptionWhenFromDateIsLaterThanToDate() {
        //given
        final LocalDate from = LocalDate.now().plusYears(1);
        final LocalDate to = LocalDate.now();

        //then
        Comparable period = new Period(from, to);
    }

}
