package org.woehlke.computer.kurzweil.sierpinksitriangle.view.canvas;

import org.woehlke.computer.kurzweil.sierpinksitriangle.model.SierpinksiTriangleModel;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.sierpinksi.Triagle;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.List;


/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see SierpinksiTriangleModel
 * @see Dimension
 *
 * @see JComponent
 * @see Graphics
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 *
 * Date: 05.02.2006
 * Time: 00:51:51
 */
public class SierpinksiTriangleCanvas extends JComponent {

    @Serial
    private final static long serialVersionUID = 242L;

    private volatile SierpinksiTriangleModel model;
    private volatile Dimension preferredSize;

    public SierpinksiTriangleCanvas(SierpinksiTriangleFrame tab) {
        this.model = tab.getModel();
        int width = this.model.getWorldDimensions().getWidth();
        int height = this.model.getWorldDimensions().getHeight();
        this.preferredSize = new Dimension(width, height);
        Rectangle bounds = new Rectangle(0,0,width,height);
        this.setBounds(bounds);
        this.setSize(this.preferredSize);
        this.setPreferredSize(preferredSize);
    }

    public void paint(Graphics g) {
        this.setSize(this.preferredSize);
        this.setPreferredSize(preferredSize);
        super.paintComponent(g);
        super.setBackground(Color.DARK_GRAY);
        int paddingX = (this.model.getWorldDimensions().getWidth()-this.model.getWorldDimensions().getHeight())/2;
        g.setColor(Color.DARK_GRAY);
        g.fillRect(
            0,0,
            this.model.getWorldDimensions().getWidth(),
            this.model.getWorldDimensions().getHeight()
        );
        g.setColor(Color.BLACK);
        g.fillRect(
            paddingX,0,
            this.model.getWorldDimensions().getHeight(),
            this.model.getWorldDimensions().getHeight()
        );
        g.setColor(Color.RED);
        List<Triagle> triagles = model.getTriagleContainer().getTriagles();
        int i=0;
        for(Triagle triagle:triagles) {
            i++;
            if(i%2==0){
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.GREEN);
            }
            //left
            g.drawLine(
                triagle.getVerticeLeft().getX(),
                triagle.getVerticeLeft().getY(),
                triagle.getVerticeUpper().getX(),
                triagle.getVerticeUpper().getX()
            );
            //right
            g.drawLine(
                triagle.getVerticeUpper().getX(),
                triagle.getVerticeUpper().getX(),
                triagle.getVerticeRight().getX(),
                triagle.getVerticeRight().getY()
            );
            //baseline
            g.drawLine(
                triagle.getVerticeRight().getX(),
                triagle.getVerticeRight().getY(),
                triagle.getVerticeLeft().getX(),
                triagle.getVerticeLeft().getY()
            );
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

}
