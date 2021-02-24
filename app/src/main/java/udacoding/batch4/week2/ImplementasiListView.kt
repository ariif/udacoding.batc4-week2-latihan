package udacoding.batch4.week2

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import udacoding.batch4.week2.adapter.ListViewAdapter
import udacoding.batch4.week2.model.Anggota

class ImplementasiListView : AppCompatActivity() {

    private lateinit var List01: ListView
//    private lateinit var textNama : TextView
//    private lateinit var textAlamat : TextView
//    private lateinit var textNoHp : TextView
//    private lateinit var imageSay : ImageView
//    private lateinit var buttonClose : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_listview)
        List01 = findViewById(R.id.Listpunyaview)

        val listAnggota = ArrayList<Anggota>()
        listAnggota.add(Anggota("Rafi", 123456, R.drawable.udacoding, "Medan"))
        listAnggota.add(Anggota("Putra", 678912, R.drawable.logo, "Padang"))
        listAnggota.add(Anggota("Nando", 135791, R.drawable.redhat, "Binjai"))
        listAnggota.add(Anggota("Ucok", 246824, R.drawable.udacoding, "Deli Serdang"))

        val adapter = ListViewAdapter(this, listAnggota)
        List01.adapter = adapter

        List01.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, listAnggota.get(position).nama, Toast.LENGTH_SHORT).show()

            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(true)
                setContentView(R.layout.detail_list_item)

                val image = this.findViewById<ImageView>(R.id.imageSaya)
                val nama =  this.findViewById<TextView>(R.id.txtNama)
                val alamat = this.findViewById<TextView>(R.id.txtAlamat)
                val nohp = this.findViewById<TextView>(R.id.txtNoHp)
                val close = this.findViewById<Button>(R.id.close)

                val item = listAnggota.get(position)

                image.setImageResource(item.foto)
                nama.text = "Nama : ${item.nama}"
                nohp.text = "No Ho : ${item.nohp}"
                alamat.text = "Alamat : ${item.alamat}"

                close.setOnClickListener {
                    this.dismiss()
                }
            }.show()

        }
    }
}