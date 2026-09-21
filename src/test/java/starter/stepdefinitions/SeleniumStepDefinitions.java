package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import net.serenitybdd.screenplay.targets.Target;
import starter.navigation.NavigateTo;
import starter.tasks.NavigateToDocumentation;
import starter.tasks.SearchFor;
import starter.tasks.SelectFirstResult;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class SeleniumStepDefinitions {

    @Given("{actor} abre la pagina de Selenium")
    public void abreLaPaginaDeSelenium(Actor actor) {
        actor.wasAbleTo(
                NavigateTo.theSeleniumHomePage()
        );
    }

    @Then("{actor} debe visualizar el titulo {string}")
    public void debeVisualizarElTitulo(Actor actor, String titulo) {

        actor.should(
                seeThat(
                        TheWebPage.title(),
                        containsStringIgnoringCase(titulo)
                )
        );
    }

    @When("{actor} navega a Documentation")
    public void navegaADocumentation(Actor actor) {
        actor.attemptsTo(
                NavigateToDocumentation.navigate()
        );
    }

    @When("{actor} busca {string}")
    public void busca(Actor actor, String texto) {
        actor.attemptsTo(
                SearchFor.term(texto)
        );
    }
    @When("{actor} selecciona el primer resultado")
    public void seleccionaElPrimerResultado(Actor actor) {

        actor.attemptsTo(
                SelectFirstResult.click()
        );
    }

}