package JiraElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Tasks {
    public static SelenideElement TaskSearch = $x("//a[contains(text(), 'Поиск задач')]");
    public static SelenideElement BusyButt = $x("//span[contains(text(),'Бизнес-процесс')]//parent::a");
    public static SelenideElement DoneButt = $x("//span[contains(text(),'Выполнено')]");
    public static SelenideElement TaskStatusButton = $x("//div[@data-id='status']");
    public static SelenideElement SdelatButton = $x("//label[@data-descriptor-title='Сделать']");
}
