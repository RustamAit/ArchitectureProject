package kz.caremet.mentors.database.DAO

import androidx.room.*
import io.reactivex.Flowable
import io.reactivex.Observable
import kz.caremet.mentors.database.Entities.Person


@Dao
interface PersonDao{

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateSender(sender: Person)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSender(sender: Person):Long

    @Transaction
    fun upsertSender(sender: Person) {

        var isnR = insertSender(sender)

        if(isnR == (-1).toLong()){
            updateSender(sender)
        }


    }

    @Query("SELECT*FROM Person WHERE id = :id")
    fun getPersonFromDb(id: String): Person

}