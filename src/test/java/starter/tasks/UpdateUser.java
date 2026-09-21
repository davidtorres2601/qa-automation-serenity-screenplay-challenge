package starter.tasks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class UpdateUser implements Task {

    private final String name;
    private final String job;

    EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    public UpdateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static Task withData(String name, String job) {
        return new UpdateUser(name, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String apiKey = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("reqres.apiKey");

        actor.attemptsTo(
                Put.to("/users/2")
                        .with(request -> request
                                .header("x-api-key", apiKey)
                                .contentType("application/json")
                                .body("""
                                        {
                                            "name": "%s",
                                            "job": "%s"
                                        }
                                        """.formatted(name, job))
                        )
        );
    }
}