package com.example.linkcollector.material

import android.app.IntentService
import android.content.Intent
import java.io.File
import java.net.URL

class HtmlDownloadService : IntentService("HtmlDownloadService") {

    override fun onHandleIntent(intent: Intent?) {
        val urlGitHub = intent?.getStringExtra("gitHub") ?: return
        val dir = File(filesDir, "html_files")
        if (!dir.exists()) dir.mkdir()

        try {
            val content = URL(urlGitHub).readText()
            val file = File(dir, "github.html")
            file.writeText(content)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
