package com.groundzero.camw.features.adconfig.data

data class AdConfig(
        // Main screen top banner
        val showPrayerListTopBanner: Boolean = false,
        val showThoughtListTopBanner: Boolean = false,
        val showSaintListTopBanner: Boolean = false,
        val showQuizzesListTopBanner: Boolean = false,
        // Main screen bottom banner
        val showPrayerListBottomBanner: Boolean = false,
        val showThoughtListBottomBanner: Boolean = false,
        val showSaintListBottomBanner: Boolean = false,
        val showQuizzesListBottomBanner: Boolean = false,
        // Content reading top banner
        val showSinglePrayerTopBanner: Boolean = false,
        val showSingleThoughtTopBanner: Boolean = false,
        // Content reading bottom banner
        val showSinglePrayerBottomBanner: Boolean = false,
        val showSingleThoughtBottomBanner: Boolean = false,
        // Interstitial ad
        val showExitApplicationInterstitial: Boolean = false,
        val showRandomPrayerInterstitial: Boolean = false,
        val showPrayerListLayoutChangeInterstitial: Boolean = false,
        val showThoughtListLayoutChangeInterstitial: Boolean = false,
        val showAddPersonalPrayerInterstitial: Boolean = false,
        val showBookmarksInterstitial: Boolean = false,
        val showSearchPrayerListInterstitial: Boolean = false,
        val showSearchThoughtListInterstitial: Boolean = false,
        val showSearchSaintListInterstitial: Boolean = false,
        val showQuizFinishInterstitial: Boolean = false,
        // Support button interstitial ad
        val showSinglePrayerSupportByInterstitialAdButton: Boolean = false,
        val showSingleThoughtSupportByInterstitialAdButton: Boolean = false,
        val showSingleSaintSupportByInterstitialAdButton: Boolean = false,
        val showDrawerSupportByInterstitialAdButton: Boolean = false,
)