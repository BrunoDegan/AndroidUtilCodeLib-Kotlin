package androiutilcode.androidtutorial.brunodegan.androidutilcodetest.extra

import com.blankj.utilcode.util.SPUtils

/**
 * Created by brunodegan on 7/6/17.
 */
class UrlUtil{
	companion object {
		@JvmField
		val URL = "http://superplacar.com.br"
		@JvmField
		val URL_NO_INTERNET = "file://android_asset/html/no-internet.html"
		@JvmField
		val SP = SPUtils.getInstance("PREF")
		
		fun saveLastUrl(url : String?) {
			SP.put("url", URL)
		}
		
		fun getLastUrl() = SP.getString("url", URL)
		
		fun clear() {
			SP.clear()
		}
	}
}