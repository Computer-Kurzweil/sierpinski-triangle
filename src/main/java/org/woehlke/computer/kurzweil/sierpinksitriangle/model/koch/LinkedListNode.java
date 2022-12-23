package org.woehlke.computer.kurzweil.sierpinksitriangle.model.koch;

import lombok.*;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticePoint;

import java.io.Serializable;
import java.util.Objects;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see LatticePoint
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LinkedListNode implements Serializable {

    static final long serialVersionUID = 242L;

    private LatticePoint point;

    private LinkedListNode next;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListNode that)) return false;
        return getPoint().equals(that.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint());
    }
}