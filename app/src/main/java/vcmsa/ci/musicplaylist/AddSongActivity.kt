package vcmsa.ci.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddSongActivity : AppCompatActivity() {

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

        val edtSongTitle = findViewById<EditText>(R.id.edtSongTitle)
        val edtArtistName = findViewById<EditText>(R.id.edtArtistName)
        val edtRatings = findViewById<EditText>(R.id.edtRatings)
        val edtComments = findViewById<EditText>(R.id.edtComments)
        val btnView2 = findViewById<Button>(R.id.btnView2)
        val btnExit2 = findViewById<Button>(R.id.btnExit2)

        btnView2.setOnClickListener {
            val songTitles = edtSongTitle.text.toString()
            val artistNames = edtArtistName.text.toString()
            val rating = edtRatings.text.toString().toIntOrNull() ?: 0
            val comment = edtComments.text.toString()

            // Add the item to the parallel arrays
            songTitle.add(songTitles)
            artistName.add(artistNames)
            ratings.add(rating)
            comments.add(comment)

            Toast.makeText(this, "$songTitle added to playlist!", Toast.LENGTH_SHORT).show()
        }

        btnExit2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // return to main screen
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main3)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}