package com.example.uservip

import android.content.Context
import java.net.URL

class Prefs(val context: Context) {
    //Necessitem el context de l'aplicació però el context només el tenen les classes propies d'android
    //Creem una constant amb el nom de la base de dades
    val SHARED_NAME ="Mydtb"
    val SHARED_USER_NAME ="username"
    val SHARED_USER_SURNAME = "surname"
    val SHARED_USER_GITHUB = "github"
    val SHARED_INFORMAL = "informal"
    val SHARED_FORMAL = "formal"

    //Instrucció per recuperar les preferències
    val storage = context.getSharedPreferences(SHARED_NAME,0)

    //FUNCIONS PER GUARDAR DADES

    //Funció per guardar el nom
    fun saveName(name:String){
        //Guardem a la nostra SharedPreference el nom
        storage.edit().putString(SHARED_USER_NAME,name).apply()
    }

    //Funció per guardar el cognom
    fun saveSurname(surname:String){
        //Guardem a la nostra SharedPreference el cognom
        storage.edit().putString(SHARED_USER_SURNAME, surname).apply()
    }

    //Funció per guardar la URL del GitHub
    fun saveGitHub(github:String){
        storage.edit().putString(SHARED_USER_GITHUB, github).apply()
    }

    //Funció per guardar el informal
    fun saveInformal(vip:Boolean){
        //Guardem a la nostra SharedPreference
        storage.edit().putBoolean(SHARED_INFORMAL,vip).apply()
    }

    //Funció per guardar el formal
    fun saveFormal(vip:Boolean){
        //Guardem a la nostra SharedPreference
        storage.edit().putBoolean(SHARED_FORMAL, vip).apply()
    }

    //FUNCIONS PER RECUPERAR DADES

    //Funció per recuperar el nom
    fun getName():String{
        //Posem el !! perquè sinó detecta que podria ser null. També podriem canviar el retorn a String?
        return storage.getString(SHARED_USER_NAME,"")!!
    }

    //Funció per recuperar els cognoms
    fun getSurname():String{
        return storage.getString(SHARED_USER_SURNAME, "")!!
    }

    //Funció per recuperar la String URL del GitHub
    fun getGitHub():String{
        return storage.getString(SHARED_USER_GITHUB, "")!!
    }

    //Funció per recuperar el radioButton informal
    fun getInformal():Boolean{
        return storage.getBoolean(SHARED_INFORMAL,false)
    }

    //Funció per recuperar el radioButton formal
    fun getFormal():Boolean{
        return storage.getBoolean(SHARED_FORMAL, false)
    }

    //Netejar les dades guardades
    fun wipe(){
        storage.edit().clear().apply()
    }
}