package com.example.uservip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uservip.UserVipApplication.Companion.prefs
import com.example.uservip.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //inicialitzem l'activity
        initUI()
        //Accedim a les dades guardades
        checkUserValues()
    }

    fun checkUserValues() {
        //Si tenim dades guardades obrirem directament la ResultActivity
        if (prefs.getName().isNotEmpty()) {
            goToDetail()
        }
    }

    fun initUI() {
        binding.btnIniciarSessio.setOnClickListener { accesToDatail() }
    }

    //Accedim a les dades guardades
    fun accesToDatail() {
        //Validem el nom
        if (binding.etName.text.toString().isNotEmpty()) {
            //Guardem el nom de l'usuari
            prefs.saveName(binding.etName.text.toString())
            //Guardem els cognoms de l'usuari
            prefs.saveSurname(binding.etCognoms.text.toString())
            //Guardem la URL del GitHub
            prefs.saveGitHub(binding.GitHub.text.toString())

            //Comprovem que hi hagi un tracte seleccionat
            if (binding.rbInformal.isChecked || binding.rbFormal.isChecked) {
                //Guardem l'estat del radioButton informal
                prefs.saveInformal(binding.rbInformal.isChecked)
                //Guardem l'estat del radioButton formal
                prefs.saveFormal(binding.rbFormal.isChecked)
                goToDetail()
            } else {
                Snackbar.make(binding.root, "S'ha d'escollir un tracte", Snackbar.LENGTH_SHORT)
                    .show()
            }
        } else {
            //altre
            Snackbar.make(binding.root, "El camp nom no pot estar buit", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}