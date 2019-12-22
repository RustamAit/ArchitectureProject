package kz.caremet.mentors.architectureproject.di

import androidx.room.Room
import kz.caremet.mentors.architectureproject.AppDatabase
import kz.caremet.mentors.architectureproject.di.data.questionDataModule
import kz.caremet.mentors.architectureproject.di.database.questionDbModule
import kz.caremet.mentors.architectureproject.di.remote.questionRemoteModule
import kz.caremet.mentors.architectureproject.utils.LoggerImpl
import kz.caremet.mentors.remote.services.Logger
import kz.caremet.mentors.remote.services.createOkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single( definition = {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "module-database").fallbackToDestructiveMigration()
            .build()
    })

    single { LoggerImpl() as Logger }

    single { createOkHttpClient(get()) }


}


val appModules = listOf(appModule,  questionRemoteModule, questionDbModule, questionDataModule)