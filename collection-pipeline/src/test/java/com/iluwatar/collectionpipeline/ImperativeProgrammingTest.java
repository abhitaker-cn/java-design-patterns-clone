package com.iluwatar.collectionpipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.RuleChain;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Collections.class)
public class ImperativeProgrammingAutoTest {
    @InjectMocks
    private ImperativeProgramming imperativeProgramming;

    private ImperativeProgramming imperativeProgrammingSpy = spy(imperativeProgramming);

    private final ErrorCollector errorCollector = new ErrorCollector();

    private final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public final RuleChain ruleChain = RuleChain.outerRule(errorCollector).around(expectedException);

    @Before
    public void setUp() throws Exception {
        mockStatic(Collections.class);
        MockitoAnnotations.initMocks(this);
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenCarsWhenGetModelsAfter2000ThenVerifyResult() {
        // Arrange
        List<Car> cars = mock(List.class);

        // Act
        List<String> result = imperativeProgramming.getModelsAfter2000(cars);

        // Assert
        List<String> expected = /* TODO: Create the expected result for this test */;
        errorCollector.checkThat(result, equalTo(expected));
        verifyStatic(Collections).sort(/* The arg is not mocked. Use Matchers or provide value. */, /* The arg is not mocked. Use Matchers or provide value. */);
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenCarsWhenGetGroupingOfCarsByCategoryThenVerifyResult() {
        // Arrange
        List<Car> cars = mock(List.class);

        // Act
        Map<Category, List<Car>> result = imperativeProgramming.getGroupingOfCarsByCategory(cars);

        // Assert
        Map<Category, List<Car>> expected = /* TODO: Create the expected result for this test */;
        errorCollector.checkThat(result, equalTo(expected));
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenPersonsWhenGetSedanCarsOwnedSortedByDateThenVerifyResult() {
        // Arrange
        List<Person> persons = mock(List.class);

        // Act
        List<Car> result = imperativeProgramming.getSedanCarsOwnedSortedByDate(persons);

        // Assert
        List<Car> expected = /* TODO: Create the expected result for this test */;
        errorCollector.checkThat(result, equalTo(expected));
    }
}
