package com.example.linkcollector.classic

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.linkcollector.R
import com.example.linkcollector.model.UserData

class SecondActivityClassic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_classic)


        val textNom    = findViewById<TextView>(R.id.textNom)
        val textPrenom = findViewById<TextView>(R.id.textPrenom)
        val webPreview = findViewById<WebView>(R.id.webPreview)

        val user = intent.getSerializableExtra("user") as? UserData
        user?.let {
            textNom.text    = "Nom : ${it.nom}"
            textPrenom.text = "Prénom : ${it.prenom}"

            webPreview.apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(it.gitHub)
            }
        }
    }
}

