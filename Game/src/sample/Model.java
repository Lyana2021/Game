package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class Model {
    int res1;
    int p1;
    int p2;
    int sum;
    int del;
    int[] rand;


    public void iniz() {

        Random r = new Random();
        p1 = r.nextInt(16);

        Random r2 = new Random();
        p2 = r2.nextInt(16);

        Random r3 = new Random();

        sum = p1 + p2;

        del = p1 - p2;

        rand = new int[]{sum, del};
        res1 = r3.nextInt(rand.length);


    }

}
