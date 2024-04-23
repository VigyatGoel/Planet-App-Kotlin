package com.vigyat.kotlinplanetapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vigyat.kotlinplanetapp.databinding.ItemPlanetBinding

class PlanetAdapter(private val planets: List<Planet>) :
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {

        val binding = ItemPlanetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val planet = planets[position]
        holder.bind(planet)
    }

    override fun getItemCount(): Int {
        return planets.size
    }

    class PlanetViewHolder(private val binding: ItemPlanetBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Planet) {
            binding.planetName.text = planet.planetName
            binding.numberOfMoons.text = planet.numberOfMoons.toString()
            binding.position.text = planet.position.toString()

            Glide.with(binding.root)
                .load(planet.planetImage)
                .into(binding.planetImageView)
        }
    }
}