package androidutilcode.androidtutorial.brunodegan.androidutilcodetest.domain

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.os.Build
import android.view.View
import android.webkit.*
import androidutilcode.androidtutorial.brunodegan.androidutilcodetest.MainActivity
import androiutilcode.androidtutorial.brunodegan.androidutilcodetest.extra.UrlUtil
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by brunodegan on 7/6/17.
 */
class CustomWebViewClient(val activity: MainActivity) : WebViewClient() {
	
	override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
		super.onPageStarted(view, url, favicon)
		activity.fl_page_load.visibility = View.VISIBLE
		UrlUtil.saveLastUrl(url)
	}
	
	@TargetApi(Build.VERSION_CODES.M)
	override fun onReceivedError(view: WebView?,
	                             request: WebResourceRequest?,
	                             error: WebResourceError?) {
		super.onReceivedError(view, request, error)
		
		activity.loadPage()
	}
	
	override fun onReceivedError(view: WebView?, errorCode: Int,
	                             description: String?,
	                             failingUrl: String?) {
		super.onReceivedError(view, errorCode, description, failingUrl)
		activity.loadPage()
	}
	
	@TargetApi(Build.VERSION_CODES.M)
	override fun onPageCommitVisible(view: WebView?, url: String?) {
		super.onPageCommitVisible(view, url)
		activity.fl_page_load.visibility = View.GONE
	}
	
	override fun onPageFinished(view: WebView?, url: String?) {
		super.onPageFinished(view, url)
		activity.fl_page_load.visibility = View.GONE
	}
	
	@TargetApi(Build.VERSION_CODES.N)
	override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?) = false
	
	@SuppressWarnings("deprecation")
	override fun shouldOverrideUrlLoading(view: WebView?, url: String?) = false
}