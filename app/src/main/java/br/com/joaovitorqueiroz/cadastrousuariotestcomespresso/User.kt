package br.com.joaovitorqueiroz.cadastrousuariotestcomespresso

import java.io.Serializable

data class User(
    val email: String,
    val password: String
) : Serializable
