package com.groundzero.camw.features.adconfig.data

import com.groundzero.camw.core.data.NetworkModel

data class AdConfig(
        // Main screen bottom banner
        val showPrayersListBottomBanner: Boolean = false,
        val showThoughtsListBottomBanner: Boolean = false,
        val showSaintsListBottomBanner: Boolean = false,
        val showQuizzesListBottomBanner: Boolean = false,
        // Content reading bottom banner
        val showSinglePrayerBottomBanner: Boolean = false,
        val showSingleThoughtBottomBanner: Boolean = false,
        // Interstitial ads
        val showExitApplicationInterstitial: Boolean = false
)