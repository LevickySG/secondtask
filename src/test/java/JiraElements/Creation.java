package JiraElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Creation {
    public static SelenideElement CreateButton = ToolBar.ChooseTopMenuButton("Создать");
    public static SelenideElement TaskThemeField = $x("//label[contains(text(),'Тема')]//following-sibling::input").as("поле ввода темы");
    public static SelenideElement Description = $(By.xpath("//div[@id='description-wiki-edit']//child::textarea"))
            .as("поле ввода описания");
    public static SelenideElement Environment = $(By.xpath("//div[@id='environment-wiki-edit']//child::textarea"))
            .as("поле ввода окружения");
    public static SelenideElement Versions (String TaskVer) {
        return $x("//select[@id='fixVersions']" +
                "//descendant::option[contains(text(),'" +TaskVer+"')]");
    }
    public static SelenideElement CreateConfirm = $x("//input[@value='Создать']");

}
