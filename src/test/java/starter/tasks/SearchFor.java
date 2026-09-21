package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.SeleniumHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchFor implements Task {

    private final String text;

    public SearchFor(String text) {
        this.text = text;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(
                        SeleniumHomePage.SEARCH_BUTTON,
                        isClickable()
                ).forNoMoreThan(10).seconds(),

                Click.on(SeleniumHomePage.SEARCH_BUTTON),

                WaitUntil.the(
                        SeleniumHomePage.SEARCH_BOX,
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Enter.theValue(text)
                        .into(SeleniumHomePage.SEARCH_BOX)
        );
    }

    public static SearchFor term(String text) {
        return instrumented(SearchFor.class, text);
    }
}