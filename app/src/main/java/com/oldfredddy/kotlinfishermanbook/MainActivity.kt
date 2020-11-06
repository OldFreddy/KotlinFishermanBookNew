package com.oldfredddy.kotlinfishermanbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()

        list.add(ListItem(R.drawable.som, "COM", "asdfjkgwerkjgasdfkhgasddfhg"))
        list.add(ListItem(R.drawable.nalim, "NALIM", "sdfgsdfgwergsdfgsdfgsdgdfgd"))
        list.add(ListItem(R.drawable.shuca, "ЩУКА", "wertwertwertwertwertwertwertwe"))
        list.add(ListItem(R.drawable.caras, "КАРАСЬ", "wertwertwertwertwertwertwertwe"))

        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)
        rc_view.adapter = MyAdapter(list, this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.id_fish -> Toast.makeText(this, "РЫБЫ", Toast.LENGTH_SHORT).show()
            R.id.id_na -> Toast.makeText(this, "НАЖИВКИ", Toast.LENGTH_SHORT).show()
            R.id.id_sna -> Toast.makeText(this, "СНАСТИ", Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this, "ИСТОРИИ", Toast.LENGTH_SHORT).show()

        }

        return true
    }
}