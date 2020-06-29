package com.altgras.testvolley

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.textclassifier.TextLinks
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    var matieres : ArrayList<Matiere> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        var progressBar = findViewById<ProgressBar>(R.id.progressBar)


        matieres = ArrayList()



    }


    fun getDataFromServer(){
        var url = "http://192.168.43.128/backend/read.php"
        var request = StringRequest(Request.Method.GET,url,
            Response.Listener {
                response ->
                parseData(response)

            },
            Response.ErrorListener {
                error -> Toast.makeText(applicationContext,error.toString(),Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.VISIBLE
                recyclerview.visibility = View.GONE
            }
            )
        Volley.newRequestQueue(applicationContext).add(request)
    }

    fun parseData(response:String){
        progressBar.visibility = View.GONE
        recyclerview.visibility = View.VISIBLE
        //convertion de la reponse en un tableau json en kotlin
        var arrayJson = JSONArray(response)
        for(i in 0..arrayJson.length()-1){
            var jsonObject = arrayJson.getJSONObject(i)
            var matiere = Matiere(
                jsonObject.getInt("id"),
                jsonObject.getString("nom"),
                jsonObject.getString("departement"),
                jsonObject.getString("image")
            )
            matieres?.add(matiere)
        }

        var adapter = MatiereAdapter(matieres!!,applicationContext)
        recyclerview.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == R.id.itAdd){
            startActivity(Intent(applicationContext,MatiereAdd::class.java))
        }
        return true;
    }

    override fun onResume() {
        super.onResume()
        if(matieres?.size==0){
            getDataFromServer()
        }else{
            matieres?.clear()
            getDataFromServer()
        }

    }




}
