import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestSerenity {
    String url="https://pn.com.ua//ct//1003";
    @Steps
    StepsForSerenity steps;
    @Test
    public void verifySubCategory() throws InterruptedException {
        //GIVEN
        steps.a_user_visits_a_page(url);
        //WHEN
        steps.the_user_chooses_filter_by_cost();
        //THEN
        steps.the_user_sees_sorted_prices();
    }
}
