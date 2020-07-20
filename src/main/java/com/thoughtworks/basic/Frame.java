package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminzxl
 */
public class Frame {

    private int rollSize;
    private List<Integer> rolls;
    private int currentSize;
    public Frame(int rollSize){
        this.rollSize = rollSize;
        this.currentSize = 0;
        rolls = new ArrayList<>();
    }

    public void roll(int hits) {
        if (!isEnd()) {
            rolls.add(hits);
            currentSize++;
        }
    }

    public int getScore() {
        int result = 0;
        for (Integer integer : rolls) {
            result += integer;
        }
        return result;
    }



    public boolean isEnd() {
        return currentSize >= rollSize;
    }

    public int getScoreByRollTime(int i) {
        return i;
    }
}

