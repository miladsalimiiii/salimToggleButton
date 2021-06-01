package com.milad.salimtogglebutton.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.setPadding
import com.milad.salimtogglebutton.R
import com.milad.salimtogglebutton.common.setMargin
import com.milad.salimtogglebutton.databinding.ThreetogglebuttonAllBinding
import com.milad.salimtogglebutton.util.ToggleUtil
import kotlinx.android.synthetic.main.threetogglebutton_all.view.*
import java.lang.Exception

class SalimToggleButton(
    context: Context?,
    attrs: AttributeSet?
) :
    LinearLayout(context, attrs), View.OnClickListener {
    private var unselectedTextColor: Int = Color.BLACK
    private var selectedTextColor: Int = Color.BLACK
    private var buttonBackground: Int = R.drawable.drawable_all_togglebuttonbackground
    private lateinit var mAttribute: TypedArray
    private lateinit var mClickListener: (Int) -> Unit
    private var mGetDefaultButton: Int = 1
    private lateinit var binding: ThreetogglebuttonAllBinding

    init {
        context?.let {
            setOnClickListener(this)
            binding = ThreetogglebuttonAllBinding.inflate(LayoutInflater.from(context), this, true)
            val rootView = binding.linearLayoutAllChoosePeriodOfTime

            mAttribute =
                context.obtainStyledAttributes(attrs, R.styleable.SalimToggleButton)

            unselectedTextColor =
                mAttribute.getColor(R.styleable.SalimToggleButton_unSelectedTextColor, Color.BLACK)
            selectedTextColor =
                mAttribute.getColor(R.styleable.SalimToggleButton_selectedTextColor, Color.BLACK)
            val paddingButton =
                mAttribute.getDimension(R.styleable.SalimToggleButton_paddingButton, 2F)
            val paddingRoot =
                mAttribute.getDimension(R.styleable.SalimToggleButton_marginButton, 2F)
            val numberOfButtons = mAttribute.getInt(
                R.styleable.SalimToggleButton_numberOfButton,
                3
            )
            val selectedButton = mAttribute.getInt(
                R.styleable.SalimToggleButton_selectedButton,
                0
            ).also {
                mGetDefaultButton = it
            }
            buttonBackground = mAttribute.getResourceId(
                R.styleable.SalimToggleButton_buttonBackground,
                R.drawable.drawable_all_togglebuttonbackground
            )
            val rootBackground = mAttribute.getResourceId(
                R.styleable.SalimToggleButton_rootBackground,
                R.drawable.drawable_all_buttonselectednumerickeyboard
            )
            val firstTextOfButton = mAttribute.getString(
                R.styleable.SalimToggleButton_firstTextOfButton
            )
            val secondTextOfButton = mAttribute.getString(
                R.styleable.SalimToggleButton_secondTextOfButton
            )
            val thirdTextOfButton = mAttribute.getString(
                R.styleable.SalimToggleButton_thirdTextOfButton
            )
            buttonConfiguration(
                rootView,
                rootBackground,
                paddingButton,
                paddingRoot,
                numberOfButtons,
                firstTextOfButton,
                secondTextOfButton,
                thirdTextOfButton, unselectedTextColor
            )
            setDefaultSelectedButton(
                selectedButton,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            setOnClickListener(selectedTextColor, unselectedTextColor, buttonBackground)
        }
    }

    private fun setDefaultSelectedButton(
        selectedButton: Int,
        selectedTextColor: Int,
        unselectedTextColor: Int,
        buttonBackground: Int
    ) {
        when (selectedButton) {
            1 ->
                ToggleUtil.selectToggle(
                    textView_all_first,
                    textView_all_second,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )
            2 ->
                ToggleUtil.selectToggle(
                    textView_all_second,
                    textView_all_first,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )

            3 ->
                ToggleUtil.selectToggle(
                    textView_all_third,
                    textView_all_second,
                    textView_all_first,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )
        }
    }

    fun setSelectedButton(
        selectedButton: Int
    ) {
        when (selectedButton) {
            1 ->
                ToggleUtil.selectToggle(
                    textView_all_first,
                    textView_all_second,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )
            2 ->
                ToggleUtil.selectToggle(
                    textView_all_second,
                    textView_all_first,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )

            3 ->
                ToggleUtil.selectToggle(
                    textView_all_third,
                    textView_all_second,
                    textView_all_first,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )
        }
    }

    fun onClear() {
    }

    private fun buttonConfiguration(
        rootView: LinearLayout,
        rootBackground: Int,
        paddingButton: Float,
        paddingRoot: Float,
        numberOfButtons: Int,
        firstTextOfButton: String?,
        secondTextOfButton: String?,
        thirdTextOfButton: String?,
        unselectedTextColor: Int
    ) {
        rootView.setBackgroundResource(rootBackground)
        rootView.setMargin(
            paddingRoot.toInt(),
            paddingRoot.toInt(),
            paddingRoot.toInt(),
            paddingRoot.toInt()
        )

        if (numberOfButtons == 2) {
            textView_all_third.visibility = View.GONE
            textView_all_first.run {
                this.text = firstTextOfButton
                setPadding(paddingButton.toInt())
                setMargin(
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt()
                )
                setTextColor(unselectedTextColor)
            }
            textView_all_second.run {
                this.text = secondTextOfButton
                setPadding(paddingButton.toInt())
                setMargin(
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt()
                )
                setTextColor(unselectedTextColor)
            }
        } else {
            textView_all_first.run {
                this.text = firstTextOfButton
                setPadding(paddingButton.toInt())
                setMargin(
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt()
                )
                setTextColor(unselectedTextColor)
            }
            textView_all_second.run {
                this.text = secondTextOfButton
                setPadding(paddingButton.toInt())
                setMargin(
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt()
                )
                setTextColor(unselectedTextColor)
            }
            textView_all_third.run {
                this.text = thirdTextOfButton
                setPadding(paddingButton.toInt())
                setMargin(
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt(),
                    paddingRoot.toInt()
                )
                setTextColor(unselectedTextColor)
            }
        }
    }

    private fun setOnClickListener(
        selectedTextColor: Int,
        unselectedTextColor: Int,
        buttonBackground: Int
    ) {
        textView_all_first.setOnClickListener {
            ToggleUtil.selectToggle(
                it,
                textView_all_second,
                textView_all_third,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            try {
                mClickListener.invoke(1)
            } catch (exception: Exception) {

            }
        }

        textView_all_second.setOnClickListener {
            ToggleUtil.selectToggle(
                it,
                textView_all_first,
                textView_all_third,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            try {
                mClickListener.invoke(2)
            } catch (exception: Exception) {

            }
        }

        textView_all_third.setOnClickListener {
            ToggleUtil.selectToggle(
                it,
                textView_all_first,
                textView_all_second,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            try {
                mClickListener.invoke(3)
            } catch (exception: Exception) {

            }
        }
    }

    fun clickListener(buttonClickListener: ((Int) -> Unit)) {
        mClickListener = buttonClickListener
    }

    fun getDefaultButton(): Int {
        return mGetDefaultButton
    }

    fun setDefaultButton(defaultButton: Int, buttonClickListener: ((Int) -> Unit)) {
        mClickListener = buttonClickListener
        when (defaultButton) {
            1 -> textView_all_first.callOnClick()
            2 -> textView_all_second.callOnClick()
            3 -> textView_all_third.callOnClick()
        }
    }

    override fun onClick(p0: View?) {
        //No action
    }
}