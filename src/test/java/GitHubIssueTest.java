import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueTest {
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

    public  void testIssueSearch (){
        //SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        $x("//input[contains(@class,'header-search-input')]").click();
        $x("//input[contains(@class,'header-search-input')]").sendKeys(REPOSITORY);
        $x("//input[contains(@class,'header-search-input')]").submit();
        $x("//a[contains(@data-hydro-click,'" + REPOSITORY + "')]").click();
        $x("//span[@data-content='" + ISSUES + "']").click();
        $x("//span[contains(text(),'" + ISSUE_NUMBER + "')]").should(Condition.exist);
    }

}
