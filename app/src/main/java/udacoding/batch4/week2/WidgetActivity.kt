package udacoding.batch4.week2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class WidgetActivity : AppCompatActivity() {

    private lateinit var buttonToast:Button
    private lateinit var buttonSnackbar:Button
    private lateinit var buttonAlert: Button
    private lateinit var buttonCustomAlert: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)

        buttonToast = findViewById(R.id.btnToast)
        buttonSnackbar = findViewById(R.id.btnSnackBar)
        buttonAlert = findViewById(R.id.btnAlert)
        buttonCustomAlert = findViewById(R.id.btnCustomDialog)

        buttonToast.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_LONG).show()
        }

        buttonSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini adalah SnackBar", Snackbar.LENGTH_LONG).show()
        }

        buttonAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini adalah Alert")
                setPositiveButton("Ok") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik Ok", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("Cancel"){ dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik Cancel",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }.show()
            }
        }

        buttonCustomAlert.setOnClickListener { 
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val buttonCancel = this.findViewById<Button>(R.id.btnCancel)
                val buttonContinue = this.findViewById<Button>(R.id.btnContinue)

                buttonCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda klik Cancel", Toast.LENGTH_LONG).show()
                    this.dismiss()
                }

                buttonContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda Klik Ok", Toast.LENGTH_LONG).show()
                    this.dismiss()
                }
            }.show()
        }

    }
}