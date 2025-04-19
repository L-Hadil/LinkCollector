package com.example.linkcollector.utils

import android.content.Context
import com.example.linkcollector.model.UserData
import java.io.File

object FileHelper {
    private const val FILE_NAME = "user_data.txt"

    fun saveUserData(context: Context, user: UserData) {
        val data = buildString {
            appendLine("Nom: ${user.nom}")
            appendLine("Prénom: ${user.prenom}")
            appendLine("Page Web Perso: ${user.gitHub}")
            appendLine("LinkedIn Perso: ${user.linkedin}")

        }

        context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            it.write(data.toByteArray())
        }
    }

    fun readUserData(context: Context): String {
        val file = File(context.filesDir, FILE_NAME)
        return if (file.exists()) file.readText() else ""
    }
}
