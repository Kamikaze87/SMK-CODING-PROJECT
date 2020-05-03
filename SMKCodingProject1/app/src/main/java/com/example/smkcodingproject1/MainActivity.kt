package com.example.smkcodingproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_btn.setOnClickListener(this)
    }

    private fun validate(): Boolean {
        if (nama.text.toString().isEmpty()) {
                nama.error = "Kolom Nama tidak boleh kosong"
                return false
            } else if (age.text.toString().isEmpty()) {
                age.error = "Kolom Umur wajib diisi"
                return false
            } else if (email.text.toString().isEmpty()) {
                email.error = "Kolom Email  wajib diisi"
                return false
            } else if (nomor.text.toString().isEmpty()) {
                nomor.error = "Nomor telepon Harus diisi"
                return false
            } else if (alamat.text.toString().isEmpty()){
                alamat.error = "Alamat harus diisi"
                return false
        }

        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.save_btn -> {
                if(validate()) {
                    Toast.makeText(applicationContext, "Tersimpan" ,Toast.LENGTH_LONG).show()
                }


            }
        }
    }
}