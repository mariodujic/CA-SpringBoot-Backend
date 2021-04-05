package com.groundzero.camw.features.thoughts.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.thoughts.constants.ThoughtDataType
import com.groundzero.camw.features.thoughts.data.Thought
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/thoughts")
class ThoughtsContentController(
        contentRepository: BaseContentRepository<Thought>,
        contentValidator: BaseContentValidator
) : BaseContentController<Thought>(contentRepository, contentValidator) {

    @GetMapping("/en")
    fun getThoughtsEnglish() = getItemsResponse(ThoughtDataType.English)

    @GetMapping("/en-staging")
    fun getThoughtsEnglishStaging() = getItemsResponse(ThoughtDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getThoughtsCroatian() = getItemsResponse(ThoughtDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getThoughtsCroatianStaging() = getItemsResponse(ThoughtDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getThoughtsSlovak() = getItemsResponse(ThoughtDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getThoughtsSlovakStaging() = getItemsResponse(ThoughtDataType.SlovakStaging)

    @GetMapping("/es")
    fun getThoughtsSpanish() = getItemsResponse(ThoughtDataType.Spanish)

    @GetMapping("/es-staging")
    fun getThoughtsSpanishStaging() = getItemsResponse(ThoughtDataType.SpanishStaging)

    @DeleteMapping("/en")
    fun removeThoughtEnglish(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.English)

    @DeleteMapping("/en-staging")
    fun removeThoughtEnglishStaging(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removeThoughtCroatian(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removeThoughtCroatianStaging(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.CroatianStaging)

    @DeleteMapping("/sk")
    fun removeThoughtSlovak(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.Slovak)

    @DeleteMapping("/sk-staging")
    fun removeThoughtSlovakStaging(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.SlovakStaging)

    @DeleteMapping("/es")
    fun removeThoughtSpanish(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.Spanish)

    @DeleteMapping("/es-staging")
    fun removeThoughtSpanishStaging(@RequestBody thought: Thought) = removeItemResponse(thought, ThoughtDataType.SpanishStaging)

    @PostMapping("/en")
    fun addThoughtEnglish(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.English)

    @PostMapping("/en-staging")
    fun addThoughtEnglishStaging(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addThoughtCroatian(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addThoughtCroatianStaging(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.CroatianStaging)

    @PostMapping("/sk")
    fun addThoughtSlovak(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.Slovak)

    @PostMapping("/sk-staging")
    fun addThoughtSlovakStaging(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.SlovakStaging)

    @PostMapping("/es")
    fun addThoughtSpanish(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.Spanish)

    @PostMapping("/es-staging")
    fun addThoughtSpanishStaging(@RequestBody thought: Thought) = addItemResponse(thought, ThoughtDataType.SpanishStaging)
}