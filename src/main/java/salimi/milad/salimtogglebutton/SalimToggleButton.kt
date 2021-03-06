package salimi.milad.salimtogglebutton

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.view.setPadding
import salimi.milad.salimtogglebutton.common.const.ONE
import salimi.milad.salimtogglebutton.common.const.THREE
import salimi.milad.salimtogglebutton.common.const.TWO
import salimi.milad.salimtogglebutton.common.setMargin
import salimi.milad.salimtogglebutton.util.ToggleUtil
import salimi.milad.salimtogglebutton.util.ToggleUtil.selectToggle


class SalimToggleButton(
    context: Context?,
    attrs: AttributeSet?
) :
    LinearLayout(context, attrs), View.OnClickListener {
    private lateinit var mAttribute: TypedArray
    private lateinit var mClickListener: (Int) -> Unit
    private lateinit var mFirstTextView:TextView
    private lateinit var mSecondTextView:TextView
    private lateinit var mThirdTextView:TextView

    init {
        context?.let {
            setOnClickListener(this)
            val x=LayoutInflater.from(context).inflate(R.layout.threetogglebutton_all,this)
            val rootView=x.findViewById<LinearLayout>(R.id.linearLayout_all_choosePeriodOfTime)
            //inflate(context, R.layout.threetogglebutton_all, this)
            mFirstTextView=x.findViewById(R.id.textView_all_first)
            mSecondTextView=x.findViewById(R.id.textView_all_second)
            mThirdTextView=x.findViewById(R.id.textView_all_third)

            mAttribute =
                context.obtainStyledAttributes(attrs, R.styleable.BalootToggleButton)

            val unselectedTextColor =
                mAttribute.getColor(R.styleable.BalootToggleButton_unSelectedTextColor, Color.BLACK)
            val selectedTextColor =
                mAttribute.getColor(R.styleable.BalootToggleButton_selectedTextColor, Color.BLACK)
            val paddingButton =
                mAttribute.getDimension(R.styleable.BalootToggleButton_paddingButton, 2F)
            val paddingRoot =
                mAttribute.getDimension(R.styleable.BalootToggleButton_marginButton, 2F)
            val numberOfButtons = mAttribute.getInt(
                R.styleable.BalootToggleButton_numberOfButton,
                THREE
            )
            val buttonBackground = mAttribute.getResourceId(
                R.styleable.BalootToggleButton_buttonBackground,
                R.drawable.drawable_saverecurring_togglebuttonbackground
            )
            val rootBackground = mAttribute.getResourceId(
                R.styleable.BalootToggleButton_rootBackground,
                R.drawable.drawable_saverecurring_buttonselectednumerickeyboard
            )
            val firstTextOfButton = mAttribute.getString(
                R.styleable.BalootToggleButton_firstTextOfButton
            )
            val secondTextOfButton = mAttribute.getString(
                R.styleable.BalootToggleButton_secondTextOfButton
            )
            val thirdTextOfButton = mAttribute.getString(
                R.styleable.BalootToggleButton_thirdTextOfButton
            )
            buttonConfiguration(
                rootView,
                rootBackground,
                paddingButton,
                paddingRoot,
                numberOfButtons,
                firstTextOfButton,
                secondTextOfButton,
                thirdTextOfButton
                , unselectedTextColor
            )
            setOnClickListener(selectedTextColor, unselectedTextColor, buttonBackground)
        }
    }

    fun onClear() {
        mAttribute.recycle()
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

        if (numberOfButtons == TWO) {
            mThirdTextView.visibility = View.GONE
            mFirstTextView.run {
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
            mSecondTextView.run {
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
            mFirstTextView.run {
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
            mSecondTextView.run {
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
            mThirdTextView.run {
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
        mFirstTextView.setOnClickListener {
            selectToggle(
                it,
                mSecondTextView,
                mThirdTextView,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            mClickListener.invoke(ONE)
        }

        mSecondTextView.setOnClickListener {
            selectToggle(
                it,
                mFirstTextView,
                mThirdTextView,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            mClickListener.invoke(TWO)
        }

        mThirdTextView.setOnClickListener {
            selectToggle(
                it,
                mFirstTextView,
                mSecondTextView,
                selectedTextColor,
                unselectedTextColor,
                buttonBackground
            )
            mClickListener.invoke(THREE)
        }
    }

    fun clickListener(buttonClickListener: ((Int) -> Unit)) {
        mClickListener = buttonClickListener
    }

    override fun onClick(p0: View?) {
        //No action
    }
}