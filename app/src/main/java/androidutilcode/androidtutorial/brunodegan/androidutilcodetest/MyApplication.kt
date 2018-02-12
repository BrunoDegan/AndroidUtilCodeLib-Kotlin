package androidutilcode.androidtutorial.brunodegan.androidutilcodetest

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * Created by brunodegan on 7/6/17.
 */
class MyApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		Utils.init(this)
	}
}