package kz.caremet.mentors.data.repository

import io.reactivex.Observable
import kz.caremet.mentors.domain.models.Question


interface QuestionRepository {

    fun fetchData()

    fun getQuestions(): Observable<List<Question>>

    fun getQuestion(uuid: String): Observable<Question>

}