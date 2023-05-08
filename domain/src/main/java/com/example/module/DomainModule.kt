package com.example.module

import com.example.domain.repo.Repository
import com.example.domain.usecase.GetAllAmberUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DomainModule {
    @Provides
    @Singleton
    fun provideUseCase(repository: Repository) = GetAllAmberUseCase(repository)
}

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepoModule {
//    @Provides
//    @Singleton
//    abstract fun noteRepository() : Repository
//}
