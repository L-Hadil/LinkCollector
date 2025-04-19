package com.example.linkcollector



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.linkcollector.classic.MainActivityClassic
import com.example.linkcollector.databinding.ActivityLauncherBinding
import com.example.linkcollector.material.MainActivityMaterial


class LauncherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClassic.setOnClickListener {
            startActivity(Intent(this, MainActivityClassic::class.java))
        }

        binding.btnMaterial.setOnClickListener {
            startActivity(Intent(this, MainActivityMaterial::class.java))
        }
    }
}
