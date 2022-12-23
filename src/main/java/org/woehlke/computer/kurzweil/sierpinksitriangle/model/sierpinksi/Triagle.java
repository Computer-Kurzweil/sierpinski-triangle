package org.woehlke.computer.kurzweil.sierpinksitriangle.model.sierpinksi;

import lombok.*;
import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

import java.io.Serializable;

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
 * @see TriagleContainer
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Triagle implements Serializable {

    static final long serialVersionUID = 242L;

    private LatticePoint verticeLowerLeft;
    private LatticePoint verticeUpperCenter;
    private LatticePoint verticeLowerRight;
}
