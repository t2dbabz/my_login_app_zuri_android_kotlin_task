package com.example.android.myloginapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TeamAdapter(context: Context, teams: List<TeamModel>) :
        ArrayAdapter<TeamModel>(context, 0, teams) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val team = getItem(position)

        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.team_item_list, parent, false)
        }

        val teamLogoImageView = view?.findViewById<ImageView>(R.id.team_logo)
        val teamNameTextView = view?.findViewById<TextView>(R.id.team_name_textview)

        team?.logo?.let {
            teamLogoImageView?.setImageResource(team.logo)
        }

        teamNameTextView?.text = team?.teamName

        view?.setOnClickListener {
            val intent = Intent(parent.context, TeamDetailActivity::class.java)
            intent.putExtra(LOGO_EXTRA, team?.logo)
            intent.putExtra(TEAM_NAME_EXTRA, team?.teamName)
            intent.putExtra(DESCRIPTION_EXTRA, team?.description)

            parent.context.startActivity(intent)
        }

        return view!!
    }

    companion object {
        const val LOGO_EXTRA = "logo_extras"
        const val TEAM_NAME_EXTRA = "team_name_extra"
        const val DESCRIPTION_EXTRA = "description_extra"
    }
}