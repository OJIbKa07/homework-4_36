import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void basicSettingBrowder() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void SoftAssertionsCheck() {

        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        // кликнуть на первый репозиторий из списка найденых
        $("span.search-match").click();

        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        // переход в раздел Wiki
        $("#wiki-tab").click();

        // проверка что в списке страниц есть страница SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));

        // переход на страницу Soft assertions
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        // проверка что внутри есть заголовок JUnit5 и пример кода
        $("#wiki-wrapper").shouldHave(text("JUnit5"));

        $(withText("Using JUnit5")).scrollTo();
        $("#wiki-wrapper").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));


    }

}
