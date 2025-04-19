package com.example.linkcollector.material

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.linkcollector.R
import com.example.linkcollector.databinding.ActivityMainMaterialBinding
import com.example.linkcollector.model.UserData

class MainActivityMaterial : AppCompatActivity() {

    private lateinit var binding: ActivityMainMaterialBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_LinkCollector_Material)

        super.onCreate(savedInstanceState)
        binding = ActivityMainMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnValider.setOnClickListener {
            val nom = binding.editNom.text.toString()
            val prenom = binding.editPrenom.text.toString()
            val gitHub = binding.editGitHub.text.toString()
            val linkedin = binding.editLinkedin.text.toString()

            val userData = UserData(nom, prenom, gitHub, linkedin)

            val intent = Intent(this, SecondActivityMaterial::class.java)
            intent.putExtra("userData", userData)

            val downloadIntent = Intent(this, HtmlDownloadService::class.java)
            downloadIntent.putExtra("gitHub", gitHub)
            startService(downloadIntent)

            startActivity(intent)
        }

        binding.btnAnnuler.setOnClickListener {
            finish()
        }
    }
}
