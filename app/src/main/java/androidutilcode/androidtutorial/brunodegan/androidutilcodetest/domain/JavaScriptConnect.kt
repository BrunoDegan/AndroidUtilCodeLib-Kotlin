package androidutilcode.androidtutorial.brunodegan.androidutilcodetest.domain

import android.webkit.JavascriptInterface
import androidutilcode.androidtutorial.brunodegan.androidutilcodetest.MainActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import java.lang.ref.WeakReference
/**
 * Created by brunodegan on 7/6/17.
 */
class JavaScriptConnect(val activity: WeakReference<MainActivity>) {
	
	companion object {
		@JvmField val INTERFACE_NAME = "AndroidInstance"
	}
	
	@JavascriptInterface
	fun reloadPage() {
		async(UI) {
			activity.get()?.loadPage()
		}
		
	}
}
