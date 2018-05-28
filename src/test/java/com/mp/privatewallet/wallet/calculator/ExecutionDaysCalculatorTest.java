package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.flows.*;
import com.mp.privatewallet.wallet.period.Comparable;
import com.mp.privatewallet.wallet.period.Period;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ExecutionDaysCalculatorTest {


    @Test
    public void listSizeForDailyShouldBeSeven() {
        //given
        final Comparable period = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final ImpactStrategy daily = new Daily(10.0, period);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(daily);
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusDays(7));
        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(customPeriod);

        //then
        assertEquals(7, listOfDates.size());
    }

    @Test
    public void listSizeForMonthlyShouldBeOne() {
        //given
        final Comparable period = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final ImpactStrategy monthly = new Monthly(10.0, period);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(monthly);
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(1));

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(customPeriod);

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForAnnuallyShouldBeOne() {
        //given
        final Comparable period = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final ImpactStrategy annually = new Annually(10.0, period);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(annually);
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusYears(1));

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(customPeriod);

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForOnceShouldBeOne() {
        //given
        final Comparable period = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final ImpactStrategy once = new Once(10.0, period, LocalDate.now());
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(once);
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(1));

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(customPeriod);

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForIrregularShouldBeOne() {
        //given
        final Comparable period = new Period(LocalDate.now(), LocalDate.now().plusYears(1));
        final List<LocalDate> listOfExecutionDates = new ArrayList();
        listOfExecutionDates.add(LocalDate.now());
        listOfExecutionDates.add(LocalDate.now().plusDays(1));
        listOfExecutionDates.add(LocalDate.now().plusDays(2));
        final ImpactStrategy irregular = new Irregular(10.0, period, listOfExecutionDates);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(irregular);
        final Comparable customPeriod = new Period(LocalDate.now(), LocalDate.now().plusMonths(1));

        //when
        List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(customPeriod);

        //then
        assertEquals(3, listOfDates.size());
    }

}
