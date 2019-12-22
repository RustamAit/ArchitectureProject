package kz.caremet.mentors.database.Entities

import androidx.room.PrimaryKey
import java.io.Serializable

@androidx.room.Entity
data class Person(
    @PrimaryKey val id: String,
    val entity_id: Int,
    val name: String,
    val type: String,
    val status: String,
    val avatar: String?,
    val avatar_placeholder_color: String,
    val email: String?,
    val phoneNumber: String?
): Serializable

fun Person.mapToPresent(): kz.caremet.mentors.domain.models.Person{
    return kz.caremet.mentors.domain.models.Person(
        id,
        entity_id,
        name,
        type,
        status,
        avatar,
        avatar_placeholder_color,
        email,
        phoneNumber
    )
}

fun kz.caremet.mentors.domain.models.Person.mapToDb(): Person{
    return Person(
        id, entity_id, name, type, status, avatar, avatar_placeholder_color, email, phoneNumber
    )
}