package com.example.finance.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.finance.R

class NotificationActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val notifications = listOf(
        "Budget goal reached!",
        "You logged expenses 5 days in a row!",
        "Reminder: You are halfway through the month."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification)

        listView = findViewById(R.id.listViewNotifications)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notifications)
        listView.adapter = adapter
    }
}
