package mx.ittepic.tepic.ladm_u1_practica2_archivos_memoria_i_e

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import mx.tecnm.tepic.ladm_u1_practica1_layoutsymaslayouts.EscalonarRecicler
import mx.tecnm.tepic.ladm_u1_practica1_layoutsymaslayouts.ModeloRecilcer

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

        iniciarEscalar()
    }

    private fun iniciarEscalar() {
        val imagen1 = ModeloRecilcer("PEPITO","Hola muy buenasmuy buenas el dia de hoy lome lomuy buenas el dia de hoy lome lo")
        escalalista.add(imagen1)
    }
}