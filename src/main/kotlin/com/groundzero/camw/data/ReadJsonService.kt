package com.groundzero.camw.data

import com.groundzero.camw.utils.SerializationUtils
import org.springframework.stereotype.Component

@Component
class ReadJsonService(override val serialization: SerializationUtils) : ReadJson(serialization)