package com.example.smkcodingproject1

import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private var nameInput : String = ""
    private var genderInput : String = ""
    private var umurInput : String = ""
    private var addressInput : String = ""
    private var phoneInput : String = ""
    private var almtInput : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        save_btn.setOnClickListener{ goToProfileActivity() }
        save_btn.setOnClickListener{validasiInput()}
        setDatajeniskelamin()
    }

private fun setDatajeniskelamin(){
    val adapter = ArrayAdapter.createFromResource(this,R.array.Gender, android.R.layout.simple_spinner_item)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    jeniskelamin.adapter = adapter
}



    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

        private fun validasiInput (){
            nameInput = nama.text.toString ()
            genderInput = jeniskelamin.selectedItem.toString ()
            umurInput = age.text.toString()
            addressInput = email.text.toString()
            phoneInput = nomor.text.toString()
            almtInput = alamat.text.toString()


            when {
                nameInput.isEmpty() -> nama.error = "Kolom nama harus di isi"
                genderInput.equals ("Pilih jenis kelamin", ignoreCase = true) -> tampilToast ("Jenis kelamin harus dipilih")
                umurInput.isEmpty() -> age.error = "Kolom umur harus di isi"
                addressInput.isEmpty() -> email.error = "Kolom email harus di isi"
                phoneInput.isEmpty() -> nomor.error = "Kolom nomor telepon harus di isi"
                almtInput.isEmpty() -> alamat.error = "Kolom alamat harus di isi"

            else -> {
                tampilToast("Navigasi ke halaman profil")
                goToProfileActivity()
                }
            }
        }

    private fun goToProfileActivity(){
        val intent = Intent (this, UserProfileActivity::class.java)

        val bundle = Bundle()
        bundle.putString("name", nameInput)
        bundle.putString("gender", genderInput)
        bundle.putString("umur", umurInput)
        bundle.putString("address", addressInput)
        bundle.putString("phone", phoneInput)
        bundle.putString("alamat", almtInput)

        intent.putExtras(bundle)
        startActivity(intent)
    }
}
