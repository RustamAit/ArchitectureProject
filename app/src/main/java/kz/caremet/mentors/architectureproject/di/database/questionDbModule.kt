package kz.caremet.mentors.architectureproject.di.database

import kz.caremet.mentors.architectureproject.AppDatabase
import kz.caremet.mentors.database.localDataSource.QuestionLocalDataSource
import kz.caremet.mentors.database.dataSource.QuestionLocalDataSourceImpl
import org.koin.dsl.module

val questionDbModule = module {

    single { get<AppDatabase>().getQuestionDao() }
    single { get<AppDatabase>().getPersonDao() }
    single { QuestionLocalDataSourceImpl(get(),get()) as QuestionLocalDataSource }


}