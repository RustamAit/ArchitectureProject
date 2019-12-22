package kz.caremet.mentors.database.Entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kz.caremet.mentors.domain.models.Question
import java.io.Serializable

@Entity
data class QuestionFromDB(
    @PrimaryKey val uuid: String,
    val id: Int?,
    val text: String,
    @Embedded val status: Status,
    val answer_count: Int,
    val created_at: String,
    val sender_id: String,
    val numberOfDocuments: Int,
    var pending_read: Boolean,
    val numberOfUnreadedAnswers:Int,
    val task_count: Int?,
    val checkedCheckListCount: Int?,
    val checkListCount: Int?
): Serializable


fun Question.mapToDb(): QuestionFromDB{
    return QuestionFromDB(
        uuid?:id.toString(),
        id,
        text,
        status.mapToDb(),
        answer_count,
        created_at,
        sender.id,
        3,
        pending_read,
        0,
        0,
        0,
    0
    )
}