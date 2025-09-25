package contreras.roberto.myapplication

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
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
        var seatsLeft: TextView = findViewById(R.id.seatsLeft)
        var buyTickets: Button = findViewById(R.id.buyTickets)

        var nSeats = 0
        var id = -1
        var title: String? = null

        if (bundle != null) {
            nSeats = bundle.getInt("numberSeats")
            id = bundle.getInt("pos")
            title = bundle.getString("titulo")

            img.setImageResource(bundle.getInt("header"))
            nme.setText(title)
            dsc.setText(bundle.getString("sinopsis"))


            seatsLeft.setText("$nSeats seats availble")

        }

        if (nSeats==0) {
            buyTickets.isActivated = false
        } else {
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                startActivity(intent)
            }
        }


    }
}