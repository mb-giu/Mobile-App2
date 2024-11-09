package com.example.heroeslist

import Hero
import HeroesAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {

    private lateinit var recyclerViewHeroes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerViewHeroes = findViewById(R.id.heroesRV)
        recyclerViewHeroes.adapter = HeroesAdapter(this.createHeroes(), this){
            Toast.makeText(this,it.heroName, Toast.LENGTH_LONG).show()
        }
        recyclerViewHeroes.layoutManager = LinearLayoutManager(this)
        recyclerViewHeroes.setHasFixedSize(true)
        recyclerViewHeroes.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL)
        )
    }

    private fun createHeroes() : List<Hero>{
        return listOf(
            Hero(R.drawable.batman, heroName = "Batman", heroCompany = "DC Comics", heroPower = "Alta Inteligência"),
            Hero(R.drawable.hulk, heroName = "Hulk", heroCompany = "Marvel Entertainment", heroPower = "Super Força"),
            Hero(R.drawable.flash, heroName = "Flash", heroCompany = "DC Comics", heroPower = "Super Velocidade"),
            Hero(R.drawable.drstrange, heroName = "Dr. Strange", heroCompany = "Marvel Entertainment", heroPower = "Magia"),
            Hero(R.drawable.superman, heroName = "Superman", heroCompany = "DC Comics", heroPower = "Super Força, Voo"),
            Hero(R.drawable.ironman, heroName = "Homem de Ferro", heroCompany = "Marvel Entertainment", heroPower = "Alta Inteligência, Armadura Poderosa")

        )
    }
}