package JiraElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ToolBar {
    public static SelenideElement ChooseTopMenuButton(String MenuButton) {
        return $x("//a[contains(text(),'" + MenuButton + "')]");
    }
}