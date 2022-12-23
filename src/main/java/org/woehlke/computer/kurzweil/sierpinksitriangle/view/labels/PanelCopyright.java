package org.woehlke.computer.kurzweil.sierpinksitriangle.view.labels;

import javax.swing.*;
import java.awt.*;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 *
 * Created by tw on 16.12.2019.
 */
public class PanelCopyright extends JPanel {

    private final static long serialVersionUID = 242L;

    public PanelCopyright(String subtitle) {
        int align = FlowLayout.CENTER;
        int hgap = 2;
        int vgap = 2;
        this.setLayout(new FlowLayout(align,hgap, vgap));
        this.add(new JLabel(subtitle));
    }

}
