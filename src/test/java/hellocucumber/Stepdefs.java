package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

class DayUtil {
    static String isItFriday(String today) {
        String result = "Nope";
        if (today.equals("Friday")) {
            result = "TGIF";
        }
        return result;
    }

    static String whatDayIsIt() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        return sdf.format(new Date());
    }
}

public class Stepdefs {
    private String today;
    private String actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @Given("^today is Friday$")
    public void today_is_Friday() {
        this.today = "Friday";
    }

    @Given("^today is something$")
    public void today_is_something() {
        this.today = DayUtil.whatDayIsIt();
    }

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) {
       this.today = today;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        this.actualAnswer = DayUtil.isItFriday(today);
        //System.out.println(DayUtil.whatDayIsIt());
    }

    @When("^It is not Friday$")
    public void it_is_not_Friday() throws Exception {
        this.actualAnswer = DayUtil.isItFriday(today);
    }

    @When("^It is Friday$")
    public void it_is_Friday() throws Exception {
        this.actualAnswer = DayUtil.isItFriday("Friday");
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
