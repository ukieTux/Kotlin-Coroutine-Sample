package com.tuxdev.coroutines.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * *********************************************
 * Created by ukie on 9/26/18 with ♥
 * (>’_’)> email : ukie.tux@gmail.com
 * github : https://www.github.com/tuxkids <(’_’<)
 * *********************************************
 * © 2018 | All Right Reserved
 */
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {
    protected var toolbar: Toolbar? = null
    protected lateinit var bind: B

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        //TODO this for light statusbar theme
        /*if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }*/
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, getLayoutResource())
        if (getToolbarResource() != 0) {
            toolbar = findViewById(getToolbarResource())
            setSupportActionBar(toolbar)
            supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        //TODO Lock application to Portrait
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        myCodeHere()
    }

    protected abstract fun getToolbarResource(): Int
    protected abstract fun getLayoutResource(): Int
    protected abstract fun myCodeHere()

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }
}