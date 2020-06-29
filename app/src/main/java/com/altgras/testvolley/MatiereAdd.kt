package com.altgras.testvolley


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MatiereAdd : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matiere_add)

        var matiere = findViewById<EditText>(R.id.edMat)
        var departement = findViewById<EditText>(R.id.edDept)
        var enregistrer = findViewById<Button>(R.id.btnEnregistrer)


        enregistrer.setOnClickListener(View.OnClickListener {

            var url:String = "http://192.168.43.128/backend/insert.php";
            var request = object :StringRequest(Request.Method.POST,url,
                Response.Listener {
                  response -> Toast.makeText(applicationContext,response,Toast.LENGTH_SHORT).show()

                },
                Response.ErrorListener {
                    error ->  Toast.makeText(applicationContext,error.toString(),Toast.LENGTH_SHORT).show()
                }){
                override fun getParams(): MutableMap<String, String> {
                    var params = HashMap<String,String>()
                    params.put("nom",matiere.text.toString())
                    params.put("departement",departement.text.toString())
                    return params
                }
            }

            Volley.newRequestQueue(applicationContext).add(request)

        })
    }
}
