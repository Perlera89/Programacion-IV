package com.example.gridcardviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorModificado(var imgList: ArrayList<ImgItems>, var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return imgList.size
    }

    override fun getItem(position: Int): Any {
        return imgList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.fila_item, parent, false)
        }
        var imgView: ImageView = view!!.findViewById(R.id.ivNombre)
        var tvName: TextView = view!!.findViewById(R.id.tvNombre)
        var tvDepartment: TextView = view!!.findViewById(R.id.tvDepartamento)

        val imgItems = imgList[position]
        imgView.setImageResource(imgItems.img)
        tvName.text = imgItems.name
        tvName.text = imgItems.department

        return view!!
    }
}