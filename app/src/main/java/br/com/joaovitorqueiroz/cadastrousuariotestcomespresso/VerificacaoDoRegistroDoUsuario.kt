package br.com.joaovitorqueiroz.cadastrousuariotestcomespresso

import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel

class VerificacaoDoRegistroDoUsuario : ViewModel() {

    fun registroDoUsuario(usuario: User): Boolean {
        if (!PatternsCompat.EMAIL_ADDRESS.matcher(usuario.email).matches()) {
            return false
        }

        if (usuario.password.isEmpty() || usuario.email.isEmpty()) {
            return false
        }

        return true
    }
}
