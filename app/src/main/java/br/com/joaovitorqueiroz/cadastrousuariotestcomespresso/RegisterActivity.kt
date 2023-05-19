package br.com.joaovitorqueiroz.cadastrousuariotestcomespresso

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.joaovitorqueiroz.cadastrousuariotestcomespresso.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            buttonRegister.setOnClickListener {
                if (etEmailRegister.text.toString()
                        .isNotEmpty() && etPasswordRegister.text.toString().isNotEmpty()
                ) {
                    startActivity(
                        Intent(applicationContext, MainActivity::class.java).apply {
                            putExtra(
                                FIELD_USER,
                                User(
                                    etEmailRegister.text.toString(),
                                    etPasswordRegister.text.toString(),
                                ),
                            )
                        },
                    )
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Os campos não podem ser nulos",
                        Toast.LENGTH_LONG,
                    ).show()
                }
            }
        }
    }

    companion object {
        const val FIELD_USER = "user"
    }
}
