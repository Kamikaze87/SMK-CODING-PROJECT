package com.example.smkcodingproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profile.*
import android.content.Intent
import android.app.Activity
import android.view.View

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val intentData = intent.extras
        val namaPengguna = intentData?.getString("name")

        editNama.setText(namaPengguna)
        save_btn.setOnClickListener { saveData() }
    }

    private fun saveData () {
        val edit = editNama.text.toString()
        if(!edit.isEmpty()) {
            val result = Intent()
            result.putExtra("name", edit)
            setResult(Activity.RESULT_OK, result)

            } else {
                setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
