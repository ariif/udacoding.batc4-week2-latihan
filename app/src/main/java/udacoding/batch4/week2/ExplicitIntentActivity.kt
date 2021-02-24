package udacoding.batch4.week2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class ExplicitIntentActivity : AppCompatActivity() {

    private lateinit var buttonImplicitKu: Button
    private lateinit var textUsername : TextView
    private lateinit var textPassword : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explicit_intent)

        textUsername = findViewById(R.id.textUserr)
        textPassword = findViewById(R.id.textPasss)
        if (Build.VERSION.SDK_INT >= 23){

            if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE), 0)
            }
        }



        buttonImplicitKu = findViewById(R.id.btnLogin)


        buttonImplicitKu.setOnClickListener {
           val dataLogin = ModelLogin(textUsername.text.toString(), textPassword.text.toString())

            val intent = Intent(this, ImplicitIntentActivity::class.java)
            intent.putExtra("data", dataLogin)
            // intent.putExtra("user", textUsername.text.toString())
           // intent.putExtra("pass", textPassword.text.toString())
            startActivity(intent)
        }

    }
}