package matias.peralta.sameono


import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testUIElementsAreDisplayed() {
        Espresso.onView(withId(R.id.editText1))
            .check(ViewAssertions.matches(isDisplayed()))

        Espresso.onView(withId(R.id.editText2))
            .check(ViewAssertions.matches(isDisplayed()))

        Espresso.onView(withId(R.id.compareButton))
            .check(ViewAssertions.matches(isDisplayed()))

        Espresso.onView(withId(R.id.resultText))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun testComparisonResult() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        Espresso.onView(withId(R.id.editText1))
            .perform(ViewActions.typeText("10"))

        Espresso.onView(withId(R.id.editText2))
            .perform(ViewActions.typeText("5"))

        Espresso.onView(withId(R.id.compareButton))
            .perform(ViewActions.click())

        val expectedText = appContext.getString(R.string.result_text_template, "10", "5")
        Espresso.onView(withId(R.id.resultText))
            .check(ViewAssertions.matches(withText(expectedText)))
    }
}
