package com.iluwatar.queue.load.leveling;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
