package ivan.ermolaev.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenerTest {

    @Test
    @Owner("Ermolaev Ivan")
    @Story("Проверка наличия вкладки Issues в репозитории листенером")
    @DisplayName("Проверка наличия вкладки Issues в репозитории листенером")
    public void issueNameValidationSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).shouldBe(Condition.visible);
        $(By.partialLinkText("Issues")).shouldHave(text("Issues"));
    }
}
