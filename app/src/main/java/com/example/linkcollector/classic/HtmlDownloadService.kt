package com.example.linkcollector.classic

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

class HtmlDownloadService : IntentService("HtmlDownloadService") {

    override fun onHandleIntent(intent: Intent?) {
        val urls = intent?.getStringArrayListExtra("urlList") ?: return
        val outputDir = File(filesDir, "downloaded_html")
        if (!outputDir.exists()) outputDir.mkdir()

        for (urlString in urls) {
            try {
                val url = URL(urlString)
                val connection = url.openConnection() as HttpURLConnection
                connection.connect()

                if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                    val content = connection.inputStream.bufferedReader().use { it.readText() }

                    val fileName = url.host.replace(".", "_") + ".html"
                    val file = File(outputDir, fileName)
                    file.writeText(content)

                    Log.d("DownloadService", "Saved: $fileName")
                }
                connection.disconnect()
            } catch (e: Exception) {
                Log.e("DownloadService", "Erreur de téléchargement: $urlString", e)
            }
        }
    }
}
