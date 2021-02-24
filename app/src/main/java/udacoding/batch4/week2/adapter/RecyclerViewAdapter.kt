package udacoding.batch4.week2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udacoding.batch4.week2.R
import udacoding.batch4.week2.model.Anggota

abstract class RecyclerViewAdapter (

//        private var namaKu: ImageView,
//        private var fotoKu : TextView,

        private val context: Context,
        private var data: List<Anggota>?,
        private val itemClick: OnClickListener
        ) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), ListAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)


        return ViewHolder(view);
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data?.get(position)

        holder.foto.setImageResource(item?.foto ?: 0)
        holder.nama.text = item?.nama

        holder.view.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    inner class  ViewHolder(val view : View) : RecyclerView.ViewHolder(view){

        var foto  = view.findViewById<ImageView>(R.id.gambarkuuu)
        var nama = view.findViewById<TextView>(R.id.namakuuu)
    }

    interface OnClickListener {

        fun detailData(item : Anggota?)
    }
}