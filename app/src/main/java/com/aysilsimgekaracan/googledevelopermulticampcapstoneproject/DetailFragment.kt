package com.aysilsimgekaracan.googledevelopermulticampcapstoneproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val navArgs by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val community = navArgs.community
        imageViewBanner.load(community.banner)
        textViewDescription.text = community.description
        imageViewLeaderPhoto.load(community.leader?.photo)
        textViewLeaderName.text = getString(R.string.leader, community.leader?.name)

        imageButtonYoutube.setOnClickListener() { openURL(community.links?.youtube) }
        imageButtonInstagram.setOnClickListener() { openURL(community.links?.instagram) }
        imageButtonTwitter.setOnClickListener() { openURL(community.links?.twitter) }
        imageButtonLink.setOnClickListener() { openURL(community.links?.participation) }

        this.activity?.setTitle(community.name)
    }

    private fun openURL(url: String?) {
        val uri: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }



}