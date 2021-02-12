import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestSerenity {

    String siteHomePage="https://pn.com.ua/";
    @Steps
    StepsForSerenity stepsForSerenity;

    @Test
    public void verifySubCategory() throws InterruptedException{
        //GIVEN
        stepsForSerenity.a_user_visits_a_page(siteHomePage);
        Thread.sleep(2000);
        //WHEN
        stepsForSerenity.the_user_chooses_category_Computer();
        Thread.sleep(2000);
        //THEN
        stepsForSerenity.the_user_can_see_subcategory_ITService("IT услуги");
    }
}
