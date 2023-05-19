package br.com.joaovitorqueiroz.cadastrousuariotestcomespresso

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

internal class RegisterActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(RegisterActivity::class.java)

    @Test
    fun realizarLogin_comCredenciaisCorretas_exibeMensagemSucesso() {
        Intents.init()
        val usuario = "usuariodeexemplo"
        val senha = "senhadeexemplo"
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, Intent())

        onView(withId(R.id.et_email_register)).perform(typeText(usuario))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.et_password_register)).perform(typeText(senha))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button_register)).perform(click())
        Intents.release()
    }

    @Test
    fun realizarLogin_comCredenciaisIncorretas_exibeMensagemErro() {
        Intents.init()
        val usuario = "usuarioincorreto"
        val senha = "senhaincorreta"

        onView(
            withId(R.id.et_email_register),
        ).perform(typeText(usuario)).perform(ViewActions.closeSoftKeyboard())
        onView(
            withId(R.id.et_password_register),
        ).perform(typeText(senha)).perform(ViewActions.closeSoftKeyboard())
        onView(
            withId(R.id.button_register),
        ).perform(click())
        Intents.release()
    }
}
