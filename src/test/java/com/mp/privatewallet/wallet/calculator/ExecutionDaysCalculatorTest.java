package com.mp.privatewallet.wallet.calculator;

import com.mp.privatewallet.wallet.flows.*;
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
        final ImpactStrategy daily = new Daily(10.0, LocalDate.now(), LocalDate.now().plusYears(1));
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(daily);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(LocalDate.now(), LocalDate.now().plusDays(7));

        //then
        assertEquals(7, listOfDates.size());
    }

    @Test
    public void listSizeForMonthlyShouldBeOne() {
        //given
        final ImpactStrategy monthly = new Monthly(10.0, LocalDate.now(), LocalDate.now().plusYears(1));
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(monthly);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(LocalDate.now(), LocalDate.now().plusMonths(1));

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForAnnuallyShouldBeOne() {
        //given
        final ImpactStrategy annually = new Annually(10.0, LocalDate.now(), LocalDate.now().plusYears(1));
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(annually);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(LocalDate.now(), LocalDate.now().plusYears(1));

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForOnceShouldBeOne() {
        //given
        final ImpactStrategy once = new Once(10.0, LocalDate.now(), LocalDate.now().plusYears(1), LocalDate.now());
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(once);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(LocalDate.now(), LocalDate.now().plusMonths(1));

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForIrregularShouldBeOne() {
        //given
        final List<LocalDate> listOfExecutionDates = new ArrayList();
        listOfExecutionDates.add(LocalDate.now());
        listOfExecutionDates.add(LocalDate.now().plusDays(1));
        listOfExecutionDates.add(LocalDate.now().plusDays(2));
        final ImpactStrategy irregular = new Irregular(10.0, LocalDate.now(), LocalDate.now().plusYears(1), listOfExecutionDates);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(irregular);

        //when
        List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDays(LocalDate.now(), LocalDate.now().plusMonths(1));

        //then
        assertEquals(3, listOfDates.size());
    }

}
