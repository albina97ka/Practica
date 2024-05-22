package com.example.practica;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node) {
        this.tt = new TranslateTransition(Duration.millis(100.0), node);
        this.tt.setFromX(0.0);
        this.tt.setByX(10.0);
        this.tt.setCycleCount(3);
        this.tt.setAutoReverse(true);
    }

    public void playAnim() {
        this.tt.playFromStart();
    }
}

