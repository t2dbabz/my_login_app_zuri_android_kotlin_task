package com.example.android.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.myloginapp.databinding.ActivityTeamDetailBinding

class TeamDetailActivity : AppCompatActivity() {
    var binding: ActivityTeamDetailBinding? = null
    private var teamLogo = 0
    private var teamName: String? = null
    private var teamDescription = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        teamLogo = intent.getIntExtra(TeamAdapter.LOGO_EXTRA, teamLogo)
        teamName = intent.getStringExtra(TeamAdapter.TEAM_NAME_EXTRA)
        teamDescription = intent.getIntExtra(TeamAdapter.DESCRIPTION_EXTRA, teamDescription)

        setupTeamDetailData()
    }


    private fun setupTeamDetailData() {
        binding?.detailTeamLogo?.setImageResource(teamLogo)
        binding?.detailTeamName?.text = teamName
        binding?.detailTeamDescription?.text = getString(teamDescription)
        title = teamName
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}