package com.iluwatar.command;

import java.util.Deque;
import java.util.LinkedList;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@PrepareForTest(LOGGER.class)
public class WizardAutoTest {
    @Mock
    private Deque<Command> undoStack;

    @Mock
    private Deque<Command> redoStack;

    @InjectMocks
    private Wizard wizard;

    private Wizard wizardSpy = spy(wizard);

    private final ErrorCollector errorCollector = new ErrorCollector();

    private final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public final RuleChain ruleChain = RuleChain.outerRule(errorCollector).around(expectedException);

    @Before
    public void setUp() throws Exception {
        mockStatic(LOGGER.class);
        MockitoAnnotations.initMocks(this);
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenCommandAndTargetWhenCastSpellThenVerifyResult() {
        // Arrange
        Command command = mock(Command.class);
        Target target = mock(Target.class);

        // Act
        wizard.castSpell(command, target);

        // Assert
        verifyStatic(LOGGER).info(/* The arg is not mocked. Use Matchers or provide value. */, wizard, command, target);
        verify(wizardSpy).execute(target);
        verify(wizardSpy).offerLast(command);
    }

    /**
    * This test verifies the following
    * If condition(60) : !undoStack.isEmpty() with value True.
    */
    @Test
    public void givenAndConditionOnLine60TrueWhenUndoLastSpellThenVerifyResult() {
        // Arrange
        // Set values such that condition (!undoStack.isEmpty())==True
        /* Type is not known */ previousSpell = /* TODO: Create a mock object to be returned. */;
        when(undoStack.pollLast()).thenReturn(previousSpell);

        // Act
        wizard.undoLastSpell();

        // Assert
        verify(wizardSpy).offerLast(previousSpell);
        verifyStatic(LOGGER).info(/* The arg is not mocked. Use Matchers or provide value. */, wizard, previousSpell);
        verify(wizardSpy).undo();
    }

    /**
    * This test verifies the following
    * If condition(60) : !undoStack.isEmpty() with value False.
    */
    @Test
    public void givenAndConditionOnLine60FalseWhenUndoLastSpellThenVerifyResult() {
        // Arrange
        // Set values such that condition (!undoStack.isEmpty())==False

        // Act
        wizard.undoLastSpell();
    }

    /**
    * This test verifies the following
    * If condition(72) : !redoStack.isEmpty() with value True.
    */
    @Test
    public void givenAndConditionOnLine72TrueWhenRedoLastSpellThenVerifyResult() {
        // Arrange
        // Set values such that condition (!redoStack.isEmpty())==True
        /* Type is not known */ previousSpell = /* TODO: Create a mock object to be returned. */;
        when(redoStack.pollLast()).thenReturn(previousSpell);

        // Act
        wizard.redoLastSpell();

        // Assert
        verify(wizardSpy).offerLast(previousSpell);
        verifyStatic(LOGGER).info(/* The arg is not mocked. Use Matchers or provide value. */, wizard, previousSpell);
        verify(wizardSpy).redo();
    }

    /**
    * This test verifies the following
    * If condition(72) : !redoStack.isEmpty() with value False.
    */
    @Test
    public void givenAndConditionOnLine72FalseWhenRedoLastSpellThenVerifyResult() {
        // Arrange
        // Set values such that condition (!redoStack.isEmpty())==False

        // Act
        wizard.redoLastSpell();
    }

    /**
    * This test verifies the following
    * The default execution of the method.
    */
    @Test
    public void givenWhenToStringThenVerifyResult() {
        // Act
        String result = wizard.toString();

        // Assert
        String expected = /* TODO: Create the expected result for this test */;
        errorCollector.checkThat(result, equalTo(expected));
    }
}
