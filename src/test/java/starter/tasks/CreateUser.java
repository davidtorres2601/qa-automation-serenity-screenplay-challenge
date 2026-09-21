package starter.tasks;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class CreateUser implements Task {

    private final String name;
    private final String job;

    EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public static Task withData(String name, String job) {
        return new CreateUser(name, job);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String apiKey = EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty("reqres.apiKey");

        actor.attemptsTo(
                Post.to("/users")
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