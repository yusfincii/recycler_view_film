package com.example.filmrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val filmList = ArrayList<Film>()

        val film1 = Film(1, "Interstellar", "interstellar", 44.90)
        val film2 = Film(2, "Don't Look Up", "dont_look_up", 31.20)
        val film3 = Film(3, "Bizim İçin Şampiyon", "bizim_icin_sampiyon", 24.90)
        val film4 = Film(4, "Seven", "seven", 17.50)
        val film5 = Film(5, "The Martian", "the_martian", 24.90)
        val film6 = Film(6, "The Platform", "the_platform", 14.80)

        filmList.add(film1)
        filmList.add(film2)
        filmList.add(film3)
        filmList.add(film4)
        filmList.add(film5)
        filmList.add(film6)

        adapter = Adapter(this, filmList)
        binding.recyclerView.adapter = adapter

    }
}