package kz.caremet.mentors.database.dataSource

import io.reactivex.Observable
import kz.caremet.mentors.domain.models.Question
import kz.caremet.mentors.database.DAO.PersonDao
import kz.caremet.mentors.database.DAO.QuestionDao
import kz.caremet.mentors.database.Entities.mapToDb
import kz.caremet.mentors.database.Entities.mapToPresent
import kz.caremet.mentors.database.localDataSource.QuestionLocalDataSource

class QuestionLocalDataSourceImpl(private val questionDao: QuestionDao,private val personDao: PersonDao): QuestionLocalDataSource {
    override fun getQuestions(): Observable<List<Question>> {
        return questionDao.getQuestions().map {
            val questionList = ArrayList<Question>()
            it.forEach { questionFromDB ->
                val person = personDao.getPersonFromDb(questionFromDB.sender_id)
                questionList.add(
                    Question(
                        questionFromDB.uuid,
                        questionFromDB.id,
                        questionFromDB.text,
                        questionFromDB.status.mapToPresent(),
                        questionFromDB.answer_count,
                        questionFromDB.created_at,
                        person.mapToPresent(),
                        questionFromDB.pending_read,
                        questionFromDB.numberOfUnreadedAnswers
                    )
                )
            }
            return@map questionList
        }
    }

    override fun getQuestion(uuid: String): Observable<Question> {
        return questionDao.getQuestion(uuid).map {questionFromDB ->
            val person = personDao.getPersonFromDb(questionFromDB.sender_id)
            return@map Question(
                questionFromDB.uuid,
                questionFromDB.id,
                questionFromDB.text,
                questionFromDB.status.mapToPresent(),
                questionFromDB.answer_count,
                questionFromDB.created_at,
                person.mapToPresent(),
                questionFromDB.pending_read,
                questionFromDB.numberOfUnreadedAnswers
            )
        }
    }


    override fun upsertQuestion(question: Question) {
        questionDao.upsertQuestion(question.mapToDb())
        personDao.upsertSender(question.sender.mapToDb())
    }

}