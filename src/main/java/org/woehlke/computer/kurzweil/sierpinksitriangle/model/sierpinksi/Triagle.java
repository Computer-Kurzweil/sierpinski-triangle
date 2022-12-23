package org.woehlke.computer.kurzweil.sierpinksitriangle.model.sierpinksi;

import lombok.*;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticePoint;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Triagle implements Serializable {

    static final long serialVersionUID = 242L;

    private LatticePoint verticeLeft;
    private LatticePoint verticeRight;
    private LatticePoint verticeUpper;
}
