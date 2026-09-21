package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable theSeleniumHomePage() {
        return Task.where(
                "{0} opens the Selenium home page",
                Open.url("https://www.selenium.dev/")
        );
    }
}