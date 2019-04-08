package com.badarau.adrian.testingspringboot.web.controllers

import com.badarau.adrian.testingspringboot.services.BeerService
import com.badarau.adrian.testingspringboot.web.model.BeerDto
import com.badarau.adrian.testingspringboot.web.model.BeerStyleEnum
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.*
import org.mockito.BDDMockito
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class BeerOrderControllerTest{

    @Mock
    lateinit var beerService: BeerService

    @InjectMocks
    lateinit var beerController: BeerController

    lateinit var mockMvc: MockMvc

    val validBeer:BeerDto = BeerDto(
            UUID.randomUUID(),
            1,
            OffsetDateTime.now(),
            OffsetDateTime.now(),
            "Valid Test BREW",
            BeerStyleEnum.PALE_ALE,
            123456789012L,
            4,
            BigDecimal(12.99)
    )

    @BeforeEach
    internal fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(beerController).build()
    }

    @Test
    fun testGetBeerById(){

    }
}
