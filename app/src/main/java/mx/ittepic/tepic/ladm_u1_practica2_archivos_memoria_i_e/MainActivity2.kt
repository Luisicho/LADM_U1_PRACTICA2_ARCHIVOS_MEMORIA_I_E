package mx.ittepic.tepic.ladm_u1_practica2_archivos_memoria_i_e

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        fab.setOnClickListener {
            guardar()
        }//fab
    }

    private fun guardar() {
       AlertDialog.Builder(this)
           .setTitle("GUARDAR")
           .setMessage("SELECCIONE DONDE GUARDAR")
           .setPositiveButton("SD"){d,i ->

           }
           .setNegativeButton("Interna"){d,i ->
               try {


                   val archivo = OutputStreamWriter(openFileOutput("archivo.txt", MODE_PRIVATE))
                   var dataContenido = txtTitle.text.toString() + ";" + txtNote.text.toString()

                   archivo.write(dataContenido)
                   archivo.flush()
                   archivo.close()

               }catch (io: IOException){

               }
           }
           .show()
    }
}


