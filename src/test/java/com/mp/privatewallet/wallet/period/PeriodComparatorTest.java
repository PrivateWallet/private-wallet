package com.mp.privatewallet.wallet.period;

import com.mp.privatewallet.wallet.period.exceptions.PeriodComparatorException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import java.time.LocalDate;

@SpringBootTest
public class PeriodComparatorTest {

//TODO: method names should be more clearly
    @Test
    public void getUpdatedPeriodTest() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final Comparable customPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));

        //when
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), customPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), customPeriod.getTo());
    }

    @Test
    public void getUpdatedPeriodTest2() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(5));
        final Comparable customPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusYears(1));

        //when
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), customPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), cashFlowPeriod.getTo());
    }

    @Test
    public void getUpdatedPeriodTest3() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusYears(1));
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(5));

        //when
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), cashFlowPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), customPeriod.getTo());
    }

    @Test
    public void getUpdatedPeriodTest4() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusYears(1));

        //when
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), cashFlowPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), cashFlowPeriod.getTo());
    }

    @Test(expected = RuntimeException.class)
    public void getUpdatedPeriodTestShouldThrowException() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));
        final Comparable customPeriod = new Period(LocalDate.now().plusYears(1), LocalDate.now().plusYears(2));

        //when
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlowPeriod, customPeriod);
    }

    @Test(expected = PeriodComparatorException.class)
    public void getUpdatedPeriodTestShouldThrowException2() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusYears(1), LocalDate.now().plusYears(2));
        final Comparable customPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));

        //when
        final Comparable updatedPeriod = PeriodComparator.getUpdatedPeriod(cashFlowPeriod, customPeriod);
    }

}
