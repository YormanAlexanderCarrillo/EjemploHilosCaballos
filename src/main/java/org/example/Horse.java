package org.example;

import javax.swing.*;

public class Horse implements Runnable {
    JProgressBar pBarAux;
    private boolean status = false;

    public Horse(JProgressBar pBarAux) {
        this.pBarAux = pBarAux;
    }

    @Override
    public void run() {
        pBarAux.setMinimum(0);
        pBarAux.setMaximum(100);
        while (pBarAux.getValue() < 100 && status == true) {
            int value = (int) ((Math.random() * 15) + 1);
            int sum = value + pBarAux.getValue();
            pBarAux.setValue(sum);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("-------------------------------");
        }
    }

    public void begin() {
        status = true;
        pBarAux.setValue(0);
    }

    public void stop(){
        status = false;
    }


}
