package contreras.roberto.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Catalogo : AppCompatActivity() {
    var adapterP: AdaptadorPeliculas? = null
    var adapterS: AdaptadorPeliculas? = null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_catalogo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        peliculas = CargadorPeliculas().cargarPeliculas()
        series = CargadorPeliculas().cargarSeries()

        adapterP = AdaptadorPeliculas(peliculas)
        var rvP: RecyclerView = findViewById(R.id.rv_pelis)
        rvP.layoutManager = GridLayoutManager(this, 3)
        rvP.adapter = adapterP

        adapterS = AdaptadorPeliculas(series)
        var rvS: RecyclerView = findViewById(R.id.rv_series)
        rvS.layoutManager = GridLayoutManager(this, 3)
        rvS.adapter = adapterS
    }
}