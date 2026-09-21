package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SeleniumHomePage {

    public static final Target SEARCH_BUTTON =
            Target.the("botón de búsqueda")
                    .locatedBy("#docsearch-1 button.DocSearch-Button");

    public static final Target SEARCH_BOX =
            Target.the("campo de búsqueda")
                    .locatedBy("#docsearch-input");

    public static final Target FIRST_RESULT =
            Target.the("primer resultado de búsqueda")
                    .locatedBy("#docsearch-hits0-item-0 a");

    public static final Target DOCUMENTATION =
            Target.the("enlace Documentation")
                    .locatedBy("//a[contains(@class,'nav-link') and normalize-space()='Documentation']");
}