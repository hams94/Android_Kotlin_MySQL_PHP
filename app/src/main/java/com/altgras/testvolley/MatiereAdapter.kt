package com.altgras.testvolley


import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso



class MatiereAdapter(var matieres: ArrayList<Matiere>,var context:Context): RecyclerView.Adapter<MatiereAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var vue = LayoutInflater.from(p0.context).inflate(R.layout.item_matiere,p0,false)
        var viewHolder = MyViewHolder(vue)
        return viewHolder
    }

    override fun getItemCount(): Int {
       return matieres.size
    }

    override fun onBindViewHolder(vue: MyViewHolder, position: Int) {
        var matiere = matieres.get(position)
        vue.nom.setText(matiere.nom)
        vue.departement.setText(matiere.departement)
        var imageUrl = "http://192.168.43.128/gandhi/images/${matiere.image}"
        Picasso.get().load(imageUrl).resize(100,100).centerCrop().into(vue.image)
        vue.cardview.setOnClickListener(View.OnClickListener {
            var intent = Intent(context,EditActivity::class.java)
            intent.putExtra("KEY_IMAGE",imageUrl)
            intent.putExtra("KEY_MATIERE",matiere.nom)
            intent.putExtra("KEY_DEPARTEMENT",matiere.departement)
            intent.putExtra("KEY_ID",matiere.id)
            context.startActivity(intent)

        })
    }


    class MyViewHolder(vue:View):RecyclerView.ViewHolder(vue){
        var image = vue.findViewById<ImageView>(R.id.ivImage)
        var nom = vue.findViewById<TextView>(R.id.tvMat)
        var departement = vue.findViewById<TextView>(R.id.tvDept)
        var cardview = vue.findViewById<CardView>(R.id.cardview)
    }
}