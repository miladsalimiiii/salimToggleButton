package com.milad.salimtogglebutton.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
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
    ConstraintLayout(context!!, attrs), View.OnClickListener {
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
            val selectedType = mAttribute.getInt(R.styleable.SalimToggleButton_selectType, 2)
            this.binding.textViewAllFirst.selectedType = selectedType
            this.binding.textViewAllSecond.selectedType = selectedType
            this.binding.textViewAllThird.selectedType = selectedType


            val underLineHight =
                mAttribute.getDimension(R.styleable.SalimToggleButton_underLineWidth, 12F)
            this.binding.textViewAllFirst.lineHeight = underLineHight
            this.binding.textViewAllSecond.lineHeight = underLineHight
            this.binding.textViewAllThird.lineHeight = underLineHight
            val underLineColor =
                mAttribute.getColor(R.styleable.SalimToggleButton_underLineColor, Color.BLACK)
            this.binding.textViewAllFirst.lineColor = underLineColor
            this.binding.textViewAllSecond.lineColor = underLineColor
            this.binding.textViewAllThird.lineColor = underLineColor
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

            when (selectedType) {
                1 -> {
                    setDefaultSelectedButtonHighlight(
                        selectedButton,
                        selectedTextColor,
                        unselectedTextColor,
                        buttonBackground
                    )
                }
                2 -> {
                    setDefaultSelectedButtonIndicator(
                        selectedButton,
                        selectedTextColor,
                        unselectedTextColor
                    )
                }
            }

            setOnClickListener(
                selectedTextColor,
                unselectedTextColor,
                buttonBackground,
                selectedType
            )
        }
    }

    private fun setDefaultSelectedButtonIndicator(
        selectedButton: Int,
        selectedTextColor: Int,
        unselectedTextColor: Int
    ) {
        when (selectedButton) {
            1 ->
                ToggleUtil.selectToggleIndicator(
                    textView_all_first,
                    textView_all_second,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor
                )
            2 ->
                ToggleUtil.selectToggleIndicator(
                    textView_all_first,
                    textView_all_second,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor
                )

            3 ->
                ToggleUtil.selectToggleIndicator(
                    textView_all_first,
                    textView_all_second,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor
                )
        }
    }

    private fun setDefaultSelectedButtonHighlight(
        selectedButton: Int,
        selectedTextColor: Int,
        unselectedTextColor: Int,
        buttonBackground: Int
    ) {
        when (selectedButton) {
            1 ->
                ToggleUtil.selectToggleHighlight(
                    textView_all_first,
                    textView_all_second,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )
            2 ->
                ToggleUtil.selectToggleHighlight(
                    textView_all_second,
                    textView_all_first,
                    textView_all_third,
                    selectedTextColor,
                    unselectedTextColor,
                    buttonBackground
                )

            3 ->
                ToggleUtil.selectToggleHighlight(
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
        selectedButton: Int,
        selectType: Int
    ) {
        when (selectedButton) {
            1 ->
                when (selectType) {
                    1 -> {
                        ToggleUtil.selectToggleHighlight(
                            textView_all_first,
                            textView_all_second,
                            textView_all_third,
                            selectedTextColor,
                            unselectedTextColor,
                            buttonBackground
                        )
                    }
                    2 -> {
                        ToggleUtil.selectToggleIndicator(
                            textView_all_first,
                            textView_all_second,
                            textView_all_third,
                            selectedTextColor,
                            unselectedTextColor
                        )
                    }
                }

            2 ->
                when (selectType) {
                    1 -> {
                        ToggleUtil.selectToggleHighlight(
                            textView_all_second,
                            textView_all_first,
                            textView_all_third,
                            selectedTextColor,
                            unselectedTextColor,
                            buttonBackground
                        )
                    }
                    2 -> {
                        ToggleUtil.selectToggleIndicator(
                            textView_all_second,
                            textView_all_first,
                            textView_all_third,
                            selectedTextColor,
                            unselectedTextColor
                        )
                    }
                }
            3 ->
                when (selectType) {
                    1 -> {
                        ToggleUtil.selectToggleHighlight(
                            textView_all_third,
                            textView_all_second,
                            textView_all_first,
                            selectedTextColor,
                            unselectedTextColor,
                            buttonBackground
                        )
                    }
                    2 -> {
                        ToggleUtil.selectToggleIndicator(
                            textView_all_third,
                            textView_all_second,
                            textView_all_first,
                            selectedTextColor,
                            unselectedTextColor
                        )
                    }
                }
        }
    }

    fun onClear() {
    }

    private fun buttonConfiguration(
        rootView: ConstraintLayout,
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
        buttonBackground: Int,
        selectType: Int
    ) {
        textView_all_first.setOnClickListener {
            when (selectType) {
                1 -> {
                    ToggleUtil.selectToggleHighlight(
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
                        Log.i("A", "setOnClickListener: $exception")
                    }
                }
                2 -> {
                    ToggleUtil.selectToggleIndicator(
                        it,
                        textView_all_second,
                        textView_all_third,
                        selectedTextColor,
                        unselectedTextColor
                    )
                    try {
                        mClickListener.invoke(1)
                    } catch (exception: Exception) {
                        Log.i("A", "setOnClickListener: $exception")
                    }
                }
            }

        }

        textView_all_second.setOnClickListener {
            when (selectType) {
                1 -> {
                    ToggleUtil.selectToggleHighlight(
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
                2 -> {
                    ToggleUtil.selectToggleIndicator(
                        it,
                        textView_all_first,
                        textView_all_third,
                        selectedTextColor,
                        unselectedTextColor
                    )
                    try {
                        mClickListener.invoke(2)
                    } catch (exception: Exception) {

                    }
                }
            }

        }

        textView_all_third.setOnClickListener {
            when (selectType) {
                1 -> {
                    ToggleUtil.selectToggleHighlight(
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
                2 -> {
                    ToggleUtil.selectToggleIndicator(
                        it,
                        textView_all_first,
                        textView_all_second,
                        selectedTextColor,
                        unselectedTextColor
                    )
                    try {
                        mClickListener.invoke(3)
                    } catch (exception: Exception) {

                    }
                }
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
