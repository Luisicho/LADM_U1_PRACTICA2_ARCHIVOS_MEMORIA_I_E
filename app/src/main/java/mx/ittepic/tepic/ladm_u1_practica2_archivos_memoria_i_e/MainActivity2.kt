package mx.ittepic.tepic.ladm_u1_practica2_archivos_memoria_i_e

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONException
import org.json.JSONObject
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
        val note = Nota()
        note.titulo = txtTitle.text.toString()
        note.texto = txtNote.text.toString()
       try {
           val json = JSONObject()
           json.put("Titulo",note.titulo.toString())
           json.put("Texto",note.texto.toString())
           val archivo = OutputStreamWriter(openFileOutput("archivo.txt", MODE_PRIVATE))
           val contenido = json.toString()
           archivo.write(contenido)
           archivo.flush()
           archivo.close()
       } catch (e:JSONException){

       }//catch


    }
}


