package kz.caremet.mentors.architectureproject.views.questions.viewModel.questions.questionActivity

import kz.caremet.mentors.data.repository.QuestionRepository

class QuestionActivityViewModelImpl(val repository: QuestionRepository) : QuestionActivityViewModel {

    override fun fetchData() = repository.fetchData()

}