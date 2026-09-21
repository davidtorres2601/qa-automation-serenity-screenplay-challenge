package starter.tasks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ListUsers implements Task {

    EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    @Override
    public <T extends Actor> void performAs(T actor) {

        String apiKey = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("reqres.apiKey");

        actor.attemptsTo(
                Get.resource("/users")
                        .with(request -> request
                                .queryParam("page", 2)
                                .header("x-api-key", apiKey)
                        )
        );
    }

    public static Task fromReqRes() {
        return new ListUsers();
    }
}