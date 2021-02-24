package udacoding.batch4.week2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import udacoding.batch4.week2.R
import udacoding.batch4.week2.model.Anggota

class ListViewAdapter (private val context: Context, private val data:ArrayList<Anggota>?) : BaseAdapter() {
    override fun getCount(): Int = data?.size ?: 0

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: ""
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false)

        val nama  = view.findViewById<TextView>(R.id.namakuuu)
        val foto  = view.findViewById<ImageView>(R.id.gambarkuuu)

        val item = data?.get(position)

        nama.text = item?.nama
        foto.setImageResource(item?.foto ?: 0)

        return view
    }
}