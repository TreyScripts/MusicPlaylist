package vcmsa.ci.musicplaylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PlaylistActivity : AppCompatActivity() {


        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)

            val btnAddSong = findViewById<Button>(R.id.btnAddSong)
            val btnView = findViewById<Button>(R.id.btnView)
            val btnExit = findViewById<Button>(R.id.btnExit)

            btnAddSong.setOnClickListener{
                val intent = Intent(this, AddSongActivity::class.java) //Navigation to the Add song Screen
                startActivity(intent)
            }

            btnView.setOnClickListener {
                val intent = Intent(this, ViewActivity::class.java) //Navigation to the view screen
                startActivity(intent)
            }

            btnExit.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java) //back to the first screen
                startActivity(intent)
            }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }