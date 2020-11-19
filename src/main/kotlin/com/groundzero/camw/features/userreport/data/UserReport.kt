package com.groundzero.camw.features.userreport.data

import com.groundzero.camw.core.data.NetworkModel

data class UserReport(
        override val itemId: String?,
        val item: NetworkModel,
        val report: Report
) : NetworkModel