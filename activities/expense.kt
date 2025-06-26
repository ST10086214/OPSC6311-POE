package com.example.finance.activities

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.finance.R
import com.example.finance.database.AppDatabase
import com.example.finance.models.Expense
import com.example.finance.models.Category
import kotlinx.coroutines.launch
import java.util.*

class ExpenseEntryActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var categories: List<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense)

        db = AppDatabase.getDatabase(this)

        val etAmount = findViewById<EditText>(R.id.etAmount)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etStartTime = findViewById<EditText>(R.id.etStartTime)
        val etEndTime = findViewById<EditText>(R.id.etEndTime)
        val spinnerCategory = findViewById<Spinner>(R.id.spinnerCategory)
        val btnSaveExpense = findViewById<Button>(R.id.btnSaveExpense)

        // Load categories into spinner
        lifecycleScope.launch {
            categories = db.categoryDao().getAllCategories()
            val categoryNames = categories.map { it.name }
            runOnUiThread {
                spinnerCategory.adapter = ArrayAdapter(
                    this@ExpenseEntryActivity,
                    android.R.layout.simple_spinner_item,
                    categoryNames
                )
            }
        }

        // Date picker for date field
        etDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val formatted = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
                    etDate.setText(formatted)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        btnSaveExpense.setOnClickListener {
            val amountStr = etAmount.text.toString()
            val description = etDescription.text.toString()
            val date = etDate.text.toString()
            val startTime = etStartTime.text.toString()
            val endTime = etEndTime.text.toString()
            val categoryIndex = spinnerCategory.selectedItemPosition

            if (amountStr.isBlank() || description.isBlank() || date.isBlank() || categoryIndex < 0) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = amountStr.toDoubleOrNull()
            if (amount == null) {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val categoryId = categories[categoryIndex].id

            lifecycleScope.launch {
                db.expenseDao().insertExpense(
                    Expense(
                        amount = amount,
                        description = description,
                        date = date,
                        startTime = startTime,
                        endTime = endTime,
                        categoryId = categoryId
                    )
                )
                runOnUiThread {
                    Toast.makeText(this@ExpenseEntryActivity, "Expense saved", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}
