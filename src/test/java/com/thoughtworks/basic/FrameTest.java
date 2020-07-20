package com.thoughtworks.basic;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class FrameTest {
    @Test
    public void should_return_3_when_given_roll_0_roll_3() {
        //given
        Frame frame = new Frame(2);

        //when
        frame.roll(0);
        frame.roll(3);

        //then
        assertEquals(3, frame.getScore());
    }


}
