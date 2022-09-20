package by.bsuir.lab1.task9.logic;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball(1, Color.GREEN);
        Ball ball2 = new Ball(2, Color.BLUE);
        Ball ball3 = new Ball(3, Color.GREEN);
        Ball ball4 = new Ball(13, Color.GREEN);

        Bucket bucket = new Bucket(22);

        bucket.addBall(ball1);
        bucket.addBall(ball2);
        bucket.addBall(ball3);
        bucket.addBall(ball4);

        System.out.println(bucket.countBlue());
    }
}
