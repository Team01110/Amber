package di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import local.AmberDao
import local.AppDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import service.ApiService


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun AmberApi(): ApiService {
        return Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun appDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "Amber-db"
    ).build()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("isShow", Context.MODE_PRIVATE)
    }

    @Provides
    fun amberDao(appDatabase: AppDatabase): AmberDao = appDatabase.amberDao()
}