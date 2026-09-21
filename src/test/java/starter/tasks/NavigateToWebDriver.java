package starter.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToWebDriver {

    public static Task navigate() {
        return Task.where(
                "{0} navigates to WebDriver",
                Open.url("https://www.selenium.dev/documentation/webdriver/")
        );
    }
}