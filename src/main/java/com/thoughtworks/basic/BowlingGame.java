package com.thoughtworks.basic;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Frame> frames;
    private List<Integer> frameScores;
    private int currentFrame;
    private int frameSize;
    private int rollSize;
    private int extraHits;
    public BowlingGame(int frameSize, int rollSize) {
        this.frameSize = frameSize;
        this.currentFrame = 0;
        this.frames = new ArrayList<>();
        this.initFrames(rollSize);
    }
    public int getScore() {
        calcauteFrameScores();
        int result = 0;
        for (Integer score : frameScores) {
            result += score;
        }
        return result;
    }

    public String getRecord() {
        calcauteFrameScores();
        String result = "";
        for (int i = 0; i < frameScores.size(); i++) {
            if (i == 0) {
                result += frameScores.get(i);
            } else {
                result += "|" + frameScores.get(i);
            }
        }
        return result;
    }

    public void roll(int hit) {
        if (frameSize == currentFrame + 1 && frames.get(currentFrame).getScore() == 10) {
            extraHits = hit;
        }
        if (frames.get(currentFrame).isEnd()) {
            currentFrame++;
        }
        if (!isEnd()) {
            frames.get(currentFrame).roll(hit);
        }
    }
    private void initFrames(int rollSize) {
        for (int i = 0; i < frameSize; i++) {
            this.frames.add(new Frame(rollSize));
        }
    }

    public boolean isEnd() {
        if (currentFrame >= frameSize) {
            return true;
        }
        if ((currentFrame == frameSize - 1) && this.frames.get(currentFrame).isEnd() && (!(this.frames.get(currentFrame - 1).getScore() == 10))) {
            return true;
        }
        return false;
    }

    private void calcauteFrameScores() {
        frameScores = new ArrayList<>();
        if (currentFrame == frameSize) {
            currentFrame--;
        }
        for (int i = 0; i <= currentFrame; i++) {
            int frameScore = frames.get(i).getScore();
            if (frameScore == 10) {
                if (i < currentFrame && currentFrame < frameSize) {
                    // 获取下一格的第一次得分
                    frameScore += this.frames.get(i + 1).getScoreByRollTime(0);
                }
                if (i == currentFrame && i == frameSize - 1) {
                    frameScore += extraHits;
                }
            }
            frameScores.add(frameScore);
        }
    }
}
