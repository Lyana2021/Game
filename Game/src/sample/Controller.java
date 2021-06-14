package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.String.valueOf;

public class Controller {
   public Label op1;
   public Label op2;
   public Label res;
   public Label schet;
public Label ball;
public Label dv;
    public Label vr;
  int counter=0;
int res1;
int p1;
int p2;
int sum;
int del;

    int[] rand;
   public void initialize() {




       Random r = new Random();
       p1 = r.nextInt(16);

       Random r2 = new Random();
       p2 = r2.nextInt(16);

       Random r3 = new Random();

       sum = p1 + p2;

       del = p1 - p2;

       rand = new int[]{sum, del};
       res1 = r3.nextInt(rand.length);

//toHexString-16чные числа
       //toBinaryString-2чные числа

       op1.setText(Integer.toBinaryString(p1));
       op2.setText(Integer.toBinaryString(p2));
       res.setText(Integer.toBinaryString(rand[res1]));



   }

   public void rewrite()
   {
       op1.setText(null);
       op2.setText(null);
       res.setText(null);

       Random r4=new Random();
       p1=r4.nextInt(16);
       Random r5=new Random();
       p2=r5.nextInt(16);
       Random r6=new Random();

       sum=p1+p2;

       del=p1-p2;
       rand= new int[]{sum, del};
       res1=r6.nextInt(rand.length);


       op1.setText(Integer.toBinaryString(p1));
       op2.setText(Integer.toBinaryString(p2));
       res.setText(Integer.toBinaryString(rand[res1]));



   }
    public void act1(ActionEvent actionEvent) {
if (p1 + p2 == rand[res1]){

   // schet.setText("правильно");

    counter++;


   } else {
   // schet.setText("неправильно");
    counter--;

}
        ball.setText(valueOf(counter));
rewrite();

    }

    public void act2(ActionEvent actionEvent) {
    if (rand[res1] == p1 - p2) {
           // schet.setText("правильно");
            counter++;
        } else {
           // schet.setText(String.valueOf("неправильно"));
            counter--;


        }
    ball.setText(String.valueOf(counter));
        rewrite();
    }

    public void act3(ActionEvent actionEvent) {
        ball.setText(String.valueOf(counter=0));
        final Timer t1=new Timer();
        TimerTask t2=new TimerTask() {
            int i=6000;
            public void run(){
                if(i==0){

                    t1.cancel();
                    return;
                }


                i--;
                int m,s;
                m=i/6000%6000;
                s=i%6000;
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        vr.setText("Времени осталось"+m+":"+s/100);


                    }


                });
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(i==0){
                            Label secondLabel = new Label("Время окончено. Ваш счет"+" : "+counter);

                            StackPane secondaryLayout = new StackPane();
                            secondaryLayout.getChildren().add(secondLabel);

                            Scene secondScene = new Scene(secondaryLayout, 250, 100);

                            Stage newWindow = new Stage();
                            newWindow.setTitle("Конец игры");

                            newWindow.setScene(secondScene);
                            newWindow.show();

                        }}
                });
            }

        };
        t1.schedule(t2,10,10);










    }


        }


