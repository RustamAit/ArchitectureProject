package kz.caremet.mentors.architectureproject.views.questions.viewModel.questionDetails

import io.reactivex.Observable
import kz.caremet.mentors.domain.models.Question

interface QuestionDetailsViewModel {
    fun getQuestion(uuid: String): Observable<Question>
}