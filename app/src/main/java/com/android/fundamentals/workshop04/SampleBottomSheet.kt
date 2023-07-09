package com.android.fundamentals.workshop04

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.fundamentals.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SampleBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_fragment_ws04, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btn_ok)
        button.setOnClickListener {
            Toast.makeText(context, "You tapped ok", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }


    override fun setupDialog(
        dialog: Dialog,
        style: Int
    ) {

        val contentView =
            View.inflate(context, R.layout.dialog_fragment_ws04, null)
        dialog.setContentView(contentView)
        (contentView.parent as View).setBackgroundColor(
            ContextCompat.getColor(
                contentView.context,
                android.R.color.transparent
            )
        )
    }
}