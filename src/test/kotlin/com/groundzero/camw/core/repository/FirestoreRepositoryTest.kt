package com.groundzero.camw.core.repository

import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.core.service.FirestoreService
import com.groundzero.camw.features.thoughts.constants.ThoughtDataType
import com.groundzero.camw.features.thoughts.data.Thought
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class FirestoreRepositoryTest {

    @Mock
    private lateinit var firestoreService: FirestoreService

    @InjectMocks
    private lateinit var sut: FirestoreRepositoryImpl

    @Test
    fun `should invoke service addDocument once`() {
        sut.addDocument(MOCK_NETWORK_MODEL, MOCK_COLLECTION_KEY)
        verify(firestoreService).addDocument(MOCK_NETWORK_MODEL, MOCK_COLLECTION_KEY)
    }

    @Test
    fun `should invoke service removeDocument once`() {
        sut.removeDocument(MOCK_ITEM_ID, MOCK_COLLECTION_KEY)
        verify(firestoreService).removeDocument(MOCK_ITEM_ID, MOCK_COLLECTION_KEY)
    }

    private companion object {
        val MOCK_NETWORK_MODEL: NetworkModel = Thought()
        val MOCK_COLLECTION_KEY: String = ThoughtDataType.English.path
        const val MOCK_ITEM_ID: String = "a"
    }
}