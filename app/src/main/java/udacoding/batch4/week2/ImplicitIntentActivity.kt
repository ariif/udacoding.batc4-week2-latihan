package udacoding.batch4.week2

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class ImplicitIntentActivity : AppCompatActivity() {

    private lateinit var btnCamera: Button
    private lateinit var btnBrowser: Button
    private lateinit var btnFile: Button
    private lateinit var textUsername : TextView
    private lateinit var textPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.implicit_intent)

        textUsername = findViewById(R.id.textUser)
        textPassword = findViewById(R.id.textPass)

        val getData : ModelLogin? = intent.getParcelableExtra<ModelLogin>("data")
        textUsername.text = getData?.username
        textPassword.text = getData?.password
       // textUsername.text = intent.getStringExtra("user")
        //textPassword.text = intent.getStringExtra("pass")

       if (Build.VERSION.SDK_INT >= 23){

           if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                   checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
               ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE), 0)
           }
       }

        btnCamera = findViewById(R.id.buttonCamera)
        btnBrowser = findViewById(R.id.buttonBrowser)
        btnFile = findViewById(R.id.buttonFile)

        btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnBrowser.setOnClickListener {
            val url = "https://detik.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
        }

        btnFile.setOnClickListener {
            val intent = Intent()
            intent.type = "*/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Pilih File"), 0)
        }

        }
    }
