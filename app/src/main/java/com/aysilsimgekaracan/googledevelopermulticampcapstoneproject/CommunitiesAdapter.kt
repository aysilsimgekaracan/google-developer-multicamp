package com.necatisozer.multicamp.kotlinoverview.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aysilsimgekaracan.googledevelopermulticampcapstoneproject.R
import com.aysilsimgekaracan.googledevelopermulticampcapstoneproject.data.model.Communities
import kotlinx.android.synthetic.main.item_communities.view.*

fun ViewGroup.inflate(layoutId: Int): View {
    val layoutInflater = LayoutInflater.from(context)
    return layoutInflater.inflate(layoutId, this, false)
}

class CommunitiesAdapter(val communitiesList: List<Communities.CommunitiesResponse>,
                         private val onClick: (Communities.CommunitiesResponse) -> Unit
                    ) : RecyclerView.Adapter<CommunitiesViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunitiesViewHolder {
            return CommunitiesViewHolder(parent.inflate(R.layout.item_communities))
        }

        override fun onBindViewHolder(holder: CommunitiesViewHolder, position: Int) {
            val community = communitiesList[position]

            holder.bind(community, onClick)
        }

        override fun getItemCount(): Int = communitiesList.size
}



class CommunitiesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

   fun bind(community: Communities.CommunitiesResponse, onClick: (Communities.CommunitiesResponse) -> Unit) {
       itemView.imageViewBanner.load(community.banner)
       itemView.textViewDescription.text = community.description

        itemView.setOnClickListener {
            onClick(community)
        }
   }

}



