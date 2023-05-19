package br.com.joaovitorqueiroz.cadastrousuariotestcomespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun putFieldsClickLogin() {
        onView(withId(R.id.et_email_login))
            .perform(ViewActions.replaceText("João"))

        onView(withId(R.id.et_password_login))
            .perform(ViewActions.replaceText("1234"))
    }
}
