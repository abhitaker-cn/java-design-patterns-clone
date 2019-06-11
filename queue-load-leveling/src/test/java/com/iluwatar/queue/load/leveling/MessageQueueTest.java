package com.iluwatar.queue.load.leveling;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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

@RunWith(MockitoJUnitRunner.class)
public class MessageQueueAutoTest {
    @InjectMocks
    private MessageQueue messageQueue;

    private MessageQueue messageQueueSpy = spy(messageQueue);

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
    * Try block on line {statement.line}
    * If condition(54) : null != msg with value True.
    */
    @Test
    public void givenMsgAndConditionOnLine54TrueWhenSubmitMsgThenVerifyResult() {
        // Arrange
        Message msg = mock(Message.class);
        /*Writing test for try block. Reuse mocks to create tests for catch clauses*/
        // Set values such that condition (null != msg)==True

        // Act
        messageQueue.submitMsg(msg);
    }

    /**
    * This test verifies the following
    * Try block on line {statement.line}
    * If condition(54) : null != msg with value False.
    */
    @Test
    public void givenMsgAndConditionOnLine54FalseWhenSubmitMsgThenVerifyResult() {
        // Arrange
        Message msg = mock(Message.class);
        /*Writing test for try block. Reuse mocks to create tests for catch clauses*/
        // Set values such that condition (null != msg)==False

        // Act
        messageQueue.submitMsg(msg);
    }

    /**
    * This test verifies the following
    * Try block on line {statement.line}
    */
    @Test
    public void givenWhenRetrieveMsgThenVerifyResult() {
        // Arrange
        /*Writing test for try block. Reuse mocks to create tests for catch clauses*/

        // Act
        Message result = messageQueue.retrieveMsg();

        // Assert
        Message expected = /* TODO: Create the expected result for this test */;
        errorCollector.checkThat(result, equalTo(expected));
    }
}
