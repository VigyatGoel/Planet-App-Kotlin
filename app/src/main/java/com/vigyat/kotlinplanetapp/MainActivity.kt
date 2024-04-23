package com.vigyat.kotlinplanetapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vigyat.kotlinplanetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var planetAdapter: PlanetAdapter
    private lateinit var planetsArray: ArrayList<Planet>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recyclerView = mainBinding.recyclerView

        planetsArray = arrayListOf(
            Planet("Mercury", 0, 1, R.drawable.mercury),
            Planet("Venus", 0, 2, R.drawable.venus),
            Planet("Earth", 1, 3, R.drawable.earth),
            Planet("Mars", 2, 4, R.drawable.mars),
            Planet("Jupiter", 79, 5, R.drawable.jupiter),
            Planet("Saturn", 82, 6, R.drawable.saturn),
            Planet("Uranus", 27, 7, R.drawable.uranus),
            Planet("Neptune", 14, 8, R.drawable.neptune)
        )

        planetAdapter = PlanetAdapter(planetsArray)
        recyclerView.adapter = planetAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}