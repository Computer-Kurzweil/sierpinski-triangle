package org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.koch.LinkedListNode;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

import java.io.Serializable;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see SierpinksiTriangleFrame
 * @see LatticeDimension
 *
 * @see LinkedListNode
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 */
@Log4j2
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LatticeDimension implements Serializable {

    static final long serialVersionUID = 242L;

    /**
     * Horizontal X-Coordinate. Also used as Width;
     */
    private int width;

    /**
     * Vertical Y-Coordinate. Also used as Height;
     */
    private int height;

    public void absoluteValue() {
        width *= Integer.signum(width);
        height *= Integer.signum(height);
    }

    public void plus(LatticeDimension p) {
        this.width += p.getWidth();
        this.height += p.getHeight();
        absoluteValue();
    }

    public LatticeDimension copy() {
        return new LatticeDimension(
            this.getWidth(),
            this.getHeight()
        );
    }

    public LatticePoint toLatticePoint() {
        return new LatticePoint(
            this.getWidth(),
            this.getHeight()
        );
    }

    public static LatticeDimension of(LatticePoint p) {
        return new LatticeDimension(p.getX(), p.getY());
    }

    public static LatticeDimension of(LatticeDimension p) {
        return LatticeDimension.of(p.toLatticePoint());
    }

    public static LatticeDimension of(int width, int height) {
        return new LatticeDimension(width, height);
    }
}
