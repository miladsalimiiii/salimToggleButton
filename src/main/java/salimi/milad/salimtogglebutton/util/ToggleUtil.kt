package salimi.milad.salimtogglebutton.util

import android.os.Build
import android.view.View
import android.widget.TextView
import salimi.milad.salimtogglebutton.common.const.SELECTED
import salimi.milad.salimtogglebutton.common.const.UNSELECTED

object ToggleUtil {

    fun selectToggle(
        selectedButton: View,
        FirstToggleButton: View,
        secondToggleButton: View? = null,
        selectedTextButtonColor:Int,
        unSelectedTextButtonColor:Int,
        resourceId: Int
    ) {
        if (selectedButton.tag == UNSELECTED) {
            selectedButton.tag = SELECTED
            FirstToggleButton.tag = UNSELECTED
            FirstToggleButton.background = null
            secondToggleButton?.tag = UNSELECTED
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                secondToggleButton?.background = null
            }

            selectedButton.setBackgroundResource(resourceId)
            (selectedButton as TextView).setTextColor(selectedTextButtonColor)
            (FirstToggleButton as TextView).setTextColor(unSelectedTextButtonColor)
            (secondToggleButton as TextView).setTextColor(unSelectedTextButtonColor)
        }
    }
}