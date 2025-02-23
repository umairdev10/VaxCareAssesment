package com.vaco.vaxcareassesment

import android.content.Context
import androidx.room.Room
import com.vaco.vaxcareassesment.data.local.BookDAO
import com.vaco.vaxcareassesment.data.local.BookDatabase
import com.vaco.vaxcareassesment.data.remote.ApiInterface
import com.vaco.vaxcareassesment.data.repository.BooksRepositoryImpl
import com.vaco.vaxcareassesment.domain.repository.BooksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Provides
    @Singleton
    fun provideFakeApiInterface(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BookDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            BookDatabase::class.java
        ).build()
    }

    @Provides
    fun provideFakeBookDao(database: BookDatabase): BookDAO {
        return database.bookDao()
    }

    @Provides
    fun provideFakeBookRepository(): BooksRepository {
        return FakeBookRepositoryImpl()
    }
}