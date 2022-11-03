package com.example.chapter6_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6_mvvm.R
import com.example.chapter6_mvvm.databinding.ActivityMainBinding
import com.example.chapter6_mvvm.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var vm: CarViewModel
    lateinit var carAdapter : CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carVm = ViewModelProvider(this).get(CarViewModel::class.java)

        carVm.getLiveDataCar().observe(this, {
            if (it != null) {
                binding.rvHome.layoutManager = LinearLayoutManager(this)
                carAdapter = CarAdapter(it)
                binding.rvHome.adapter = carAdapter
            }else{
                Toast.makeText(this, "There is no data to show", Toast.LENGTH_LONG).show()

            }        })
        carVm.callApiCar()
    }
}