package com.kotlin.myflexiblefragment.OptionDialogFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import com.kotlin.myflexiblefragment.DetailCategoryFragment.DetailCategoryFragment
import com.kotlin.myflexiblefragment.R

class OptionDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOptions: RadioGroup
    private lateinit var rbSaf: RadioButton
    private lateinit var rbMou: RadioButton
    private lateinit var rbLvg: RadioButton
    private lateinit var rbMoyes: RadioButton
    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btnChoose)
        btnClose = view.findViewById(R.id.btnClose)
        rgOptions = view.findViewById(R.id.rgOptions)
        rbSaf = view.findViewById(R.id.rbSaf)
        rbMou = view.findViewById(R.id.rbMou)
        rbLvg = view.findViewById(R.id.rbLvg)
        rbMoyes = view.findViewById(R.id.rbMoyes)

        btnChoose.setOnClickListener {
            val checkedRadioButtonId = rgOptions.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                var coach: String? = null
                when (checkedRadioButtonId) {
                    R.id.rbSaf -> coach = rbSaf.text.toString().trim()

                    R.id.rbMou -> coach = rbMou.text.toString().trim()

                    R.id.rbLvg -> coach = rbLvg.text.toString().trim()

                    R.id.rbMoyes -> coach = rbMoyes.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) {
            val detailCategoryFragment = fragment
            this.optionDialogListener = detailCategoryFragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}