package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.SeleniumHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateToDocumentation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(
                        SeleniumHomePage.DOCUMENTATION,
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(SeleniumHomePage.DOCUMENTATION)
        );
    }

    public static NavigateToDocumentation navigate() {
        return instrumented(NavigateToDocumentation.class);
    }
}