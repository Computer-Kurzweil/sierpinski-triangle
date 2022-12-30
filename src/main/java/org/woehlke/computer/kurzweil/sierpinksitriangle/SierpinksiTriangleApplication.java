package org.woehlke.computer.kurzweil.sierpinksitriangle;

import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see SierpinksiTriangleFrame
 * @see ComputerKurzweilProperties
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 */
public class SierpinksiTriangleApplication {

    private final SierpinksiTriangleFrame frame;

    private SierpinksiTriangleApplication() {
        String conf = "application.yml";
        String jarPath = "target/sierpinski-triangle.jar";
        ComputerKurzweilProperties config = ComputerKurzweilProperties.propertiesFactory(conf,jarPath);
        frame = new SierpinksiTriangleFrame(config);
    }

    public void start(){
        this.frame.start();
    }

    /**
     * Starting the Application.
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        SierpinksiTriangleApplication application = new SierpinksiTriangleApplication();
        application.start();
    }
}
