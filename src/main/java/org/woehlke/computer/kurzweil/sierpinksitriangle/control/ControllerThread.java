package org.woehlke.computer.kurzweil.sierpinksitriangle.control;

import org.woehlke.computer.kurzweil.sierpinksitriangle.model.SierpinksiTriangleModel;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see SierpinksiTriangleFrame
 * @see SierpinksiTriangleModel
 *
 * @see Thread
 * @see Runnable
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 *
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class ControllerThread extends Thread implements Runnable {

    private volatile SierpinksiTriangleModel model;
    private volatile SierpinksiTriangleFrame view;

    private final int threadSleepTtime;
    private final int maxIterations;
    private volatile Boolean goOn;

    public ControllerThread(SierpinksiTriangleFrame view) {
        this.view = view;
        this.model = this.view.getModel();
        goOn = Boolean.TRUE;
        this.threadSleepTtime = this.view.getConfig().getKochsnowflake().getControl().getThreadSleepTime();
        this.maxIterations = this.view.getConfig().getKochsnowflake().getControl().getMaxIterations();
        //this.maxIterations = 2;
    }

    public void run() {
        int i = 0;
        while (goOn() &&  i < this.maxIterations) {
            i++;
            if(this.model.step()){
                view.getCanvas().repaint();
                view.repaint();
            }
            try {
                sleep( this.threadSleepTtime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean goOn() {
        return goOn;
    }

    public synchronized void exit() {
        goOn = Boolean.FALSE;
    }

}
