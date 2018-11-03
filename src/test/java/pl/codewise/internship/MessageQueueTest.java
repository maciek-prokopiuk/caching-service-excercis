package pl.codewise.internship;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MessageQueueTest {
    private static MessageQueueComponent messenger = new MessageQueueComponent();

    @BeforeClass
    public static void fillMessengerDeque(){
        for(int i = 0; i < 150; i++) {
            messenger.add(new Message("Test123", 0));
        }
    }

    @Test
    public void testAddingMessage(){
        Assert.assertEquals(100, messenger.snapshot().getSnapshot().size());
    }

    @Test
    public void testGetNumberOfErrors(){
        messenger.add(new Message("321tseT", 404));
        messenger.add(new Message("321tseT", 200));
        Assert.assertEquals(1, messenger.numberOfErrorMessages());
    }
}

