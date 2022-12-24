package org.woehlke.computer.kurzweil.sierpinksitriangle.model.sierpinksi;

import lombok.*;
import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see SierpinksiTriangleFrame
 *
 * @see LatticePoint
 * @see LatticeDimension
 * @see Triagle
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 */
@Getter
@Setter
@ToString
public class TriagleContainer implements Serializable {

    static final long serialVersionUID = 242L;

    private final SierpinksiTriangleFrame tab;

    private final LatticeDimension worldDimensions;

    private List<Triagle> triagles;

    public TriagleContainer(SierpinksiTriangleFrame tab, LatticeDimension worldDimensions) {
        this.tab = tab;
        this.worldDimensions = worldDimensions;
        this.triagles = new ArrayList<>();
    }

    public void start(){
        int padding = 30;
        int paddingX = (this.worldDimensions.getWidth()-this.worldDimensions.getHeight())/2;
        int x1 = paddingX + padding;
        int x2 = paddingX + this.worldDimensions.getHeight()/2;
        int x3 = paddingX + this.worldDimensions.getHeight() - padding;
        int myHeight = this.worldDimensions.getHeight() - (2*padding);
        int y1 = padding + myHeight;
        int y2 = padding;
        int y3 = padding + myHeight;
        LatticePoint verticeLowerLeft  = new LatticePoint(x1,y1);
        LatticePoint verticeUpperCenter = new LatticePoint(x2,y2);
        LatticePoint verticeLowerRight = new LatticePoint(x3,y3);
        Triagle rootTriangle = new Triagle();
        rootTriangle.setVerticeLowerLeft(verticeLowerLeft);
        rootTriangle.setVerticeUpperCenter(verticeUpperCenter);
        rootTriangle.setVerticeLowerRight(verticeLowerRight);
        this.triagles.add(rootTriangle);
    }

    public void step(){
        List<Triagle> triaglesNextLevel = new ArrayList<>();
        for(Triagle srcTriagle:this.triagles) {
            Triagle verticeLeftTriagle = new Triagle();
            Triagle verticeUpperTriagle = new Triagle();
            Triagle verticeRightTriagle = new Triagle();

            LatticePoint lineLeftCenter =
                srcTriagle.getVerticeLowerLeft()
                    .delta(srcTriagle.getVerticeUpperCenter())
                    .scalarMultiplied(0.5)
                    .add(srcTriagle.getVerticeLowerLeft());
            LatticePoint lineRightCenter =
                srcTriagle.getVerticeUpperCenter()
                    .delta(srcTriagle.getVerticeLowerRight())
                    .scalarMultiplied(0.5)
                    .add(srcTriagle.getVerticeUpperCenter());
            LatticePoint lineBaseCenter =
                srcTriagle.getVerticeLowerRight()
                    .delta(srcTriagle.getVerticeLowerLeft())
                    .scalarMultiplied(0.5)
                    .add(srcTriagle.getVerticeLowerRight());

            verticeLeftTriagle.setVerticeLowerLeft(srcTriagle.getVerticeLowerLeft());
            verticeLeftTriagle.setVerticeUpperCenter(lineLeftCenter);
            verticeLeftTriagle.setVerticeLowerRight(lineBaseCenter);

            verticeUpperTriagle.setVerticeLowerLeft(lineLeftCenter);
            verticeUpperTriagle.setVerticeUpperCenter(srcTriagle.getVerticeUpperCenter());
            verticeUpperTriagle.setVerticeLowerRight(lineRightCenter);

            verticeRightTriagle.setVerticeLowerLeft(lineBaseCenter);
            verticeRightTriagle.setVerticeUpperCenter(lineRightCenter);
            verticeRightTriagle.setVerticeLowerRight(srcTriagle.getVerticeLowerRight());

            triaglesNextLevel.add(verticeLeftTriagle);
            triaglesNextLevel.add(verticeUpperTriagle);
            triaglesNextLevel.add(verticeRightTriagle);
        }
        this.triagles = triaglesNextLevel;
    }
}
