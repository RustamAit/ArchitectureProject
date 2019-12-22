package kz.caremet.mentors.data.repository

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kz.caremet.mentors.database.localDataSource.QuestionLocalDataSource
import kz.caremet.mentors.domain.models.Question
import kz.caremet.mentors.remote.remoteDataSource.QuestionRemoteDataSourse

class QuestionRepositoryImpl(private val questionLocalDataSource: QuestionLocalDataSource, private val questionRemoteDataSourse: QuestionRemoteDataSourse): QuestionRepository{


    override fun fetchData() {
        questionRemoteDataSourse.fetchData().subscribeOn(Schedulers.io()).flatMap {list ->  Observable.fromIterable(list).map {question ->  questionLocalDataSource.upsertQuestion(question) }.toList() }.subscribe()
    }

    override fun getQuestions(): Observable<List<Question>> = questionLocalDataSource.getQuestions()

    override fun getQuestion(uuid: String): Observable<Question> = questionLocalDataSource.getQuestion(uuid)


}