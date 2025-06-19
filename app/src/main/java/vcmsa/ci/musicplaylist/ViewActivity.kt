package vcmsa.ci.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewActivity : AppCompatActivity() {

    private var songTitle = arrayListOf<String>(
        "FOMDJ", "NUN", "MDMA", "SRTBBL", "B5" //variable constants
    )
    private var artistName = arrayListOf<String>(
        "Playboi Carti", "Bktherula", "Ken Carson ft.Destroyl Lonely", "Destroy Lonely ft.Ken Carson", "Homixide Gang"
    )
    private var ratings = arrayListOf<Int>(
        5, 4, 4, 5, 3
    )
    private var comments = arrayListOf<String>(
        "HipHop/Rap", "Emo Rap", "Rage Rap", "Trap", "Rage Rap"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val btnExit3 = findViewById<Button>(R.id.btnExit3)

        fun calcAverage(){
            var sum = 0
            var count = 0

            val inputs = listOf(5, 4, 4, 5, 3)

            for(input in inputs){
                val number = input.toIntOrNull() ?:0

                sum += number
                if(number != 0) count++
            }
            val average = if(count > 0) {sum/count}
            else 0
            println("The average is: $average.")
        }

        calcAverage()

        btnDisplay.setOnClickListener {
            var playlistText = "Playlist:\n\n"
            for (i in songTitle.indices) {
                playlistText += "${songTitle[i]} - ${artistName[i]} - ${ratings[i]} - ${comments[i]}\n"
            }
            Toast.makeText(this, playlistText, Toast.LENGTH_LONG).show()
        }

        btnCalc.setOnClickListener{
            calcAverage()
        }

        btnExit3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main4)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}





