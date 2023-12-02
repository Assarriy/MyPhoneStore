package com.assarriy.myphonestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.assarriy.myphonestore.databinding.ActivityDetailIphoneBinding

class DetailIphoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailIphoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailIphoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val iphone = intent.getParcelableExtra<Phone>(EXTRA_IPHONE) as Phone

        binding.imgItemProduct.setImageResource(iphone.photo)
        binding.tvItemName.text = iphone.name
        binding.tvItemPrice.text = iphone.price
        binding.tvItemDescription.text = iphone.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    companion object {
        const val EXTRA_IPHONE = "extra_iphone"
    }
}