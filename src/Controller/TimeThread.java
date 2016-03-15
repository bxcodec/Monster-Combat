/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Timer;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author VeniNababan
 */
public class TimeThread extends Timer implements Runnable {

    private JLabel komponen;
    private boolean isDone = false;

    public TimeThread(boolean _isRun, long _second, JLabel komponent) {
        super(_isRun, _second);
        this.komponen = komponent;
    }

    public boolean isIsDone() {
        return isDone;
    }

    @Override
    public void run() {

        try {
            while (this.isIsRun()) {

                if (this.second > 0) {
                    this.decreement();
//                    System.out.println(this.second);
                    if (this.komponen == null) {
                        System.out.println("NULL");
                    } else {
                        this.komponen.setText(super.toString());
                    }
                } else {
                    this.komponen.setText("00 : 00");
                    isDone = true;
                    setIsRun(false);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {

            System.out.println(ie.getMessage());
        }

    }

}
