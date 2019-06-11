package com.iluwatar.command;

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

@RunWith(MockitoJUnitRunner.class)
public class ShrinkSpellAutoTest {
    @Mock
    private Size oldSize;

    @Mock
    private Target target;

    @InjectMocks
    private ShrinkSpell shrinkSpell;

    private ShrinkSpell shrinkSpellSpy = spy(shrinkSpell);

    private final ErrorCollector errorCollector = new ErrorCollector();

    private final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public final RuleChain ruleChain = RuleChain.outerRule(errorCollector).around(expectedException);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenTargetWhenExecuteThenVerifyResult() {
        // Arrange
        Target target_1 = mock(Target.class);
        /* Type is not known */ oldSize_1 = /* TODO: Create a mock object to be returned. */;
        when(target_1.getSize()).thenReturn(oldSize_1);

        // Act
        shrinkSpell.execute(target_1);

        // Assert
        verify(shrinkSpellSpy).setSize(/* The arg is not mocked. Use Matchers or provide value. */);
    }

    /**
    * This test verifies the following
    * If condition(44) : oldSize != null && target != null with value True.
    */
    @Test
    public void givenAndConditionOnLine44TrueWhenUndoThenVerifyResult() {
        // Arrange
        // Set values such that condition (oldSize != null && target != null)==True
        /* Type is not known */ temp = /* TODO: Create a mock object to be returned. */;
        when(target.getSize()).thenReturn(temp);

        // Act
        shrinkSpell.undo();

        // Assert
        verify(shrinkSpellSpy).setSize(oldSize_1);
    }

    /**
    * This test verifies the following
    * If condition(44) : oldSize != null && target != null with value False.
    */
    @Test
    public void givenAndConditionOnLine44FalseWhenUndoThenVerifyResult() {
        // Arrange
        // Set values such that condition (oldSize != null && target != null)==False

        // Act
        shrinkSpell.undo();
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenWhenRedoThenVerifyResult() {
        // Arrange
        doNothing().when(shrinkSpellSpy).undo();

        // Act
        shrinkSpell.redo();

        // Assert
        verify(shrinkSpellSpy).undo();
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenWhenToStringThenVerifyResult() {
        // Act
        String result = shrinkSpell.toString();

        // Assert
        String expected = /* TODO: Create the expected result for this test */;
        errorCollector.checkThat(result, equalTo(expected));
    }
}
