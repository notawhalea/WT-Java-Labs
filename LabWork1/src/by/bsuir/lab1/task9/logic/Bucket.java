package by.bsuir.lab1.task9.logic;

import java.awt.*;
import java.util.ArrayList;

public class Bucket {
    private int capacity;
    private int realWeight;
    private ArrayList<Ball> bucketArrayList = new ArrayList<Ball>(capacity);

    public Bucket(int capacity) {
        this.capacity = capacity;
    }

    public Bucket(ArrayList<Ball> bucketArrayList) {
        this.bucketArrayList = bucketArrayList;
    }

    public void addBall(Ball ball) {
        if (ball == null) {
            //exception
        }
        if (realWeight + ball.volume <= capacity) {
            bucketArrayList.add(ball);
            realWeight += ball.volume;
        } else {
            //exception
        }

    }

    public int countBlue() {
        int k = 0;

        for (Ball ball : bucketArrayList) {
            if (ball.color.equals(Color.BLUE)) {
                k++;
            }
        }

        return k;
    }

    public int countWeight() {
        return realWeight;
    }

}
