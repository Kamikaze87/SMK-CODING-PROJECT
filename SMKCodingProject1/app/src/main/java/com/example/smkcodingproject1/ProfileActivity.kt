package com.example.smkcodingproject1

import kotlinx.android.synthetic.main.activity_profile.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.app.Activity
import android.widget.Toast
import android.view.View
import android.net.Uri

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        getData()

        dial.setOnClickListener { dialNumber(userTelp.text.toString()) }
        edit.setOnClickListener { ngEditProfile() }
    }

    private fun getData(){
        val bundle = intent.extras

        val name = bundle?.getString("name")
        val gender = bundle?.getString("gender")
        val umur = bundle?.getString("umur")
        val phone = bundle?.getString("phone")
        val address = bundle?.getString("address")
        val alamat = bundle?.getString("alamat")

        userName.text = name
        userGender.text = gender
        userAge.text = umur
        userEmail.text = address
        userTelp.text = phone
        userAlamat.text = alamat
    }

    companion object {
        val REQUEST_CODE = 100
    }

    private fun ngEditProfile() {
        val intent = Intent (this, EditProfileActivity::class.java)

        val namaUser = userName.text.toString()
        intent.putExtra("name", namaUser)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode : Int, resultCode : Int, data:Intent?){
        if (requestCode == REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                val result = data!!.getStringExtra("name")
            } else  {
              Toast.makeText (this, "Failed to Edit",Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun dialNumber (phoneNumber: String){
            val intent = Intent(Intent.ACTION_DIAL) .apply {
                data = Uri.parse("tel:$phoneNumber")
            }
        if (intent.resolveActivity(packageManager) !=null) {
            startActivity(intent)
        }
    }
}

