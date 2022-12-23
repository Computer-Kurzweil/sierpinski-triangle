package org.woehlke.computer.kurzweil.sierpinksitriangle.model;

import lombok.Getter;
import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.koch.LinkedListNodeContainer;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.KochSnowflakeFrame;

import java.io.Serializable;

/**
 * Koch Snowflake. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see KochSnowflakeFrame
 * @see LinkedListNodeContainer
 *
 * @see <a href="https://github.com/Computer-Kurzweil/kochsnowflake">Github Repository</a>
 * @see <a href="https://java.woehlke.org/kochsnowflake/">Maven Project Reports</a>
 *
 * Created by tw on 16.12.2019.
 */
@Getter
public class KochSnowflakeModel implements Serializable {

    static final long serialVersionUID = 242L;

    private volatile KochSnowflakeFrame tab;
    private volatile LinkedListNodeContainer linkedListNodeContainer;

    private final LatticeDimension worldDimensions;

    public KochSnowflakeModel(KochSnowflakeFrame tab) {
        this.tab = tab;
        ComputerKurzweilProperties config = tab.getConfig();
        int scale = config.getKochsnowflake().getView().getScale();
        int width = scale * config.getKochsnowflake().getView().getWidth();
        int height = scale * config.getKochsnowflake().getView().getHeight();
        this.worldDimensions = LatticeDimension.of(width,height);
        this.linkedListNodeContainer = new LinkedListNodeContainer(tab, this.worldDimensions);
    }

    public synchronized boolean step() {
        return this.linkedListNodeContainer.step();
    }

    public void click(LatticePoint c) {

    }

    public void start(){
        this.linkedListNodeContainer.start();
    }
}
