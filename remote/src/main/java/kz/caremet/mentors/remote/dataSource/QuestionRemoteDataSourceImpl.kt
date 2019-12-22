package kz.caremet.mentors.remote.dataSource

import io.reactivex.Completable
import kz.caremet.mentors.remote.remoteDataSource.QuestionRemoteDataSourse
import kz.caremet.mentors.remote.services.QuestionService

class QuestionRemoteDataSourceImpl(private val service: QuestionService): QuestionRemoteDataSourse {

    override fun fetchData() = service.getQuestions("Bearer hlSW-aQskBhA-aTBDDR37rhQGYQQJ59H3NWHurw208c", 133)

}