package br.com.joaovitorqueiroz.cadastrousuariotestcomespresso

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.joaovitorqueiroz.cadastrousuariotestcomespresso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val user = try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(RegisterActivity.FIELD_USER, User::class.java)
            } else {
                intent.getSerializableExtra(RegisterActivity.FIELD_USER) as User
            }
        } catch (e: Exception) {
            User("", "")
        }

        with(binding) {
            buttonLogin.setOnClickListener {
                if (etEmailLogin.text.toString() == user?.email &&
                    etPasswordLogin.text.toString() == user.password
                ) {
                    Toast.makeText(
                        applicationContext,
                        "Authentication successful",
                        Toast.LENGTH_SHORT,
                    ).show()
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
}
