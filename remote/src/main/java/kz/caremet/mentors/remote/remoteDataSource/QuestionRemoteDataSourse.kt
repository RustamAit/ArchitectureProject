package kz.caremet.mentors.remote.remoteDataSource

import io.reactivex.Single
import kz.caremet.mentors.domain.models.Question

interface QuestionRemoteDataSourse {

    fun fetchData(): Single<List<Question>>

}