package mx.tecnm.tepic.ladm_u1_practica1_layoutsymaslayouts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mx.ittepic.tepic.ladm_u1_practica2_archivos_memoria_i_e.R
import java.security.AccessControlContext

class EscalonarRecicler(private val context: Context,private var lista: List<ModeloRecilcer>):
    RecyclerView.Adapter<EscalonarRecicler.EscalarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EscalarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_linear, parent, false)
        return EscalarViewHolder(view)
    }

    override fun onBindViewHolder(holder: EscalarViewHolder, position: Int) {
        val escalarlista = lista[position]


        holder.txTitulo.setText(escalarlista.titulo)
        holder.txEscalar.setText(escalarlista.texto)

        holder.itemView.setOnClickListener{
            Toast.makeText(context,""+escalarlista.texto,Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return  lista.size
    }


    class EscalarViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val txTitulo = itemView.findViewById<TextView>(R.id.titulo)
        val txEscalar = itemView.findViewById<TextView>(R.id.texto1)
    }

}