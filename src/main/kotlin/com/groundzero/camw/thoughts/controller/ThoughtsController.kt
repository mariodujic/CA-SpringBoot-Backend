package com.groundzero.camw.thoughts.controller

import com.groundzero.camw.data.DataType
import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.thoughts.constants.ThoughtDataType
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.thoughts.data.ThoughtsRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/thoughts")
class ThoughtsController(private val repository: ThoughtsRepository) {

    @GetMapping("/en")
    fun getThoughtsEnglish() = getThoughtsResponse(ThoughtDataType.English())

    @GetMapping("/en-staging")
    fun getThoughtsEnglishStaging() = getThoughtsResponse(ThoughtDataType.EnglishStaging())

    @GetMapping("/hr")
    fun getThoughtsCroatian() = getThoughtsResponse(ThoughtDataType.Croatian())

    @GetMapping("/hr-staging")
    fun getThoughtsCroatianStaging() = getThoughtsResponse(ThoughtDataType.CroatianStaging())

    private fun getThoughtsResponse(type: DataType): NetworkResponse {
        repository.getThoughts(type)?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @DeleteMapping("/en")
    fun removeThoughtEnglish(@RequestBody thought: Thought) = deleteThoughtResponse(thought, ThoughtDataType.English())

    @DeleteMapping("/en-staging")
    fun removeThoughtEnglishStaging(@RequestBody thought: Thought) = deleteThoughtResponse(thought, ThoughtDataType.EnglishStaging())

    @DeleteMapping("/hr")
    fun removeThoughtCroatian(@RequestBody thought: Thought) = deleteThoughtResponse(thought, ThoughtDataType.Croatian())

    @DeleteMapping("/hr-staging")
    fun removeThoughtCroatianStaging(@RequestBody thought: Thought) = deleteThoughtResponse(thought, ThoughtDataType.CroatianStaging())

    private fun deleteThoughtResponse(@RequestBody thought: Thought, type: DataType): NetworkResponse {
        repository.removeThought(thought, type)
        return NetworkResponse.Success<Thought>(200, "Success", mutableListOf())
    }

    @PostMapping("/en")
    fun addThoughtEnglish(@RequestBody thought: Thought) = addThoughtResponse(thought, ThoughtDataType.English())

    @PostMapping("/en-staging")
    fun addThoughtEnglishStaging(@RequestBody thought: Thought) = addThoughtResponse(thought, ThoughtDataType.EnglishStaging())

    @PostMapping("/hr")
    fun addThoughtCroatian(@RequestBody thought: Thought) = addThoughtResponse(thought, ThoughtDataType.Croatian())

    @PostMapping("/hr-staging")
    fun addThoughtCroatianStaging(@RequestBody thought: Thought) = addThoughtResponse(thought, ThoughtDataType.CroatianStaging())

    private fun addThoughtResponse(thought: Thought, type: DataType): NetworkResponse {
        repository.addThought(thought, type)
        return NetworkResponse.Success<Thought>(200, "Success", mutableListOf())
    }
}