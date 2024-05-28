package com.fairoah.vkbotapi.model

data class EventDto(
    val group_id: Long?,
    val type: String?,
    val event_id: String?,
    val v: String?,
    val `object`: ObjectDto?
)

data class ObjectDto(
    val message: MessageDto?,
    val client_info: ClientInfoDto?,
    val state: String?,
    val from_id: Int?,
    val to_id: Int?,
    val date: Int?,
    val id: Int?,
    val out: Int?,
    val version: Int?,
    val attachments: List<Any>?,
    val read_message_id: Int?,
    val conversation_message_id: Int?,
    val fwd_messages: List<Any>?,
    val important: Boolean?,
    val is_hidden: Boolean?,
    val peer_id: Int?,
    val random_id: Int?,
    val text: String?,
    val is_mentioned_user: Boolean?
)

data class MessageDto(
    val date: Long?,
    val from_id: Int?,
    val id: Int?,
    val out: Int?,
    val version: Int?,
    val attachments: List<Any>?,
    val conversation_message_id: Int?,
    val fwd_messages: List<Any>?,
    val important: Boolean?,
    val is_hidden: Boolean?,
    val peer_id: Int?,
    val random_id: Int?,
    val text: String?,
    val is_mentioned_user: Boolean?
)

data class ClientInfoDto(
    val button_actions: List<String>?,
    val keyboard: Boolean?,
    val inline_keyboard: Boolean?,
    val carousel: Boolean?,
    val lang_id: Int?
)
