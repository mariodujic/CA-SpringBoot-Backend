package com.groundzero.camw.features.adconfig.data

data class AdConfig(
        // Main screen bottom banner
        val showPrayerListBottomBanner: Boolean = false,
        val showThoughtListBottomBanner: Boolean = false,
        val showSaintListBottomBanner: Boolean = false,
        val showQuizzesListBottomBanner: Boolean = false,
        // Content reading bottom banner
        val showSinglePrayerBottomBanner: Boolean = false,
        val showSingleThoughtBottomBanner: Boolean = false,
        // Interstitial ads
        val showExitApplicationInterstitial: Boolean = false
)