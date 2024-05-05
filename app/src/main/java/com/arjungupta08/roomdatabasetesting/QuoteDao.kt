package com.arjungupta08.roomdatabasetesting

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote : Quote)

    @Query("SELECT * FROM QUOTE")
    fun getQuote() : LiveData<List<Quote>>

    @Query("SELECT * FROM QUOTE where id = :quoteId")
    suspend fun getQuoteById(quoteId : Int) : Quote

    @Update
    suspend fun update(quote: Quote)

    @Delete
    suspend fun delete()


}