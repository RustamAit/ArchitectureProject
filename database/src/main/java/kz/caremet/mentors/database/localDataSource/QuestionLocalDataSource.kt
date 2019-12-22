package kz.caremet.mentors.database.localDataSource

import io.reactivex.Observable
import kz.caremet.mentors.domain.models.Question


interface QuestionLocalDataSource {

    fun getQuestions(): Observable<List<Question>>

    fun getQuestion(uuid: String): Observable<Question>

    fun upsertQuestion(question: Question)

}