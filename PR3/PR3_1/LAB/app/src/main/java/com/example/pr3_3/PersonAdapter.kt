package com.example.pr3_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pr3_3.Model.PersonModelClass
import kotlinx.android.synthetic.main.item_person_layout.view.*

class PersonAdapter(val context: Context, val items: ArrayList<PersonModelClass>):
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_person_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)

        holder.tvId.text = item.id.toString()
        holder.tvSex.text = item.sex
        holder.tvName.text = item.name
        holder.tvPhoneNumber.text = item.phoneNumber
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId = view.tv_id
        val tvSex = view.tv_sex
        val tvName = view.tv_name
        val tvPhoneNumber = view.tv_phoneNumber
    }

}