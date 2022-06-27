package com.ubaya.a160419111_kost_uts.model

import androidx.room.*

@Dao
interface KostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg kost:Kost)

    @Query("SELECT * FROM kost ORDER BY priority DESC")
    suspend fun selectAllTodo(): List<Kost>

    @Query("SELECT * FROM kost WHERE uuid= :id")
    suspend fun selectTodo(id:Int): Kost

    @Delete
    suspend fun deleteTodo(todo:Kost)

    @Query("UPDATE kost SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
    suspend fun update(title:String, notes:String, priority:Int, id:Int)

    @Update
    suspend fun update(vararg todo: Kost)
}