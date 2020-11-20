package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.core.repository.FirestoreRepository
import org.springframework.web.bind.annotation.RequestBody

open class BaseContentControllerWithFirestore<T : NetworkModel>(
        baseContentRepository: BaseContentRepository<T>,
        baseContentValidator: BaseContentValidator,
        private val firestoreRepository: FirestoreRepository
) : BaseContentController<T>(baseContentRepository, baseContentValidator) {

    override fun addItemResponse(item: T, type: DataType): NetworkResponse {
        item.itemId?.let {
            firestoreRepository.addDocument(item, type.path)
        }
        return super.addItemResponse(item, type)
    }

    override fun removeItemResponse(@RequestBody item: T, type: DataType): NetworkResponse {
        item.itemId?.let {
            firestoreRepository.removeDocument(it, type.path)
        }
        return super.removeItemResponse(item, type)
    }
}