package com.karan.custom_dialogbox

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.karan.custom_dialogbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btncustom.setOnClickListener {
            val Dialog = Dialog(this)
            Dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            Dialog.setContentView(R.layout.custom_dialogbox)

            Dialog.setCancelable(false)
            val btnno = Dialog.findViewById<Button>(R.id.btnno)
            val btnyes = Dialog.findViewById<Button>(R.id.btnyes)
            btnno.setOnClickListener {
                Dialog.dismiss()
                startActivity(intent)
            }
            btnyes.setOnClickListener {
                Dialog.dismiss()
                startActivity(intent)
            }
            Dialog.show()

        }

    }

}
