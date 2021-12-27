package com.facronactz.jal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val PICK_IMAGE = 1
    val PICK_ARCHIVE = 0

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val uri: Uri? = data?.data
        val hasil: String? = uri?.getPath()
        if (requestCode == PICK_IMAGE) {
            val text = findViewById<TextView>(R.id.txtImage)
            text.setText(hasil)
            Toast.makeText(this@MainActivity, "Yassss", Toast.LENGTH_SHORT).show()
        }
        if (requestCode == PICK_ARCHIVE) {
            val text = findViewById<TextView>(R.id.txtArchive)
            text.setText(hasil)
            Toast.makeText(this@MainActivity, "Yassss", Toast.LENGTH_SHORT).show()
        }
    }

    fun openBrowseImage(view: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
        //text.setText(PICK_IMAGE)
    }


    fun openBrowseArchive(view: View){
        val rdbtn = findViewById<RadioGroup>(R.id.rdbtn)
        when(rdbtn.checkedRadioButtonId){
            R.id.rbtnRAR -> {
                val intent = Intent()
                intent.type = "application/x-rar-compressed"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Select RAR"), PICK_ARCHIVE)
            }
            R.id.rbtnZIP -> {
                val intent = Intent()
                intent.type = "application/zip"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Select ZIP"), PICK_ARCHIVE)
            }
        }


    }

}
