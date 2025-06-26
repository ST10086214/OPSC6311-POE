package com.example.finance.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.finance.R

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        findViewById<Button>(R.id.btnAddExpense).setOnClickListener {
            startActivity(Intent(this, ExpenseEntryActivity::class.java))
        }

        findViewById<Button>(R.id.btnGraph).setOnClickListener {
            startActivity(Intent(this, GraphActivity::class.java))
        }

        findViewById<Button>(R.id.btnNotifications).setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        findViewById<Button>(R.id.btnWallets).setOnClickListener {
            startActivity(Intent(this, WalletActivity::class.java))
        }

        findViewById<Button>(R.id.btnCategories).setOnClickListener {
            startActivity(Intent(this, CategoryActivity::class.java))
        }
    }
}
