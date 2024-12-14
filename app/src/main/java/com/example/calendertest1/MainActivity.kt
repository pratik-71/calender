package com.example.calendertest1

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var selectedDateText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the layout file
        setContentView(R.layout.activity_main)

        // Initialize the views
        calendarView = findViewById(R.id.calendarView)
        selectedDateText = findViewById(R.id.SelectedDateText)

        // Apply window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set a listener for date selection on the CalendarView
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Format the selected date
            val selectedDate = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(selectedDate.time)

            // Update the TextView with the selected date
            selectedDateText.text = "Selected Date: $formattedDate"
        }
    }
}
