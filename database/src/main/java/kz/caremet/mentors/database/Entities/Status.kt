package kz.caremet.mentors.database.Entities

import androidx.room.PrimaryKey
import java.io.Serializable

@androidx.room.Entity
data class Status(
    @PrimaryKey val status_name: String,
    val color: String): Serializable

fun Status.mapToPresent(): kz.caremet.mentors.domain.models.Status{
    return kz.caremet.mentors.domain.models.Status(status_name,color)
}

fun kz.caremet.mentors.domain.models.Status.mapToDb(): Status{
    return Status(
        name, color
    )
}