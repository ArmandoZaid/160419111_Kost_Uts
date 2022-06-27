package com.ubaya.a160419111_kost_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419111_kost_uts.R
import com.ubaya.a160419111_kost_uts.model.Kost
import com.ubaya.a160419111_kost_uts.util.loadImage
import kotlinx.android.synthetic.main.fragment_detail_kost.view.*

class KostListAdapter(val listKost:ArrayList<Kost>) : RecyclerView.Adapter<KostListAdapter.KostViewHolder>(){
    class KostViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_detail_kost,parent,false)
        return KostViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostViewHolder, position: Int) {
        val arraykost = listKost[position]
        with(holder.view){
            textNama.text = arraykost.nama
            textJenisKos.text = arraykost.jenis
            buttonDetail.setOnClickListener {
                var action:NavDirections
                /*if(GlobalData.currentFragment =="home"){
                    action = HomeFragmentDirections.actionItemHomeToKostListDetailFragment(arraykost.id.toString())
                }
                else{
                    action = KostListFragmentDirections.actionKostListToKostListDetailFragment(arraykost.id.toString())
                }*/
                action = KostListFragmentDirections.actionKostListToKostListDetailFragment(arraykost.id.toString())

                Navigation.findNavController(it).navigate(action)
            }
            imageKost.loadImage(arraykost.foto,progressBar)
        }
    }

    override fun getItemCount() = listKost.size
    fun updatekostlist(newkostlist:ArrayList<Kost>){
        listKost.clear()
        listKost.addAll(newkostlist)
        notifyDataSetChanged()
    }
}