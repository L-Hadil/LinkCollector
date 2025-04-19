package com.example.linkcollector.classic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.linkcollector.R
import com.example.linkcollector.model.UserData
import com.example.linkcollector.utils.FileHelper
import java.io.Serializable

class MainActivityClassic : AppCompatActivity() {

    private lateinit var editNom: EditText
    private lateinit var editPrenom: EditText
    private lateinit var editGitHub: EditText
    private lateinit var editLinkedin: EditText
    private lateinit var btnValider: Button
    private lateinit var btnAnnuler: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_classic)

        // Liaison des vues
        editNom = findViewById(R.id.editNom)
        editPrenom = findViewById(R.id.editPrenom)
        editGitHub = findViewById(R.id.editGitHub)
        editLinkedin = findViewById(R.id.editLinkedin)
        btnValider = findViewById(R.id.btnValider)
        btnAnnuler = findViewById(R.id.btnAnnuler)

        btnValider.setOnClickListener {
            val user = UserData(
                nom = editNom.text.toString(),
                prenom = editPrenom.text.toString(),
                gitHub = editGitHub.text.toString(),
                linkedin = editLinkedin.text.toString()
            )

            // Enregistrer les données dans un fichier
            FileHelper.saveUserData(this, user)

            // Lancer le service pour télécharger les pages HTML
            val serviceIntent = Intent(this, HtmlDownloadService::class.java).apply {
                putExtra("urlList", arrayListOf(user.gitHub, user.linkedin))
            }
            startService(serviceIntent)

            // Passer à la seconde activité
            val intent = Intent(this, SecondActivityClassic::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }

        btnAnnuler.setOnClickListener {
            finish()
        }
    }
}
