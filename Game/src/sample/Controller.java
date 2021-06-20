package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.String.valueOf;

public class Controller {
    public Pane pane;
   public Label op1;
   public Label op2;
   public Label res;
   public Button b1;
    public Button b2;
    public Button b3;
public Canvas can;
public Label ball;
public Circle krug;
public Label dv;
    public Label vr;
  int counter=0;

Model model;


   public void initialize() {
       model = new Model();
       model.iniz();
       pane.setStyle("-fx-background-color:rgba(112,9,215,0.99);");
       op1.setTextFill(Color.YELLOW);
       op2.setTextFill(Color.YELLOW);
       res.setTextFill(Color.YELLOW);
       vr.setTextFill(Color.YELLOW);
       dv.setTextFill(Color.YELLOW);
       ball.setTextFill(Color.YELLOW);
       b1.setStyle("-fx-background-color:rgba(250,217,90,0.99);");
       b2.setStyle("-fx-background-color:rgba(250,217,90,0.99);");
       b3.setStyle("-fx-background-color:rgba(250,217,90,0.99);");






//toHexString-16чные числа
       //toBinaryString-2чные числа


       op1.setText(Integer.toBinaryString(model.p1));
       op2.setText(Integer.toBinaryString(model.p2));
       res.setText(Integer.toBinaryString(model.rand[model.res1]));



   }

   public void rewrite()
   {
       op1.setText(null);
       op2.setText(null);
       res.setText(null);
       model.iniz();
       op1.setText(Integer.toBinaryString(model.p1));
       op2.setText(Integer.toBinaryString(model.p2));
       res.setText(Integer.toBinaryString(model.rand[model.res1]));



   }
    public void act1(ActionEvent actionEvent) {
if (model.p1 + model.p2 == model.rand[model.res1]){


    krug.setFill(Color.GREEN);
    counter++;


   } else {

    krug.setFill(Color.RED);
    counter--;

}
       ball.setText(valueOf(counter));
rewrite();

    }

    public void act2(ActionEvent actionEvent) {
    if (model.rand[model.res1] == model.p1 - model.p2) {

            krug.setFill(Color.GREEN);
            counter++;

        } else {

        krug.setFill(Color.RED);
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


