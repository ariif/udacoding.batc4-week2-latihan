package udacoding.batch4.week2

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import udacoding.batch4.week2.adapter.RecyclerViewAdapter
import udacoding.batch4.week2.model.Anggota

class ImplementasiRecyclerView : AppCompatActivity() {

    private lateinit var listViewKuu : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_recyclerview)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Rafi",12345,R.drawable.udacoding,"Medan"))
        listAnggota.add(Anggota("Cucok",12345,R.drawable.udacoding,"Medan"))
        listAnggota.add(Anggota("Angga",12345,R.drawable.udacoding,"Medan"))
        listAnggota.add(Anggota("Kibas",12345,R.drawable.udacoding,"Medan"))

        listViewKuu = findViewById(R.id.listRecyler)

        listViewKuu.adapter = RecyclerViewAdapter(this,
                listAnggota,
                itemClick = object : RecyclerViewAdapter.OnClickListener {
                    override fun detailData(item: Anggota?) {

                        Dialog(this@ImplementasiRecyclerView).apply {
                            requestWindowFeature(Window.FEATURE_NO_TITLE)
                            setCancelable(true)
                            setContentView(R.layout.detail_list_item)

                            val image = this.findViewById<ImageView>(R.id.imageSaya)
                            val nama = this.findViewById<TextView>(R.id.txtNama)
                            val alamat = this.findViewById<TextView>(R.id.txtAlamat)
                            val nohp = this.findViewById<TextView>(R.id.txtNoHp)
                            val close = this.findViewById<Button>(R.id.close)

                            image.setImageResource(item?.foto ?: 0)
                            nama.text = "Nama :  ${item?.nama}"
                            nohp.text = "No Hp : ${item?.nohp}"
                            alamat.text = "Alamat : ${item?.alamat}"

                            close.setOnClickListener {
                                this.dismiss()
                            }
                            }.show()


                    }

                }
    }
}