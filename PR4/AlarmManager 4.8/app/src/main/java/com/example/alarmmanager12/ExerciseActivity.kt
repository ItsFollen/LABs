package com.example.alarmmanager12

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarmmanager12.databinding.ActivityExerciseBinding
import kotlin.random.Random
import kotlin.random.nextInt

class ExerciseActivity : AppCompatActivity() {

    private val images = arrayListOf(
        R.drawable.kulis,
        R.drawable.moth,
        R.drawable.artist,
        R.drawable.curtain,
        R.drawable.shooter,
        R.drawable.viy
    )
    private val binding: ActivityExerciseBinding by lazy {
        ActivityExerciseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val prefs = baseContext.getSharedPreferences("myPresf", Context.MODE_PRIVATE)

        val index = prefs.getInt("ID", 0)
        binding.pic.setImageResource(images[index])

        binding.exercText.text = resources.getStringArray(R.array.exercises)[index]
        binding.ok.setOnClickListener { finish() }

    }
}