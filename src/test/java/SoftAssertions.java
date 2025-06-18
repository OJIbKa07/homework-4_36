import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void basicSettingBrowder() {
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void SoftAssertionsCheck() {
       /* open("/selenide/selenide");
        $$(".UnderlineNav-item span").findBy(text("Wiki")).click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $("div.markdown-body").$("a[href*='SoftAssertions']")
                .shouldBe(visible).click();

        $("body")
                .shouldHave(text("JUnit5"))
                .shouldHave(text("@ExtendWith"))
                .shouldHave(text("@Test"));

         */
        /* open("https://github.com/");
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Pricing'])[1]/following::span[1]").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $x("(.//*[normalize-space(text()) and normalize-space(.)='Filter'])[1]/following::em[1]").click();
        $("#wiki-tab").click();
        $(".markdown-body").shouldHave(text("Soft assertions"));
        $("div.markdown-body").$("a[href*='SoftAssertions']")
                .shouldBe(visible).click();

        $("#wiki-wrapper")
                .shouldHave(text("JUnit5"))
                .shouldHave(text("@ExtendWith"))
                .shouldHave(text("@Test"));


         */


        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых

        $$("ul.repo-list li").first().$("a").click();
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }

}
