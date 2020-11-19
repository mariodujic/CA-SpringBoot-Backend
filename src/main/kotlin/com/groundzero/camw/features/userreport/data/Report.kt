package com.groundzero.camw.features.userreport.data

import com.groundzero.camw.core.data.NetworkModel

sealed class Report {
    data class ContentBug(val item: NetworkModel, val message: String) : Report()
    class Suggestion(val message: String) : Report()
}