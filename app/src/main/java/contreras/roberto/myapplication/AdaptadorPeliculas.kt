package contreras.roberto.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorPeliculas(val peliculas: List<Pelicula>): RecyclerView.Adapter<AdaptadorPeliculas.PeliculaViewHolder>() {

    class PeliculaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById(R.id.iv_pelicula) as ImageView
        var nme = itemView.findViewById(R.id.tv_nombre_pelicula) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pelicula, parent, false)
        return PeliculaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula: Pelicula = peliculas[position]
        holder.nme.text = pelicula.titulo
        holder.img.setImageResource(pelicula.image)

        holder.img.setOnClickListener {
            var intent = Intent(holder.itemView.context, DetallePelicula::class.java)
            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("image", pelicula.image)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            intent.putExtra("numberSeats", (20-pelicula.seats.size))
            intent.putExtra("pos", position)
            holder.itemView.context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

}