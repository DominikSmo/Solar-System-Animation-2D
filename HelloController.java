package com.example.solar;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.text.DateFormat;
import java.util.*;

public class HelloController implements Initializable {

    @FXML
    private Button start, pause;
    @FXML
    private Label clock;
    AnimationTimer timer;
    @FXML
    private ImageView sun, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune, pluto;
    @FXML
    private PerspectiveCamera camera;

    RotateTransition rotateTransition;
    RotateTransition rotateTransition1;
    RotateTransition rotateTransition2;
    RotateTransition rotateTransition3;
    RotateTransition rotateTransition4;
    RotateTransition rotateTransition5;
    RotateTransition rotateTransition6;
    RotateTransition rotateTransition7;
    RotateTransition rotateTransition8;
    RotateTransition rotateTransition9;

    PathTransition transitionMercury;
    PathTransition transitionVenus;
    PathTransition transitionEarth;
    PathTransition transitionMars;
    PathTransition transitionJupiter;
    PathTransition transitionSaturn;
    PathTransition transitionUranus;
    PathTransition transitionNeptune;
    PathTransition transitionPluto;

    Scene scene;
    HelloController helloController;
    Stage stage;



    boolean isAnimation;


    @Override
    public void initialize(URL url, ResourceBundle rb) {


        rotateTransition = new RotateTransition(Duration.seconds(10), sun); // Here we set the sun
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setAutoReverse(false);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);




        rotateTransition.play();
        isAnimation = true;
        setTimer(true);
        kinematicsOfMercury();
        kinematicsOfVenus();
        kinematicsOfEarth();
        kinematicsOfMars();
        kinematicsOfJupiter();
        kinematicsOfSaturn();
        kinematicsOfUranus();
        kinematicsOfNeptune();
        kinematicsOfPluto();

    }

    // The methods below are responsible for starting or pausing an animation
    public void play() {

        rotateTransition.pause();
        rotateTransition1.pause();
        transitionMercury.pause();
        rotateTransition2.pause();
        transitionVenus.pause();
        rotateTransition3.pause();
        transitionEarth.pause();
        rotateTransition4.pause();
        transitionMars.pause();
        rotateTransition5.pause();
        transitionJupiter.pause();
        rotateTransition6.pause();
        transitionSaturn.pause();
        rotateTransition7.pause();
        transitionUranus.pause();
        rotateTransition8.pause();
        transitionNeptune.pause();
        rotateTransition9.pause();
        transitionPluto.pause();
        timer.stop();


        if (isAnimation) {


            rotateTransition.pause();
            rotateTransition1.pause();
            transitionMercury.pause();
            rotateTransition2.pause();
            transitionVenus.pause();
            rotateTransition3.pause();
            transitionEarth.pause();
            rotateTransition4.pause();
            transitionMars.pause();
            rotateTransition5.pause();
            transitionJupiter.pause();
            rotateTransition6.pause();
            transitionSaturn.pause();
            rotateTransition7.pause();
            transitionUranus.pause();
            rotateTransition8.pause();
            transitionNeptune.pause();
            rotateTransition9.pause();
            transitionPluto.pause();
            timer.stop();
            isAnimation = false;
        } else {



            rotateTransition.play();
            rotateTransition1.play();
            transitionMercury.play();
            rotateTransition2.play();
            transitionVenus.play();
            rotateTransition3.play();
            transitionEarth.play();
            rotateTransition4.play();
            transitionMars.play();
            rotateTransition5.play();
            transitionJupiter.play();
            rotateTransition6.play();
            transitionSaturn.play();
            rotateTransition7.play();
            transitionUranus.play();
            rotateTransition8.play();
            transitionNeptune.play();
            rotateTransition9.play();
            transitionPluto.play();
            timer.start();
            isAnimation = true;

        }
    }


    //Below I set a timer of an animation
    public void setTimer(boolean running) {
        long startTime = System.nanoTime();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (running) {
                    long elapsedTime = now - startTime;
                    long seconds = elapsedTime / 1_000_000_000;
                    long minutes = seconds / 60;
                    long hours = minutes / 60;

                    String timeText = String.format("%02d : %02d : %02d", hours, minutes % 60, seconds % 60);
                    clock.setText(timeText);

                }
            }
        };
        timer.start();
    }

    //The methods below set the planets of the Solar System
    public void kinematicsOfMercury () {

        rotateTransition1 = new RotateTransition(Duration.seconds(10), mercury);            // this method is responsible for setting up rotation of a planet around its axis
        rotateTransition1.setFromAngle(0);
        rotateTransition1.setToAngle(360);
        rotateTransition1.setAutoReverse(false);
        rotateTransition1.setCycleCount(Timeline.INDEFINITE);

        Ellipse ellipseMercury = new Ellipse();                                               // here I set an ellipse
        ellipseMercury.setCenterX(sun.getTranslateX());
        ellipseMercury.setCenterY(sun.getTranslateY());
        ellipseMercury.translateXProperty().bind(sun.translateXProperty());
        ellipseMercury.translateYProperty().bind(sun.translateYProperty());
        ellipseMercury.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 50);    // this code sets distance of a planet from the Sun
        ellipseMercury.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 50);




        transitionMercury = new PathTransition();                                                  // This method sets a planet in its orbit
        transitionMercury.setPath(ellipseMercury);
        transitionMercury.setNode(mercury);
        transitionMercury.setInterpolator(Interpolator.LINEAR);
        transitionMercury.setDuration(Duration.seconds(20.000017421));                         //Velocity with which a planet moves in its orbit around the Sun
        transitionMercury.setCycleCount(Timeline.INDEFINITE);

        rotateTransition1.play();
        transitionMercury.play();

    }

    public void kinematicsOfVenus() {

        rotateTransition2 = new RotateTransition(Duration.seconds(10), venus);
        rotateTransition2.setFromAngle(0);
        rotateTransition2.setToAngle(360);
        rotateTransition2.setAutoReverse(false);
        rotateTransition2.setCycleCount(Timeline.INDEFINITE);

        Ellipse ellipseVenus = new Ellipse();
        ellipseVenus.setCenterX(sun.getTranslateX());
        ellipseVenus.setCenterY(sun.getTranslateY());
        ellipseVenus.translateXProperty().bind(sun.translateXProperty());
        ellipseVenus.translateYProperty().bind(sun.translateYProperty());
        ellipseVenus.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 120);
        ellipseVenus.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 120);


        transitionVenus = new PathTransition();
        transitionVenus.setPath(ellipseVenus);
        transitionVenus.setNode(venus);
        transitionVenus.setInterpolator(Interpolator.LINEAR);
        transitionVenus.setDuration(Duration.seconds(12.000017421));
        transitionVenus.setCycleCount(Timeline.INDEFINITE);

        rotateTransition2.play();
        transitionVenus.play();

    }

    public void kinematicsOfEarth() {

        rotateTransition3 = new RotateTransition(Duration.seconds(10), earth);
        rotateTransition3.setFromAngle(0);
        rotateTransition3.setToAngle(360);
        rotateTransition3.setAutoReverse(false);
        rotateTransition3.setCycleCount(Timeline.INDEFINITE);

        Ellipse ellipseEarth = new Ellipse();
        ellipseEarth.setCenterX(sun.getTranslateX());
        ellipseEarth.setCenterY(sun.getTranslateY());
        ellipseEarth.translateXProperty().bind(sun.translateXProperty());
        ellipseEarth.translateYProperty().bind(sun.translateYProperty());
        ellipseEarth.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 180);
        ellipseEarth.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 180);


        transitionEarth = new PathTransition();
        transitionEarth.setPath(ellipseEarth);
        transitionEarth.setNode(earth);
        transitionEarth.setInterpolator(Interpolator.LINEAR);
        transitionEarth.setDuration(Duration.seconds(10.000017421));
        transitionEarth.setCycleCount(Timeline.INDEFINITE);

        rotateTransition3.play();
        transitionEarth.play();


    }

    public void kinematicsOfMars() {

        rotateTransition4 = new RotateTransition(Duration.seconds(10), mars);
        rotateTransition4.setFromAngle(0);
        rotateTransition4.setToAngle(360);
        rotateTransition4.setAutoReverse(false);
        rotateTransition4.setCycleCount(Timeline.INDEFINITE);

        Ellipse ellipseMars = new Ellipse();
        ellipseMars.setCenterX(sun.getTranslateX());
        ellipseMars.setCenterY(sun.getTranslateY());
        ellipseMars.translateXProperty().bind(sun.translateXProperty());
        ellipseMars.translateYProperty().bind(sun.translateYProperty());
        ellipseMars.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 260);
        ellipseMars.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 260);


        transitionMars = new PathTransition();
        transitionMars.setPath(ellipseMars);
        transitionMars.setNode(mars);
        transitionMars.setInterpolator(Interpolator.LINEAR);
        transitionMars.setDuration(Duration.seconds(15.000017421));
        transitionMars.setCycleCount(Timeline.INDEFINITE);

        rotateTransition4.play();
        transitionMars.play();

    }

    public void kinematicsOfJupiter() {

        rotateTransition5 = new RotateTransition(Duration.seconds(10), jupiter);
        rotateTransition5.setFromAngle(0);
        rotateTransition5.setToAngle(360);
        rotateTransition5.setAutoReverse(false);
        rotateTransition5.setCycleCount(Timeline.INDEFINITE);

        Ellipse ellipseJupiter = new Ellipse();
        ellipseJupiter.setCenterX(sun.getTranslateX());
        ellipseJupiter.setCenterY(sun.getTranslateY());
        ellipseJupiter.translateXProperty().bind(sun.translateXProperty());
        ellipseJupiter.translateYProperty().bind(sun.translateYProperty());
        ellipseJupiter.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 330);
        ellipseJupiter.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 330);


        transitionJupiter = new PathTransition();
        transitionJupiter.setPath(ellipseJupiter);
        transitionJupiter.setNode(jupiter);
        transitionJupiter.setInterpolator(Interpolator.LINEAR);
        transitionJupiter.setDuration(Duration.seconds(11.000017421));
        transitionJupiter.setCycleCount(Timeline.INDEFINITE);

        rotateTransition5.play();
        transitionJupiter.play();
    }

    public void kinematicsOfSaturn() {

        rotateTransition6 = new RotateTransition(Duration.seconds(10), saturn);
        rotateTransition6.setFromAngle(0);
        rotateTransition6.setToAngle(360);
        rotateTransition6.setAutoReverse(false);
        rotateTransition6.setCycleCount(Timeline.INDEFINITE);

        Ellipse ellipseSaturn = new Ellipse();
        ellipseSaturn.setCenterX(sun.getTranslateX());
        ellipseSaturn.setCenterY(sun.getTranslateY());
        ellipseSaturn.translateXProperty().bind(sun.translateXProperty());
        ellipseSaturn.translateYProperty().bind(sun.translateYProperty());
        ellipseSaturn.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 410);
        ellipseSaturn.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 410);


        transitionSaturn = new PathTransition();
        transitionSaturn.setPath(ellipseSaturn);
        transitionSaturn.setNode(saturn);
        transitionSaturn.setInterpolator(Interpolator.LINEAR);
        transitionSaturn.setDuration(Duration.seconds(14.000017421));
        transitionSaturn.setCycleCount(Timeline.INDEFINITE);

        rotateTransition6.play();
        transitionSaturn.play();

    }

    public void kinematicsOfUranus() {

        rotateTransition7 = new RotateTransition(Duration.seconds(10), uranus);
        rotateTransition7.setFromAngle(0);
        rotateTransition7.setToAngle(360);
        rotateTransition7.setAutoReverse(false);
        rotateTransition7.setCycleCount(Timeline.INDEFINITE);


        Ellipse ellipseUranus = new Ellipse();
        ellipseUranus.setCenterX(sun.getTranslateX());
        ellipseUranus.setCenterY(sun.getTranslateY());
        ellipseUranus.translateXProperty().bind(sun.translateXProperty());
        ellipseUranus.translateYProperty().bind(sun.translateYProperty());
        ellipseUranus.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 490);
        ellipseUranus.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 490);


        transitionUranus = new PathTransition();
        transitionUranus.setPath(ellipseUranus);
        transitionUranus.setNode(uranus);
        transitionUranus.setInterpolator(Interpolator.LINEAR);
        transitionUranus.setDuration(Duration.seconds(18.000017421));
        transitionUranus.setCycleCount(Timeline.INDEFINITE);

        rotateTransition7.play();
        transitionUranus.play();
    }
    public void kinematicsOfNeptune() {

        rotateTransition8 = new RotateTransition(Duration.seconds(10), neptune);
        rotateTransition8.setFromAngle(0);
        rotateTransition8.setToAngle(360);
        rotateTransition8.setAutoReverse(false);
        rotateTransition8.setCycleCount(Timeline.INDEFINITE);


        Ellipse ellipseNeptune = new Ellipse();
        ellipseNeptune.setCenterX(sun.getTranslateX());
        ellipseNeptune.setCenterY(sun.getTranslateY());
        ellipseNeptune.translateXProperty().bind(sun.translateXProperty());
        ellipseNeptune.translateYProperty().bind(sun.translateYProperty());
        ellipseNeptune.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 560);
        ellipseNeptune.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 560);


        transitionNeptune = new PathTransition();
        transitionNeptune.setPath(ellipseNeptune);
        transitionNeptune.setNode(neptune);
        transitionNeptune.setInterpolator(Interpolator.LINEAR);
        transitionNeptune.setDuration(Duration.seconds(13.000017421));
        transitionNeptune.setCycleCount(Timeline.INDEFINITE);

        rotateTransition8.play();
        transitionNeptune.play();
    }

    public void kinematicsOfPluto() {

        rotateTransition9 = new RotateTransition(Duration.seconds(10), pluto);
        rotateTransition9.setFromAngle(0);
        rotateTransition9.setToAngle(360);
        rotateTransition9.setAutoReverse(false);
        rotateTransition9.setCycleCount(Timeline.INDEFINITE);


        Ellipse ellipsePluto = new Ellipse();
        ellipsePluto.setCenterX(sun.getTranslateX());
        ellipsePluto.setCenterY(sun.getTranslateY());
        ellipsePluto.translateXProperty().bind(sun.translateXProperty());
        ellipsePluto.translateYProperty().bind(sun.translateYProperty());
        ellipsePluto.setRadiusX(sun.getBoundsInLocal().getWidth() / 2.0 + 1.01671388 * 650);
        ellipsePluto.setRadiusY(sun.getBoundsInLocal().getHeight() / 2.0 + 0.98329134 * 650);


        transitionPluto = new PathTransition();
        transitionPluto.setPath(ellipsePluto);
        transitionPluto.setNode(pluto);
        transitionPluto.setInterpolator(Interpolator.LINEAR);
        transitionPluto.setDuration(Duration.seconds(9.000017421));
        transitionPluto.setCycleCount(Timeline.INDEFINITE);

        rotateTransition9.play();
        transitionPluto.play();


    }

    public void setScene(Scene scene, Stage stage) {
        this.scene = scene;
        this.stage = stage;

    }


//Method below allows to zoom in or zoom out a view of animation
    public void zoomButton() {

         scene.setCamera(camera);
         sun.translateXProperty().set(sun.getX());
         sun.translateYProperty().set(sun.getY());
         stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {

                    switch (event.getCode()) {

                        case W:                                      //When you press 'W' an animation is zoomed in
                            System.out.println(event.getCode());
                            zoomIn();

                            break;

                        case S:                                     // When you press 'S' an animation is zoomed out
                            zoomOut();

                    }
         });
    }

    public void zoomIn() {

        sun.translateZProperty().set(sun.getTranslateZ()-50);
        mercury.translateZProperty().set(mercury.getTranslateZ()-50);
        venus.translateZProperty().set(venus.getTranslateZ()-50);
        earth.translateZProperty().set(earth.getTranslateZ()-50);
        mars.translateZProperty().set(mars.getTranslateZ()-50);
        jupiter.translateZProperty().set(jupiter.getTranslateZ()-50);
        saturn.translateZProperty().set(saturn.getTranslateZ()-50);
        uranus.translateZProperty().set(uranus.getTranslateZ()-50);
        neptune.translateZProperty().set(neptune.getTranslateZ()-50);
        pluto.translateZProperty().set(pluto.getTranslateZ()-50);

    }

    public void zoomOut() {

        sun.translateZProperty().set(sun.getTranslateZ()+50);
        mercury.translateZProperty().set(mercury.getTranslateZ()+50);
        venus.translateZProperty().set(venus.getTranslateZ()+50);
        earth.translateZProperty().set(earth.getTranslateZ()+50);
        mars.translateZProperty().set(mars.getTranslateZ()+50);
        jupiter.translateZProperty().set(jupiter.getTranslateZ()+50);
        saturn.translateZProperty().set(saturn.getTranslateZ()+50);
        uranus.translateZProperty().set(uranus.getTranslateZ()+50);
        neptune.translateZProperty().set(neptune.getTranslateZ()+50);
        pluto.translateZProperty().set(pluto.getTranslateZ()+50);


    }

    public void setHelloController (HelloController helloController) {
            this.helloController = helloController;

    }

}














