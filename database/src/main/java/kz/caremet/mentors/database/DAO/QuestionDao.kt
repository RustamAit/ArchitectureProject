package kz.caremet.mentors.database.DAO

import androidx.room.*
import io.reactivex.Observable
import kz.caremet.mentors.database.Entities.QuestionFromDB

@Dao
interface QuestionDao{


    @Update
    fun updateQuestion(entity: QuestionFromDB)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertQuestion(entity: QuestionFromDB): Long

    @Transaction
    fun upsertQuestion(entity: QuestionFromDB) {

        val isnR = insertQuestion(entity)
        if(isnR == (-1).toLong()){
            updateQuestion(entity)
        }
    }


    @Query("SELECT * FROM questionFromDb")
    fun getQuestions(): Observable<List<QuestionFromDB>>

    @Query("SELECT * FROM questionfromdb WHERE uuid=:uuid")
    fun getQuestion(uuid: String): Observable<QuestionFromDB>

}