package com.example.module

import com.example.domain.repo.Repository
import com.example.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DomainModule {
    @Provides
    @Singleton
    fun provideUseCase(repository: Repository) = GetProductsUseCase(repository)
}

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepoModule {
//    @Provides
//    @Singleton
//    abstract fun noteRepository() : Repository
//}
