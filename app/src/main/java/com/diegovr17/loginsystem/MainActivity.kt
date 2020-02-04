package com.diegovr17.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tvEmailU: TextView
    lateinit var tvPassU: TextView
    lateinit var tvMsj: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvEmailU = findViewById(R.id.tvEmail_User) as TextView
        tvPassU = findViewById(R.id.tvPass_User) as TextView
        tvMsj = findViewById(R.id.tvMsj) as TextView

        var EmailUser = intent.extras
        var EUser:String = EmailUser?.getString("Email_Show").toString()
        var PUser:String = EmailUser?.getString("Pass_Show").toString()


        tvMsj.text = " Bienvenido: "
        tvEmailU.text =  EUser
        tvPassU.text = PUser
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.LogOut -> {
                Toast.makeText(this, "Sesión terminada", Toast.LENGTH_LONG).show()
                goToLoginActivity()

                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }

        }
    }

    private fun goToLoginActivity(){

        var intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("EmailU",tvEmailU.text.toString())
        intent.putExtra("PasswordU",tvPassU.text.toString())
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var intent = Intent(this,LoginActivity::class.java)
        intent.putExtra("EmailU",tvEmailU.text.toString())
        intent.putExtra("PasswordU",tvPassU.text.toString())
        startActivity(intent)
        finish()
    }

}