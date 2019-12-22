package kz.caremet.mentors.architectureproject.di.remote

import kz.caremet.mentors.remote.remoteDataSource.QuestionRemoteDataSourse
import kz.caremet.mentors.remote.dataSource.QuestionRemoteDataSourceImpl
import kz.caremet.mentors.remote.services.QuestionService
import kz.caremet.mentors.remote.services.createService
import org.koin.dsl.module

val questionRemoteModule = module {
    single { createService<QuestionService>(get(), "https://qa.pbo.kz/") }
    single { QuestionRemoteDataSourceImpl(get()) as QuestionRemoteDataSourse}
}