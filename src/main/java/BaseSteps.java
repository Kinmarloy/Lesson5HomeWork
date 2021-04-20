package packageBaseSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BaseSteps {

    private static final String BASE_URL = "http://github.com";

    @Step ("Открываем главную страницу")
    public void openMainPage(){
        open(BASE_URL);
    }

    @Step ("Ищем репозиторий {repository}")
    public void searchForRepository(final String repository){
        $x("//input[contains(@class,'header-search-input')]").click();
        $x("//input[contains(@class,'header-search-input')]").sendKeys(repository);
        $x("//input[contains(@class,'header-search-input')]").submit();
    }

    @Step ("Переходим в репозиторий {repository}")
    public void goToRepositoryFromSearch(final String repository){
        $x("//a[contains(@data-hydro-click,'" + repository + "')]").click();
    }

    @Step ("Переходим в раздел Issues")
    public void openRepositoryIssues(){
        $x("//span[@data-content='" + "Issues" + "']").click();
    }

    @Step ("Проверяем что Issue с номером {number} существует")
    public void shouldSeeIssueWithNumber(final String number){
        $x("//span[contains(text(),'" + number + "')]").should(Condition.exist);
    }

}
