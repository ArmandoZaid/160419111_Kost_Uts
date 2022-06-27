package com.ubaya.a160419111_kost_uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ubaya.a160419111_kost_uts.util.MIGRATION_1_2

@Database(entities = arrayOf(Kost::class), version = 2)
abstract class KostDatabase:RoomDatabase() {
    abstract fun todoDao():KostDao

    companion object{
        @Volatile private var instance: KostDatabase ? = null
        private val LOCK = Any()

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                KostDatabase::class.java,
                "newtododb")
                .addMigrations(MIGRATION_1_2)
                .build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}