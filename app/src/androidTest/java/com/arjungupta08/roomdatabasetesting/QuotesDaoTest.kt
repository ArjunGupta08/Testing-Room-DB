package com.arjungupta08.roomdatabasetesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuotesDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDao: QuoteDao

    // Setting up DB before every test case
    // This is not actual DB
    // This inMemory DB get closed on closing the application
    @Before
    fun setUp() {
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quoteDao = quoteDatabase.getQuoteDao()
    }

    @Test
    fun testInsertQuote_expectedSingleQuote() = runBlocking {
        val quote = Quote(0, "First Quote", "Quote Description")
        quoteDao.insertQuote(quote)

        val quoteData = quoteDao.getQuote().getOrAwaitValue()

        Assert.assertEquals(1, quoteData.size)
        Assert.assertEquals("First Quote", quoteData[0].text)
    }

    @Test
    fun deleteQuote_expectedNoResults() = runBlocking {
        val quote = Quote(0, "First Quote", "Quote Description")
        quoteDao.insertQuote(quote)
        quoteDao.delete()

        val quoteData = quoteDao.getQuote().getOrAwaitValue()

        Assert.assertEquals(0, quoteData.size)
    }

    @After
    fun tearDown() {
        quoteDatabase.close()
    }
}