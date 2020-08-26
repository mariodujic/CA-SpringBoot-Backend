package com.groundzero.camw.data

import org.springframework.stereotype.Component

@Component
class ReadNetworkService(val firebaseDatabase: FirebaseDatabase) : WriteJson(firebaseDatabase)