package ge.tbc.testautomation.data;

public final class Constants {

    // dynamic_controls page (CommandsTest)
    public static final String DYNAMIC_CONTROLS_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public static final String DYNAMIC_CONTROLS_HEADING = "Dynamic Controls";
    public static final String DYNAMIC_CONTROLS_DESCRIPTION =
            "This example demonstrates when elements (e.g., checkbox, input field, etc.) are changed asynchronously.";
    public static final String ENABLE_BUTTON_TEXT = "Enable";
    public static final String DISABLE_BUTTON_TEXT = "Disable";
    public static final String LOADING_INDICATOR_ID = "loading";
    public static final String ACCESS_GRANTED_TEXT = "ACCESS GRANTED";

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

    // jqueryui.com/slider (LocatorsTest#unorderedListTest)
    public static final String JQUERY_UI_SLIDER_URL = "https://jqueryui.com/slider/";
    public static final String WIDGET_TITLE_CLASS = "widget-title";
    public static final String EFFECTS_TITLE_TEXT = "Effects";
    public static final String FILTER_LETTER = "o";
    public static final String ANIMATE_KEYWORD = "animate";

    // add_remove_elements page (LocatorsTest#buttonsTest)
    public static final String ADD_REMOVE_ELEMENTS_URL = "http://the-internet.herokuapp.com/add_remove_elements/";
    public static final String ADD_ELEMENT_BUTTON_TEXT = "Add Element";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String ADDED_MANUALLY_CLASS = "added-manually";
    public static final String ONCLICK_ATTRIBUTE = "onclick";
    public static final String DELETE_ELEMENT_ONCLICK_VALUE = "deleteElement()";
    public static final String DELETE_ONCLICK_PREFIX = "deleteElement";

    // challenging_dom page (LocatorsTest#challengingDomTest)
    public static final String CHALLENGING_DOM_URL = "http://the-internet.herokuapp.com/challenging_dom";
    public static final String TARGET_IPSUM_VALUE = "Apeirian9";

    // tympanus custom dropdown (FormsTest#customDropDownTest)
    public static final String CUSTOM_DROPDOWN_BASE_URL = "https://tympanus.net/Tutorials/CustomDropDownListStyling/";
    public static final String DEMO2_LINK_SELECTOR = "a[href$='index2.html']";
    public static final String CUSTOM_DROPDOWN_TOGGLE_SELECTOR = ".wrapper-dropdown-2";
    public static final String CUSTOM_DROPDOWN_MENU_SELECTOR = ".wrapper-dropdown-2 .dropdown";
    public static final String GITHUB_OPTION_TEXT = "Github";

    // techcanvass register form (FormsTest#nativeDropDownTest)
    public static final String REGISTER_PAGE_URL = "https://techcanvass.com/examples/register.html";
    public static final String MODEL_OPTION_TEXT = "Mega 123 Medium screen";
    public static final String DUMMY_TEXT_VALUE = "Test User";
    public static final String DUMMY_EMAIL_VALUE = "testuser@example.com";

    // demoqa progress bar (WaitsTest#waitForText)
    public static final String PROGRESS_BAR_URL = "https://demoqa.com/progress-bar";
    public static final String PROGRESS_BAR_BUTTON_ID = "startStopButton";
    public static final String PROGRESS_BAR_ID = "progressBar";
    public static final String PROGRESS_COMPLETE_TEXT = "100%";
    public static final String RESET_BUTTON_TEXT = "Reset";

    // techlistic web table article (bonus ScrollTest)
    public static final String TECHLISTIC_WEBTABLE_ARTICLE_URL =
            "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
    public static final String POPULAR_TUTORIALS_HEADING_TEXT = "Popular Tutorials";


    private Constants() {
        // utility class - no instances
    }
}