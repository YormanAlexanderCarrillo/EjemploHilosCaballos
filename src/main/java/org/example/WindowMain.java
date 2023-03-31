package org.example;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class WindowMain extends JFrame {
    private JLabel txt1;
    private JProgressBar pBar1;
    private JLabel txt2;
    private JProgressBar pBar2;
    private JLabel txt3;
    private JProgressBar pBar3;
    private JLabel txt4;
    private JProgressBar pBar4;

    private JLabel txt5;
    private JButton btn1;
    private boolean status;

    public WindowMain() {
        setSize(500, 200);
        setTitle("CABALLOS");
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        initComponents();
        addComponents();
    }


    private void initComponents() {
        txt1 = new JLabel("Caballo 1");
        pBar1 = new JProgressBar();
        txt2 = new JLabel("Caballo 2");
        pBar2 = new JProgressBar();
        txt3 = new JLabel("Caballo 3");
        pBar3 = new JProgressBar();
        txt4 = new JLabel("Caballo 4");
        pBar4 = new JProgressBar();
        txt5 = new JLabel();
        btn1 = new JButton("INICIAR");
    }

    private void addComponents() {
        add(txt1);
        add(pBar1);
        add(txt2);
        add(pBar2);
        add(txt3);
        add(pBar3);
        add(txt4);
        add(pBar4);
        add(txt5);
        add(btn1);

        new Thread(()->{
            while (true){
                LocalTime timeNow = LocalTime.now();
                String hourNow = timeNow.getHour() +":"+timeNow.getMinute()+":"+timeNow.getSecond();
                txt5.setText(hourNow);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        Horse horse1 = new Horse(pBar1);
        Horse horse2 = new Horse(pBar2);
        Horse horse3 = new Horse(pBar3);
        Horse horse4 = new Horse(pBar4);

        btn1.addActionListener((actionEvent ->{
            horse1.begin();
            horse2.begin();
            horse3.begin();
            horse4.begin();
            new Thread(horse1).start();
            new Thread(horse2).start();
            new Thread(horse3).start();
            new Thread(horse4).start();



        }));


        while (pBar1.getValue()<100 && pBar2.getValue()<100 && pBar3.getValue()<100 && pBar4.getValue()<100 ){
            System.out.println("win");
            if (pBar1.getValue() ==100){
                txt1.setText("Ganador: " + txt1.getText());
                horse1.stop();
                horse2.stop();
                horse3.stop();
                horse4.stop();
            } else if (pBar2.getValue() == 100) {
                txt1.setText("Ganador: " + txt2.getText());
                horse1.stop();
                horse2.stop();
                horse3.stop();
                horse4.stop();
            }else if (pBar3.getValue() == 100) {
                txt1.setText("Ganador: " + txt3.getText());
                horse1.stop();
                horse2.stop();
                horse3.stop();
                horse4.stop();
            }else if (pBar4.getValue() == 100) {
                txt1.setText("Ganador: " + txt4.getText());
                horse1.stop();
                horse2.stop();
                horse3.stop();
                horse4.stop();
            }
        }
    }




}
