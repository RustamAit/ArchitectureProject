package kz.caremet.mentors.architectureproject.di.view
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questionDetails.QuestionDetailsViewModel
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questionDetails.QuestionDetailsViewModelImpl
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questionList.QuestionListViewModel
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questionList.QuestionListViewModelImpl
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questions.questionActivity.QuestionActivityViewModel
import kz.caremet.mentors.architectureproject.views.questions.viewModel.questions.questionActivity.QuestionActivityViewModelImpl
import org.koin.dsl.module

val questionModule = module{
    single { QuestionActivityViewModelImpl(get()) as QuestionActivityViewModel }
    single { QuestionDetailsViewModelImpl(get()) as QuestionDetailsViewModel }
    single { QuestionListViewModelImpl(get()) as QuestionListViewModel }
}