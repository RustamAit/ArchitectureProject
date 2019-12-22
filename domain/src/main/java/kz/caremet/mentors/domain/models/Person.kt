package kz.caremet.mentors.domain.models

import java.io.Serializable


data class Person(
    val id: String,
    val entity_id: Int,
    val name: String,
    val type: String,
    val status: String,
    val avatar: String?,
    val avatar_placeholder_color: String,
    val email: String?,
    val phoneNumber: String?
): Serializable