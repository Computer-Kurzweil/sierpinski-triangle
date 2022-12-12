package org.woehlke.computer.kurzweil.sierpinskitriangle;

import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.sierpinskitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinskitriangle.tabs.sierpinskitriangle.SimulatedEvolutionTab;

/**
 * Class with main Method for Starting the Desktop Application.
 *
 * @see SimulatedEvolutionTab
 *
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/sierpinskitriangle/
 * @author Thomas Woehlke
 */
@Log4j2
public class SimulatedEvolutionApplication {

    private SimulatedEvolutionApplication(String configFileName, String jarFilePath) {
        ComputerKurzweilProperties properties = ComputerKurzweilProperties.propertiesFactory(configFileName, jarFilePath);
        SimulatedEvolutionTab simulatedEvolutionTab = new SimulatedEvolutionTab(properties);
    }

    /**
     * Starting the Desktop Application
     * @param args CLI Parameter
     */
    public static void main(String[] args) {
        String configFileName = "application.yml";
        String jarFilePath = "target/sierpinskitriangle.jar";
        SimulatedEvolutionApplication application = new SimulatedEvolutionApplication(configFileName,jarFilePath);
    }
}
