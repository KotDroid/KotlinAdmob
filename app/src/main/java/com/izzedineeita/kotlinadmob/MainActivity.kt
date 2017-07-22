package com.izzedineeita.kotlinadmob

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*

class MainActivity : AppCompatActivity() {

    lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mNativeExpressAdView = findViewById(R.id.adView2) as NativeExpressAdView

        val request = AdRequest.Builder().build()
        mNativeExpressAdView.loadAd(request)


        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        mInterstitialAd.adListener = object : AdListener() {
            override fun onAdLoaded() {
                showInterstitialAd()
            }
        }

        val adView = findViewById(R.id.adview) as AdView
        val adRequest = AdRequest.Builder()
                .build()
        adView.loadAd(adRequest)

    }

    fun showInterstitialAd() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show();
        }
    }

}