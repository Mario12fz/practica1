package com.example.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.practica1.databinding.ActivityMainBinding

const val EXTRA_MESSAGE = "message"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val btnSend = binding.btnSend
        btnSend.setOnClickListener ({
            val edtMessage = binding.edtMessage
            if(edtMessage.text.toString().length == 0){
                Toast.makeText(this, "Enter your Message", Toast.LENGTH_SHORT).show()
            }else{
                // Pasar el contenido a otra actividad a tarves de un intent
                val message = edtMessage.text.toString()
                val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                // Iniciaaos la otra actividad actividad
                startActivity(intent)
            }

        })

        val btnGetData = binding.btnGetData
        btnGetData.setOnClickListener({
            val edtMessage = binding.edtMessage
            val edtName = binding.edtPersonName
            val edtEmail = binding.edtPersonEmail
            val edtAge = binding.edtPersonAge
            if(edtMessage.text.toString().length == 0 ||
                edtName.text.toString().length == 0 ||
                edtEmail.text.toString().length == 0 ||
                edtAge.text.toString().length == 0
            ){
                Toast.makeText(this, "Campo requerido", Toast.LENGTH_SHORT).show()
            }

        })


        binding.btnGetData.setOnClickListener({
            val edtMessage = binding.edtMessage
            val edtName = binding.edtPersonName
            val edtEmail = binding.edtPersonEmail
            val edtAge = binding.edtPersonAge
            if(edtMessage.text.toString().length > 0 ||
                    edtName.text.toString().length > 0 ||
                        edtEmail.text.toString().length > 0 ||
                        edtAge.text.toString().length > 0
                    ){
                binding.tvResult.text = edtMessage.text
                binding.tvResult.text = edtName.text
                binding.tvResult.text = edtEmail.text
                binding.tvResult.text = edtAge.text
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.item_search -> {
            Toast.makeText(this,"Item search", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.item_share -> {
            Toast.makeText(this,"Item share", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.item_setting -> {
           // Toast.makeText(this,"Item settings", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.item_exit -> {
            Toast.makeText(this,"Item Close App", Toast.LENGTH_SHORT).show()
            true
        }else ->{
            super.onOptionsItemSelected(item)
        }

    }

}