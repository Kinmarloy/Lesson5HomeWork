import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

    private static final String BASE_URL = "http://github.com";

    private static final String ISSUES = "Issues";

    private static final String REPOSITORY = "Kinmarloy/Lesson5HomeWork";
    private static final String ISSUE_NUMBER = "#1";

    @Test
    @Owner("Kuchuk")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("web"), @Tag("normal")})
    @Link(name = "Base URL", value = BASE_URL)

    @Feature("Issues")
    @Story("Поиск Issue")
    @DisplayName("Поиск Issue по номеру в репозитории")
    public void testIssueSearch (){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open(BASE_URL);
        });

        step("Поиск репозитория " + REPOSITORY, () -> {
            $x("//input[contains(@class,'header-search-input')]").click();
            $x("//input[contains(@class,'header-search-input')]").sendKeys(REPOSITORY);
            $x("//input[contains(@class,'header-search-input')]").submit();
        });

        step("Переход в репозиторий " + REPOSITORY, () -> {
            $x("//a[contains(@data-hydro-click,'" + REPOSITORY + "')]").click();
        });

        step("Переход в раздел " + ISSUES, () -> {
            $x("//span[@data-content='" + ISSUES + "']").click();
        });
        step("Проверка Issue с номером " + ISSUE_NUMBER + " существует", () -> {
            $x("//span[contains(text(),'" + ISSUE_NUMBER + "')]").should(Condition.exist);
        });

    }

}
