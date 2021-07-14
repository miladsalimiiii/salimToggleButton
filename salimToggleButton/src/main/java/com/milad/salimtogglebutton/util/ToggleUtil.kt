package com.milad.salimtogglebutton.util

import android.view.View
import android.widget.TextView


private const val SELECTED = "selected"
private const val UNSELECTED = "unselected"

object ToggleUtil {

    fun selectToggleHighlight(
        selectedButton: View,
        FirstToggleButton: View,
        secondToggleButton: View? = null,
        selectedTextButtonColor: Int,
        unSelectedTextButtonColor: Int,
        resourceId: Int
    ) {
        if (selectedButton.tag == UNSELECTED) {
            selectedButton.tag = SELECTED
            FirstToggleButton.tag = UNSELECTED
            FirstToggleButton.background = null
            secondToggleButton?.tag = UNSELECTED
            secondToggleButton?.background = null

            selectedButton.setBackgroundResource(resourceId)
            (selectedButton as TextView).setTextColor(selectedTextButtonColor)
            (FirstToggleButton as TextView).setTextColor(unSelectedTextButtonColor)
            (secondToggleButton as TextView).setTextColor(unSelectedTextButtonColor)
        }
    }

    fun selectToggleIndicator(
        selectedButton: View,
        FirstToggleButton: View,
        secondToggleButton: View? = null,
        selectedTextButtonColor: Int,
        unSelectedTextButtonColor: Int
    ) {
        if (selectedButton.tag == UNSELECTED) {
            selectedButton.tag = SELECTED
            FirstToggleButton.tag = UNSELECTED
            secondToggleButton?.tag = UNSELECTED

            (selectedButton as TextView).setTextColor(selectedTextButtonColor)
            (FirstToggleButton as TextView).setTextColor(unSelectedTextButtonColor)
            (secondToggleButton as TextView).setTextColor(unSelectedTextButtonColor)
        }
    }

}
