package com.example.android.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.myloginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var adapter: TeamAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)
        setupTeamList()
    }

    private fun setupTeamList() {
        adapter = TeamAdapter(this, TeamData.teamDetails)
        binding?.listView?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}