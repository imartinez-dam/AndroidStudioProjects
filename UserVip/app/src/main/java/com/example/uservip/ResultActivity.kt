package com.example.uservip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.uservip.UserVipApplication.Companion.prefs
import com.example.uservip.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()
    }
    fun initUI(){
        //
        binding.btnBack.setOnClickListener{
            prefs.wipe()
            onBackPressed()
        }
        //Agafem el nom
        val userName = prefs.getName()
        //Agafem els cognoms
        val userSurname = prefs.getSurname()
        //Agafem la direcció de GitHub
        val userGitHub = prefs.getGitHub()


        //Segons el tracte escollit mostrem un missatge o l'altre
        if(prefs.getInformal().equals(true))
        {
            binding.tvName.text = "Benvingut/da $userName $userSurname"
            binding.tvGitHub.text = "El teu GitHub és: $userGitHub"
        }
        else if(prefs.getFormal().equals(true))
        {
            binding.tvName.text = "Nom i cognoms: $userName $userSurname"
            binding.tvGitHub.text = "GitHub: $userGitHub"
        }
    }
    /*fun setVIPColorBackground()
    {
        binding.container.setBackgroundColor(ContextCompat.getColor(this,R.color.purple_200))
    }*/
}