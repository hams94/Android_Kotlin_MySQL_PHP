package com.altgras.testvolley

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        var extras= intent.extras

        var image = findViewById<ImageView>(R.id.imageView)
        var matiere = findViewById<EditText>(R.id.edMat)
        var departement = findViewById<EditText>(R.id.edDept)

        var modifier = findViewById<Button>(R.id.btnModifier)
        var supprimer = findViewById<Button>(R.id.btnSupprimer)

        Picasso.get().load(extras.getString("KEY_IMAGE"))
                     .resize(100,100)
                     .centerCrop()
                    .into(image)

        matiere.setText(extras.getString("KEY_MATIERE"))
        departement.setText(extras.getString("KEY_DEPARTEMENT"))

        modifier.setOnClickListener(View.OnClickListener {
            var url:String = "http://192.168.43.128/backend/update.php";
            var request = object : StringRequest(
                Request.Method.POST,url,
                Response.Listener {
                        response -> Toast.makeText(applicationContext,response, Toast.LENGTH_SHORT).show()
                        finish()
                },
                Response.ErrorListener {
                        error ->  Toast.makeText(applicationContext,error.toString(), Toast.LENGTH_SHORT).show()
                }){
                override fun getParams(): MutableMap<String, String> {
                    var params = HashMap<String,String>()
                    params.put("nom",matiere.text.toString())
                    params.put("departement",departement.text.toString())
                    params.put("id",""+extras.getInt("KEY_ID"))
                    return params
                }
            }

            Volley.newRequestQueue(applicationContext).add(request)

        })

        supprimer.setOnClickListener(View.OnClickListener {
            var alertDialog = AlertDialog.Builder(this@EditActivity)

            alertDialog.setTitle("Suppression")

            alertDialog.setMessage("Etes vous sûr de vouloir supprimer cette matière")

            alertDialog.setPositiveButton("Oui",object :DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    suppression(extras.getInt("KEY_ID"))
                }
            })
            alertDialog.setNegativeButton("Non",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, p1: Int) {
                    dialog?.dismiss()
                }
            })

            alertDialog.create()
            alertDialog.show()

        })

    }

    fun suppression(id:Int){
        var url = "http://192.168.43.128/backend/delete.php?id=$id"
        
        var request = StringRequest(Request.Method.GET,url,
            Response.Listener { 
                response ->  Toast.makeText(applicationContext,response,Toast.LENGTH_SHORT).show()
                finish()
            },
            Response.ErrorListener { 
                error -> Toast.makeText(applicationContext,error.toString(),Toast.LENGTH_SHORT).show()  
            })
        
        Volley.newRequestQueue(applicationContext).add(request)
    }
}
