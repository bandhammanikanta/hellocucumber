package hellocucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class IsItFriday {
	static String isItFriday(String today) {
		if (today.equalsIgnoreCase("Friday")) {
			return "TGIF";
		}
		return "Nope";
	}
}

public class Stepdefs {
	private String today;
	private String actualAnswer;

	@Given("^today is \"([^\"]*)\"$")
	public void today_is_Sunday(String day) {
		this.today = day;
	}

	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_is_s_Friday_yet() {
		this.actualAnswer = IsItFriday.isItFriday(today);
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String expectedAnswer) {
		assertEquals(expectedAnswer, actualAnswer);
	}

	//TODO-- need to know 'how to pass annotations of others scenarios in @After
	/*@After("@Sele and @Stars")
	public void simlple() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
	}*/
}