package com.example.myblossom
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val mList: List<UsersViewModel>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val UsersViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imgView.setImageResource(UsersViewModel.img)

        // sets the text to the textview from our itemHolder class
        holder.unameView.text = UsersViewModel.uname

        holder.tampilView.text = UsersViewModel.tampil

        holder.hapusView.text = UsersViewModel.hapus

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imgView)
        val unameView: TextView = itemView.findViewById(R.id.unameView)
        val hapusView: TextView = itemView.findViewById(R.id.hapusView)
        val tampilView: TextView = itemView.findViewById(R.id.tampilView)
    }
}