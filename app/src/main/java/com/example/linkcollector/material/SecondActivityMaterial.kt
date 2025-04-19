package com.example.linkcollector.material

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.linkcollector.R
import com.example.linkcollector.databinding.ActivitySecondMaterialBinding
import com.example.linkcollector.model.UserData
import java.io.File

class SecondActivityMaterial : AppCompatActivity() {

    private lateinit var binding: ActivitySecondMaterialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LinkCollector_Material)
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userData = intent.getSerializableExtra("userData") as? UserData

        binding.textNom.text = "Nom : ${userData?.nom}"
        binding.textPrenom.text = "Prénom : ${userData?.prenom}"

        val htmlFile = File(filesDir, "html_files/github.html")
        if (htmlFile.exists()) {
            binding.webPreview.apply {
                settings.javaScriptEnabled = true
                settings.allowFileAccess = true
                settings.allowFileAccessFromFileURLs = true
                settings.allowUniversalAccessFromFileURLs = true
                webViewClient = WebViewClient()
                loadUrl("file://${htmlFile.absolutePath}")
            }
        }
    }
}
