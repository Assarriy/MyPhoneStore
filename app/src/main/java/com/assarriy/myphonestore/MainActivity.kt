package com.assarriy.myphonestore

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assarriy.myphonestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvIphone: RecyclerView
    private val list = ArrayList<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        rvIphone = findViewById(R.id.rv_iphone)
        rvIphone.setHasFixedSize(true)
        list.addAll(getListIphone())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getListIphone(): ArrayList<Phone> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_harga)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listIphone = ArrayList<Phone>()
        for (i in dataName.indices) {
            val phone =
                Phone(dataName[i], dataPrice[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listIphone.add(phone)
        }
        return listIphone
    }

    private fun showRecyclerList() {
        rvIphone.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListIphoneAdapter(list)
        rvIphone.adapter = listHeroAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        when (item.itemId) {
            R.id.action_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}