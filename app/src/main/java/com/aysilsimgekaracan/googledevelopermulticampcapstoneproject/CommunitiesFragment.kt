package com.aysilsimgekaracan.googledevelopermulticampcapstoneproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aysilsimgekaracan.googledevelopermulticampcapstoneproject.data.model.RetrofitProvider
import com.necatisozer.multicamp.kotlinoverview.news.CommunitiesAdapter
import kotlinx.android.synthetic.main.fragment_communities.*

class CommunitiesFragment : Fragment(R.layout.fragment_communities) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.activity?.setTitle(getString(R.string.title))

        lifecycleScope.launchWhenStarted {
            val response = RetrofitProvider.retrofitApi.getCommunities()


            recycleViewCommunities.adapter = CommunitiesAdapter(response.orEmpty().toMutableList()) {
                val direction = CommunitiesFragmentDirections.actionCommunitiesFragmentToDetailFragment(it)
                findNavController().navigate(direction)
            }

        }

    }
}