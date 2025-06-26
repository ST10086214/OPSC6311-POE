package com.example.finance.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.finance.R
import kotlinx.coroutines.launch

class CategoryActivity : AppCompatActivity() {

    private lateinit var etCategoryName: EditText
    private lateinit var btnAddCategory: Button
    private lateinit var listViewCategories: ListView
    private val categories = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category)

        etCategoryName = findViewById(R.id.etCategoryName)
        btnAddCategory = findViewById(R.id.btnAddCategory)
        listViewCategories = findViewById(R.id.listViewCategories)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        listViewCategories.adapter = adapter

        btnAddCategory.setOnClickListener {
            val name = etCategoryName.text.toString()
            if (name.isNotBlank()) {
                lifecycleScope.launch {
                    val db = null
                    db.categoryDao().insertCategory(Category(name = name))
                    val updatedCategories = db.categoryDao().getAllCategories()
                    runOnUiThread {
                        adapter.clear()
                        adapter.addAll(updatedCategories.map { it.name })
                        adapter.notifyDataSetChanged()
                        etCategoryName.text.clear()
                    }
                }
            } else {
                Toast.makeText(this, "Category name cannot be empty", Toast.LENGTH_SHORT).show()

            }
        }
    }
}


