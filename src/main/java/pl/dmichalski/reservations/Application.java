package pl.dmichalski.reservations;

import javax.swing.SwingUtilities;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pl.dmichalski.reservations.business.ui.main_menu.controller.MainMenuController;
import pl.dmichalski.reservations.business.util.ui.LookAndFeelUtils;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        LookAndFeelUtils.setWindowsLookAndFeel();
        ConfigurableApplicationContext context = createApplicationContext(args);
        displayMainFrame(context);
    }

    private static ConfigurableApplicationContext createApplicationContext(String[] args) {
        return new SpringApplicationBuilder(Application.class)
                .headless(false)
                .run(args);
    }

    private static void displayMainFrame(ConfigurableApplicationContext context) {
        SwingUtilities.invokeLater(() -> {
            MainMenuController mainMenuController = context.getBean(MainMenuController.class);
            mainMenuController.prepareAndOpenFrame();
        });
    }

}
