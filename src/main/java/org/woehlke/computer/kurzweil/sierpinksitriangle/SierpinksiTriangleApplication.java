package org.woehlke.computer.kurzweil.sierpinksitriangle;

import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.ApplicationFrame;

/**
 * Mandelbrot Set drawn by a Turing Machine.
 *
 * (C) 2006 - 2022 Thomas Woehlke.
 * @author Thomas Woehlke
 *
 * @see ApplicationFrame
 * @see ComputerKurzweilProperties
 *
 * @see <a href="https://github.com/Computer-Kurzweil/mandelbrot-julia">Github Repository</a>
 * @see <a href="https://java.woehlke.org/mandelbrot-julia/">Maven Project Repository</a>
 */
public class SierpinksiTriangleApplication {

    private SierpinksiTriangleApplication() {
        String conf = "application.yml";
        String jarPath = "target/sierpinskitriangle.jar";
        ComputerKurzweilProperties config = ComputerKurzweilProperties.propertiesFactory(conf,jarPath);
        ApplicationFrame frame = new ApplicationFrame(config);
        frame.start();
    }

    /**
     * Starting the Application.
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        SierpinksiTriangleApplication application = new SierpinksiTriangleApplication();
    }
}
