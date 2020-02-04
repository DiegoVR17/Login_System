package com.diegovr17.loginsystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etEmailRe: EditText
    lateinit var etPassRe: EditText

    lateinit var ButtonLogin: Button
    lateinit var ButtonRe: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmailRe = findViewById(R.id.etEmailRe) as EditText
        etPassRe  = findViewById(R.id.etPassRe) as EditText

        ButtonLogin = findViewById(R.id.ButtonLog) as Button
        ButtonRe = findViewById(R.id.ButtonRegister) as Button

        var data = intent.extras
        var User: String = data?.getString("EmailU").toString()
        var Pass: String = data?.getString("PasswordU").toString()
        var ban1 = 0



        ButtonLogin.setOnClickListener(View.OnClickListener {


            var E_mailRe: String = etEmailRe.text.toString()
            var Pass_Re: String = etPassRe.text.toString()



            if (E_mailRe == ""){
                Toast.makeText(this, "Introduzca un nombre de usuario", Toast.LENGTH_SHORT).show()

            }
            else if (Pass_Re == ""){
                Toast.makeText(this, "Introduzca la contraseña para: " + E_mailRe, Toast.LENGTH_SHORT).show()

            }
            else{
                if (E_mailRe == User) ban1 += 1

                if (Pass_Re == Pass) ban1 += 1

                if (ban1 == 2) {
                    Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show()
                    goToMainActivity()
                } else {
                    Toast.makeText(this, "Usuario o contraseña erroneos. Presione registrarse", Toast.LENGTH_SHORT).show()
                }
            }

        })


        ButtonRe.setOnClickListener(View.OnClickListener {
            goToRegisterActivity()
        })


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {



            var User: String = data?.extras?.getString("Email").toString()
            var Pass: String = data?.extras?.getString("Password").toString()


            ButtonLogin.setOnClickListener(View.OnClickListener {

                var ban1 = 0
                var E_mailRe: String = etEmailRe.text.toString()
                var Pass_Re: String = etPassRe.text.toString()


                if (E_mailRe == ""){
                    Toast.makeText(this, "Introduzca un nombre de usuario", Toast.LENGTH_SHORT).show()

                }
                else if (Pass_Re == ""){
                    Toast.makeText(this, "Introduzca la contraseña para: " + E_mailRe, Toast.LENGTH_SHORT).show()

                }
                else{
                    if (E_mailRe == User) ban1 += 1

                    if (Pass_Re == Pass) ban1 += 1

                    if (ban1 == 2) {
                        Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show()
                        goToMainActivity()
                    } else {
                        Toast.makeText(this, "Usuario o contraseña erroneos. Presione registrarse", Toast.LENGTH_SHORT).show()
                    }
                }

            })


            ButtonRe.setOnClickListener(View.OnClickListener {
                goToRegisterActivity()
            })


        }


    }

    private fun goToMainActivity() {
        var intent = Intent(this,MainActivity::class.java)
        intent.putExtra("Email_Show", etEmailRe.text.toString())
        intent.putExtra("Pass_Show", etPassRe.text.toString())
        etEmailRe.text.clear()
        etPassRe.text.clear()
        startActivity(intent)
        finish()
    }

    private fun goToRegisterActivity() {
        etEmailRe.text.clear()
        etPassRe.text.clear()
        var intent = Intent(this,RegisterActivity::class.java)
        startActivityForResult(intent,1)
    }
}
