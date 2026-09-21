package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import starter.tasks.UpdateUser;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.at;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;

import starter.tasks.CreateUser;
import starter.tasks.ListUsers;

public class ApiStepDefinitions {

    @Given("{actor} consulta la API de usuarios")
    public void consultaLaApiDeUsuarios(Actor actor) {

        actor.can(
                at("https://reqres.in/api")
        );

        actor.attemptsTo(
                ListUsers.fromReqRes()
        );
    }

    @Then("{actor} debe recibir codigo {int}")
    public void laRespuestaDebeTenerCodigo(Actor actor, int codigo) {

        actor.should(
                seeThatResponse(
                        "El código de respuesta debe ser " + codigo,
                        response -> response.statusCode(codigo)
                )
        );
    }

    @Then("{actor} debe recibir usuarios")
    public void laRespuestaDebeContenerUsuarios(Actor actor) {

        actor.should(
                seeThatResponse(
                        "La respuesta debe contener usuarios",
                        response -> response.body("data", not(empty()))
                )
        );
    }

    @Given("{actor} crea un usuario con nombre {string} y trabajo {string}")
    public void creaUnUsuario(Actor actor, String nombre, String trabajo) {

        actor.can(
                at("https://reqres.in/api")
        );

        actor.attemptsTo(
                CreateUser.withData(nombre, trabajo)
        );
    }

    @Then("{actor} debe validar que el nombre sea {string}")
    public void validaNombre(Actor actor, String nombre) {

        actor.should(
                seeThatResponse(
                        "El nombre debe ser " + nombre,
                        response -> response.body("name", equalTo(nombre))
                )
        );
    }

    @Then("{actor} debe validar que el trabajo sea {string}")
    public void validaTrabajo(Actor actor, String trabajo) {

        actor.should(
                seeThatResponse(
                        "El trabajo debe ser " + trabajo,
                        response -> response.body("job", equalTo(trabajo))
                )
        );
    }
    @Given("{actor} actualiza el usuario con nombre {string} y trabajo {string}")
    public void actualizaUnUsuario(Actor actor, String nombre, String trabajo) {

        actor.can(
                at("https://reqres.in/api")
        );

        actor.attemptsTo(
                UpdateUser.withData(nombre, trabajo)
        );
    }
}