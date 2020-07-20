package com.thoughtworks.basic;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class bowlinesGameTest {
    @Test
    public void should_return_5_when_given_roll_5_roll_0() {
        //given
        BowlingGame bowlingGame = new BowlingGame(10, 2);

        //when
        bowlingGame.roll(0);
        bowlingGame.roll(5);

        //then
        assertEquals(5, bowlingGame.getScore());
        assertEquals("5", bowlingGame.getRecord());
    }


}
