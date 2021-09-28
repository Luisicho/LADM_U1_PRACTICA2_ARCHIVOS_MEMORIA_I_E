package mx.ittepic.tepic.ladm_u1_practica2_archivos_memoria_i_e

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mx.tecnm.tepic.ladm_u1_practica1_layoutsymaslayouts.EscalonarRecicler
import mx.tecnm.tepic.ladm_u1_practica1_layoutsymaslayouts.ModeloRecilcer
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private var escalalista = ArrayList<ModeloRecilcer>()
    private lateinit var rvEscalar: RecyclerView
    private lateinit var adaptador: EscalonarRecicler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvEscalar = findViewById(R.id.recicler)

        rvEscalar.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adaptador = EscalonarRecicler(this,escalalista)
        rvEscalar.adapter = adaptador

        //abrirNotas()
        fab.setOnClickListener {startActivity(Intent(this, MainActivity2::class.java)) }
    }

    private fun abrirNotas() {
        //Ejemplo de abrir de un txt varias notas
        try {
            val archivo = BufferedReader(InputStreamReader(openFileInput("archivo.txt")))// Lee archivo separado por comas
            archivo.forEachLine {
                val listado = it.split(",") // crea arreglo linea a linea separado por comas
                val Nota1:Nota = Nota() // Se crea objeto nota
                val imagen1 = ModeloRecilcer(Nota1.titulo,Nota1.texto)// Se agrega nota al adaptador de recicler
                escalalista.add(imagen1) // Se agrega Nota al Recicler
            }
        }catch (io : IOException){
        }
    }

    private fun agregarNota() {

    }
}