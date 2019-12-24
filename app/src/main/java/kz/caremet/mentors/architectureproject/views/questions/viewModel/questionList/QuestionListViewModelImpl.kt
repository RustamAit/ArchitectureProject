package kz.caremet.mentors.architectureproject.views.questions.viewModel.questionList

import io.reactivex.Observable
import kz.caremet.mentors.data.repository.QuestionRepository
import kz.caremet.mentors.domain.models.Question

class QuestionListViewModelImpl(val repository: QuestionRepository) : QuestionListViewModel {
    override fun getQuestionList(): Observable<List<Question>> {
        return repository.getQuestions()
    }
}