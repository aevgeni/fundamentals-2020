package com.android.fundamentals.workshop04.task

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.fundamentals.R
import com.android.fundamentals.workshop04.SampleBottomSheet
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class WS04AssignmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws04)

        findViewById<Button>(R.id.btn_show_alert_dialog)?.apply {
            setOnClickListener {
                // TODO(WS4:1) set title, positive, negative and neutral buttons for AlertDialog.
                //  Make it show Toast when pressing button and show in toast what button was pressed
                //  * Make it show Toast about cancelling dialog only when it is closed by tapping outside
                //  * Make dialog not to be closed when tapped outside of fragment
                //  AlertDialog.Builder(context)
                //  .show()
                AlertDialog.Builder(context)
                    .setCancelable(false)
                    .setTitle("Alert!!!")
                    .setMessage("Some text")
                    .setPositiveButton("ok") { _, _ ->
                        Toast.makeText(context, "you called ok", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("cancel") { _, _ ->
                        Toast.makeText(context, "you called cancel", Toast.LENGTH_LONG).show()
                    }
                    .setNeutralButton("retry") { _, _ ->
                        Toast.makeText(context, "you called retry", Toast.LENGTH_SHORT).show()
                    }
                    .setOnCancelListener {
                        Toast.makeText(context, "alert dismissed", Toast.LENGTH_SHORT).show()
                    }
                    .show()
            }
        }

        findViewById<Button>(R.id.btn_show_dialog_fragment)?.apply {
            setOnClickListener {
                // TODO(WS4:2) show dialog fragment SampleDialogFragment.
                //  Change SampleDialogFragment to make it show Toasts as in alert dialog (previous task)
                val dialog = WS04AssignmentDialogFragment()

                dialog.show(supportFragmentManager, "dialog fragment")
            }
        }

        findViewById<Button>(R.id.btn_show_time_picker)?.apply {
            setOnClickListener {
                // TODO(WS4:3) make timePickerDialog to start with current time
                //  Show Snackbar with selected time
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR_OF_DAY)
                val minute = calendar.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@WS04AssignmentActivity,
                    { p1, p2, p3 ->
                        Snackbar.make(
                            rootView,
                            "you choosed $p2:$p3",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    },
                    hour,
                    minute,
                    true
                )
                timePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_date_picker)?.apply {
            setOnClickListener {
                // TODO(WS4:4) make timePickerDialog to start with today date
                //  Show Snackbar with selected datek
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(
                    this@WS04AssignmentActivity,
                    { p0, p1, p2, p3 ->
                        Snackbar.make(
                            rootView,
                            "you choosed $p3/$p2/$p1",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    },
                    year,
                    month,
                    day
                )

                datePickerDialog.show()
            }
        }

        findViewById<Button>(R.id.btn_show_bottom_sheet_dialog)?.apply {
            setOnClickListener {
                // TODO(WS4:5) show dialog fragment SampleBottomSheet
                //  Look at difference between dialogFragment and BottomSheetFragment layouts drawing  and change dialog_fragment to show buttons under textview

                val dialog = SampleBottomSheet()

                dialog.show(supportFragmentManager, "dialogFragment")
            }
        }
    }
}