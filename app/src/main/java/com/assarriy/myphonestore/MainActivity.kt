package com.assarriy.myphonestore

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvIphone: RecyclerView
    private val list = ArrayList<Phone>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvIphone = findViewById(R.id.rv_iphone)
        rvIphone.setHasFixedSize(true)
        list.addAll(getListIphone())
        showRecyclerList()
    }

    private fun getListIphone(): ArrayList<Phone> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_harga)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listIphone = ArrayList<Phone>()
        for (i in dataName.indices){
            val phone = Phone(dataName[i], dataPrice[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listIphone.add(phone)
        }
        return listIphone
    }

    private fun showRecyclerList() {
        rvIphone.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListIphoneAdapter(list)
        rvIphone.adapter = listHeroAdapter
    }
}