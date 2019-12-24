package kz.caremet.mentors.architectureproject.views.questions.viewModel.questionList

import io.reactivex.Observable
import kz.caremet.mentors.domain.models.Question


interface QuestionListViewModel {
    fun getQuestionList() : Observable<List<Question>>
}