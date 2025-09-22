package contreras.roberto.myapplication

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        val img: ImageView = findViewById(R.id.iv_pelicula)
        val nme: TextView = findViewById(R.id.tv_nombre_pelicula)
        val dsc: TextView = findViewById(R.id.tv_desc_pelicula)

        if (bundle != null) {
            img.setImageResource(bundle.getInt("header"))
            nme.setText(bundle.getString("titulo"))
            dsc.setText(bundle.getString("sinopsis"))
        }

    }
}