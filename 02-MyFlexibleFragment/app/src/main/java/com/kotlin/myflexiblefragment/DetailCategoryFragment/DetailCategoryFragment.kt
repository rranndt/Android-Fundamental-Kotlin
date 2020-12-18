package com.kotlin.myflexiblefragment.DetailCategoryFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.kotlin.myflexiblefragment.OptionDialogFragment.OptionDialogFragment
import com.kotlin.myflexiblefragment.ProfilActivity.ProfileActivity
import com.kotlin.myflexiblefragment.R

class DetailCategoryFragment : Fragment() {

    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var btnShowDialog: Button
    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvCategoryName = view.findViewById(R.id.tvCategoryName)
        tvCategoryDescription = view.findViewById(R.id.tvCategoryDescription)
        btnProfile = view.findViewById(R.id.btnProfile)
        btnShowDialog = view.findViewById(R.id.btnShowDialog)

        btnProfile.setOnClickListener {
            val mProfileIntent = Intent(activity, ProfileActivity::class.java)
            startActivity(mProfileIntent)
        }

        btnShowDialog.setOnClickListener {
            val mOptionDialogFragment = OptionDialogFragment()

            val mFragmentManager = childFragmentManager
            mOptionDialogFragment.show(
                mFragmentManager,
                OptionDialogFragment::class.java.simpleName
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            val categoryName = arguments?.getString(EXTRA_NAME)
            tvCategoryName.text = categoryName
            tvCategoryDescription.text = description
        }
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object :
        OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }

}

