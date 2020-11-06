package com.oldfredddy.kotlinfishermanbook

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()
        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.fish),
                resources.getStringArray(R.array.fish_content),
                getImageId(R.array.fish_image_array)
            )
        )

//        list.add(ListItem(R.drawable.som, "COM", "asdfjkgwerkjgasdfkhgasddfhg"))
//        list.add(ListItem(R.drawable.nalim, "NALIM", "sdfgsdfgwergsdfgsdfgsdgdfgd"))
//        list.add(ListItem(R.drawable.shuca, "ЩУКА", "wertwertwertwertwertwertwertwe"))
//        list.add(ListItem(R.drawable.caras, "КАРАСЬ", "wertwertwertwertwertwertwertwe"))

        rc_view.hasFixedSize()
        rc_view.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rc_view.adapter = adapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.id_fish -> {
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.fish),
                        resources.getStringArray(R.array.fish_content),
                        getImageId(R.array.fish_image_array)
                    )
                )
                Toast.makeText(this, "РЫБЫ", Toast.LENGTH_SHORT).show()
            }
            R.id.id_na -> {
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.na),
                        resources.getStringArray(R.array.na_content),
                        getImageId(R.array.na_image_array)
                    )
                )
                Toast.makeText(this, "НАЖИВКИ", Toast.LENGTH_SHORT).show()
            }
            R.id.id_sna -> Toast.makeText(this, "СНАСТИ", Toast.LENGTH_SHORT).show()
            R.id.id_history -> Toast.makeText(this, "ИСТОРИИ", Toast.LENGTH_SHORT).show()

        }

        return true
    }

    fun getImageId(imageArrayId: Int): IntArray {
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

    fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1) {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }


}