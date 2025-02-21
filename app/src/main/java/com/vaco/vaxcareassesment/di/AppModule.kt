package com.vaco.vaxcareassesment.di

import android.content.Context
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
object AppModule {
    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BookDatabase {
        return BookDatabase.getDatabase(context)
    }

    @Provides
    fun provideBookDao(database: BookDatabase): BookDAO {
        return database.bookDao()
    }

    @Provides
    fun provideBookRepository(apiInterface: ApiInterface,bookDao: BookDAO): BooksRepository {
        return BooksRepositoryImpl(apiInterface,bookDao)
    }
}