package kz.caremet.mentors.architectureproject.views.questions.viewModel.questionDetails

import kz.caremet.mentors.data.repository.QuestionRepository

class QuestionDetailsViewModelImpl(val repository: QuestionRepository): QuestionDetailsViewModel {
    override fun getQuestion(uuid: String) = repository.getQuestion(uuid)
}