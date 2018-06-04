package com.mp.privatewallet.wallet.period;

import com.mp.privatewallet.wallet.period.exceptions.PeriodComparatorException;
import com.mp.privatewallet.wallet.period.exceptions.WrongPeriodException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import java.time.LocalDate;

@SpringBootTest
public class PeriodComparatorTest {

    @Test
    public void periodComparatorShouldReturnCommonPartOfPeriods() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final Comparable customPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));

        //when
        final Comparable updatedPeriod = PeriodComparator.getCommonPartOfPeriods(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), customPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), customPeriod.getTo());
    }

    @Test
    public void periodComparatorShouldReturnCommonPartOfPeriods2() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(5));
        final Comparable customPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusYears(1));

        //when
        final Comparable updatedPeriod = PeriodComparator.getCommonPartOfPeriods(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), customPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), cashFlowPeriod.getTo());
    }

    @Test
    public void periodComparatorShouldReturnCommonPartOfPeriods3() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusYears(1));
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(5));

        //when
        final Comparable updatedPeriod = PeriodComparator.getCommonPartOfPeriods(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), cashFlowPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), customPeriod.getTo());
    }

    @Test
    public void periodComparatorShouldReturnCommonPartOfPeriods4() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusYears(1));

        //when
        final Comparable updatedPeriod = PeriodComparator.getCommonPartOfPeriods(cashFlowPeriod, customPeriod);

        //then
        assertEquals(updatedPeriod.getFrom(), cashFlowPeriod.getFrom());
        assertEquals(updatedPeriod.getTo(), cashFlowPeriod.getTo());
    }

    @Test(expected = PeriodComparatorException.class)
    public void shouldThrowExceptionWhenPeriodsDontHaveCommonPart() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));
        final Comparable customPeriod = new Period(LocalDate.now().plusYears(1), LocalDate.now().plusYears(2));

        //when
        PeriodComparator.getCommonPartOfPeriods(cashFlowPeriod, customPeriod);
    }

    @Test(expected = PeriodComparatorException.class)
    public void shouldThrowExceptionWhenPeriodsDontHaveCommonPart2() {
        //given
        final Comparable cashFlowPeriod = new Period(LocalDate.now().plusYears(1), LocalDate.now().plusYears(2));
        final Comparable customPeriod = new Period(LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));

        //when
        PeriodComparator.getCommonPartOfPeriods(cashFlowPeriod, customPeriod);
    }

    @Test(expected = WrongPeriodException.class)
    public void shouldThrowExceptionWhenFromIsLaterThanTo() {
        final Comparable period = new Period(LocalDate.now().plusYears(1), LocalDate.now());
    }

}
