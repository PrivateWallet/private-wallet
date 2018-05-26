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
        ImpactStrategy daily = new Daily(10.0, LocalDate.now(), LocalDate.of(2018, 6, 2));
        List<LocalDate> listOfDates = ExecutionDaysCalculator.getExecutionDays(daily, LocalDate.now(), LocalDate.now().plusDays(7));

        //then
        assertEquals(7, listOfDates.size());
    }

    @Test
    public void listSizeForMonthlyShouldBeOne() {
        ImpactStrategy monthly = new Monthly(10.0, LocalDate.now(), LocalDate.of(2018, 6, 2));
        List<LocalDate> listOfDates = ExecutionDaysCalculator.getExecutionDays(monthly, LocalDate.now(), LocalDate.now().plusMonths(1));

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForAnnuallyShouldBeOne() {
        ImpactStrategy annually = new Annually(10.0, LocalDate.now(), LocalDate.of(2018, 6, 2));
        List<LocalDate> listOfDates = ExecutionDaysCalculator.getExecutionDays(annually, LocalDate.now(), LocalDate.now().plusYears(1));

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForOnceShouldBeOne() {
        ImpactStrategy monthly = new Once(10.0, LocalDate.now(), LocalDate.of(2018, 6, 2), LocalDate.now());
        List<LocalDate> listOfDates = ExecutionDaysCalculator.getExecutionDays(monthly, LocalDate.now(), LocalDate.now().plusMonths(1));

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForIrregularShouldBeOne() {
        List<LocalDate> listOfExecutionDates = new ArrayList();
        listOfExecutionDates.add(LocalDate.now());
        listOfExecutionDates.add(LocalDate.now().plusDays(1));
        listOfExecutionDates.add(LocalDate.now().plusDays(2));
        ImpactStrategy monthly = new Irregular(10.0, LocalDate.now(), LocalDate.of(2018, 6, 2), listOfExecutionDates);

        List<LocalDate> listOfDates = ExecutionDaysCalculator.getExecutionDays(monthly, LocalDate.now(), LocalDate.now().plusMonths(1));

        //then
        assertEquals(3, listOfDates.size());
    }

}
