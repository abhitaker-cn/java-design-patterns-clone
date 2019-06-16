package com.iluwatar.queue.load.leveling;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageQueueTest {

  @Mock
  BlockingQueue<Message> blkQueue;

  @InjectMocks
  MessageQueue msgQueue;

  @Test
  public void submitMsgTest() {

    doReturn(true).when(blkQueue).add(any(Message.class));

    Message msg = new Message("MessageQueue Test");
    msgQueue.submitMsg(msg);

    verify(blkQueue, atLeastOnce()).add(msg);
  }

  @Test
  public void submitMsgNullTest() {

    doReturn(true).when(blkQueue).add(any(Message.class));

    Message msg = null;
    msgQueue.submitMsg(msg);

    verify(blkQueue, never()).add(msg);
  }

  @Test
  public void retrieveMsgTest() {

    Message expectedMsg = new Message("MessageQueue Test");

    doReturn(expectedMsg).when(blkQueue).poll();

    Message actualMsg = msgQueue.retrieveMsg();

    verify(blkQueue, atLeastOnce()).poll();
    assertEquals(expectedMsg, actualMsg);
  }

  @Test
  public void retrieveMsgNullTest() {

    doThrow(new RuntimeException()).when(blkQueue).poll();

    Message msg = msgQueue.retrieveMsg();

    verify(blkQueue, atLeastOnce()).poll();
    assertEquals(null, msg);
  }
}