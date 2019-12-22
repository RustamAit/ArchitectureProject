package kz.caremet.mentors.architectureproject.di.data

import kz.caremet.mentors.data.repository.QuestionRepository
import kz.caremet.mentors.data.repository.QuestionRepositoryImpl
import org.koin.dsl.module


val questionDataModule = module {
    single { QuestionRepositoryImpl(get(), get()) as QuestionRepository }
}