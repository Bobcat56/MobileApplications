package com.example.menusandintents

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    /* Intent - internal messaging mechanism between the application and the operating systems. These can include data.
       Implicit intents - when we send data to the operating system and the operating system determines which application can handle that data.
       Application register (within the manifest) with the operating system that particular data can be handled by them.
       Explicit intent - when we specify the name of the activity - usually within the same project. */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.mitmOption1 -> {
                var httpIntent = Intent(ACTION_VIEW);
                httpIntent.data = Uri.parse("http://timesofmalta.com");
                startActivity(httpIntent)

                Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.mitmOption2 -> {
                var dialIntent = Intent(ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:+35699819288")
                startActivity(dialIntent)

                Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show()
                true
            }
        }

        return false
    }
}