package com.example.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    fun provideEngine(piston: Piston): Engine{
        return Engine(piston)
    }

    @Provides
    fun provideCar(engine: Engine, @Six number: Int): Car{
        return Car(engine, number)
    }

    @Provides
    fun providePiston(numberOfPistion: NumberOfPistion): Piston{
        return Piston(numberOfPistion)
    }

    @Provides
    fun provideNumberOfPiston(): NumberOfPistion{
        return NumberOfPistionImpl()
    }

    @Provides
    @Four
    fun provideFourInt(): Int{
        return 4
    }

    @Provides
    @Six
    fun provideSixInt(): Int{
        return 6
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Four

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Six