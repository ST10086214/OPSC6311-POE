package com.example.finance.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.finance.R

class WalletActivity : AppCompatActivity() {

    private val wallets = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wallet)

        val etCardHolder = findViewById<EditText>(R.id.etCardHolder)
        val etCardNumber = findViewById<EditText>(R.id.etCardNumber)
        val etExpiry = findViewById<EditText>(R.id.etExpiry)
        val btnAddWallet = findViewById<Button>(R.id.btnAddWallet)
        val listViewWallets = findViewById<ListView>(R.id.listViewWallets)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, wallets)
        listViewWallets.adapter = adapter

        btnAddWallet.setOnClickListener {
            val holder = etCardHolder.text.toString()
            val number = etCardNumber.text.toString()
            val expiry = etExpiry.text.toString()

            if (holder.isBlank() || number.isBlank() || expiry.isBlank()) {
                Toast.makeText(this, "Please fill all card fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            wallets.add("$holder - $number - $expiry")
            adapter.notifyDataSetChanged()

            etCardHolder.text.clear()
            etCardNumber.text.clear()
            etExpiry.text.clear()
        }

        listViewWallets.setOnItemClickListener { _, _, position, _ ->
            wallets.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}
