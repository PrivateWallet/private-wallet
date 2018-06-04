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

    private final LocalDate firstDayOf2018 = LocalDate.of(2018, 1, 1);
    private final LocalDate firstDayOf2018PlusOneWeek = firstDayOf2018.plusWeeks(1);
    private final LocalDate firstDayOf2018PlusOneMonth = firstDayOf2018.plusMonths(1);
    private final LocalDate firstDayOf2019 = LocalDate.of(2019, 1, 1);
    private final Comparable period = new Period(firstDayOf2018, firstDayOf2019);


    @Test
    public void listSizeForDailyShouldBeSeven() {
        //given
        final ImpactStrategy daily = new Daily(10.0, period);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(daily);
        final Comparable customPeriod = new Period(firstDayOf2018, firstDayOf2018PlusOneWeek);
        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDaysForShorterPeriod(customPeriod);

        //then
        assertEquals(7, listOfDates.size());
    }

    @Test
    public void listSizeForMonthlyShouldBeOne() {
        //given
        final ImpactStrategy monthly = new Monthly(10.0, period);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(monthly);
        final Comparable customPeriod = new Period(firstDayOf2018, firstDayOf2018PlusOneMonth);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDaysForShorterPeriod(customPeriod);

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForAnnuallyShouldBeOne() {
        //given
        final ImpactStrategy annually = new Annually(10.0, period);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(annually);
        final Comparable customPeriod = new Period(firstDayOf2018, firstDayOf2019);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDaysForShorterPeriod(customPeriod);

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForOnceShouldBeOne() {
        //given
        final ImpactStrategy once = new Once(10.0, period, LocalDate.of(2018, 1, 5));
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(once);
        final Comparable customPeriod = new Period(firstDayOf2018, firstDayOf2018PlusOneMonth);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDaysForShorterPeriod(customPeriod);

        //then
        assertEquals(1, listOfDates.size());
    }

    @Test
    public void listSizeForIrregularShouldBeOne() {
        //given
        final List<LocalDate> listOfExecutionDates = new ArrayList<>();
        listOfExecutionDates.add(firstDayOf2018);
        listOfExecutionDates.add(firstDayOf2018.plusDays(1));
        listOfExecutionDates.add(firstDayOf2018.plusDays(2));
        final ImpactStrategy irregular = new Irregular(10.0, period, listOfExecutionDates);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(irregular);
        final Comparable customPeriod = new Period(firstDayOf2018, firstDayOf2018PlusOneMonth);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDaysForShorterPeriod(customPeriod);

        //then
        assertEquals(3, listOfDates.size());
    }

    @Test
    public void listSizeForWeeklyShouldBeFour() {
        //given
        final ImpactStrategy once = new Weekly(10.0, period, 1);
        final ExecutionDaysCalculator executionDaysCalculator = new ExecutionDaysCalculatorEngine(once);
        final Comparable customPeriod = new Period(firstDayOf2018, firstDayOf2018PlusOneMonth);

        //when
        final List<LocalDate> listOfDates = executionDaysCalculator.getExecutionDaysForShorterPeriod(customPeriod);

        //then
        assertEquals(4, listOfDates.size());
    }

}
