package com.iluwatar.queue.load.leveling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class MessageQueueManualTest {

    @Test
    public void messageQueueManualTest() {

        MessageQueue msgQueue = new MessageQueue();

        // submit message
        msgQueue.submitMsg(new Message("MessageQueue Test"));

        // retrieve message
        assertEquals("MessageQueue Test", msgQueue.retrieveMsg().getMsg());
    }
}
