package com.example.heroeslist

import Hero
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val hero = intent.getParcelableExtra<Hero>("hero")
        val heroName = findViewById<TextView>(R.id.textAlterEgo)
        val heroDate = findViewById<TextView>(R.id.textDataCriacao)
        val heroEnemies = findViewById<TextView>(R.id.textInimigos);
        val heroImage = findViewById<ImageView>(R.id.imageView)
        val heroPowerOrigin = findViewById<TextView>(R.id.textOrigemPoderes)

        heroName.text = hero?.alterEgo;
        heroDate.text = hero?.creationDate;
        heroImage.setImageResource(hero!!.heroImage);
        heroEnemies.text = hero?.enemies;
        heroPowerOrigin.text = hero?.powerOrigins;
    }
}