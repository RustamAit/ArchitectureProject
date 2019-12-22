package kz.caremet.mentors.architectureproject

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.caremet.mentors.database.DAO.PersonDao
import kz.caremet.mentors.database.DAO.QuestionDao
import kz.caremet.mentors.database.Entities.Person
import kz.caremet.mentors.database.Entities.QuestionFromDB
import kz.caremet.mentors.database.Entities.Status


@Database(entities = arrayOf(QuestionFromDB::class, Person::class, Status::class), version = 3)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getQuestionDao(): QuestionDao
    abstract fun getPersonDao(): PersonDao
}