package ge.tbc.testautomation.data;

public final class Constants {

    // dynamic_controls page (CommandsTest)
    public static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public static final String DYNAMIC_CONTROLS_HEADING = "Dynamic Controls";
    public static final String DYNAMIC_CONTROLS_DESCRIPTION =
            "This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously.";

    // drag_and_drop page (WebElementTest)
    public static final String DRAG_AND_DROP_URL = "http://the-internet.herokuapp.com/drag_and_drop";
    public static final String DRAGGABLE_ATTRIBUTE = "draggable";
    public static final String DRAGGABLE_EXPECTED_VALUE = "true";
    public static final String HREF_ATTRIBUTE = "href";
    public static final String ELEMENTAL_SELENIUM_LINK_TEXT = "Elemental Selenium";
    public static final String ELEMENTAL_SELENIUM_HREF = "http://elementalselenium.com/";

    // ultimateqa.com/automation page (NavigationTest)
    public static final String ULTIMATEQA_AUTOMATION_URL = "https://ultimateqa.com/automation";
    public static final String ULTIMATEQA_CONSULTING_URL = "https://ultimateqa.com/consulting/";
    public static final String SERVICES_LINK_TEXT = "Services";

    private Constants() {
        // utility class - no instances
    }
}