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
    @Test
    public void should_return_10_when_given_roll_0_roll_5_roll_0_roll_5() {
        //given
        BowlingGame bowlingGame = new BowlingGame(10, 2);

        //when
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);


        //then
        assertEquals(10, bowlingGame.getScore());
        assertEquals("5|5", bowlingGame.getRecord());
    }
    @Test
    public void should_return_false_when_given_roll_4_times() {
        //given
        BowlingGame bowlingGame = new BowlingGame(10, 2);

        //when
        bowlingGame.roll(0);
        bowlingGame.roll(5);
        bowlingGame.roll(0);
        bowlingGame.roll(5);

        //then
        Assert.assertFalse(bowlingGame.isEnd());
    }

    @Test
    public void should_return_true_when_given_roll_20_times() {
        //given
        BowlingGame bowlingGame = new BowlingGame(10, 2);

        //when
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }

        //then
        Assert.assertTrue(bowlingGame.isEnd());
    }

    @Test
    public void should_return_false_when_given_roll_20() {
        //given
        BowlingGame bowlingGame = new BowlingGame(10, 2);

        //when
        for(int i =0;i<20;i++){
            bowlingGame.roll(5);
        }

        //then
        Assert.assertFalse(bowlingGame.isEnd());
    }


}
