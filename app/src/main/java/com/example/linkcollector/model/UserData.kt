package com.example.linkcollector.model

import java.io.Serializable

data class UserData(
    val nom: String,
    val prenom: String,
    val gitHub: String,
    val linkedin: String,

) : Serializable
