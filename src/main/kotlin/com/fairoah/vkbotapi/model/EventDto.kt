package com.fairoah.vkbotapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class EventDto(
    @JsonProperty("group_id") val groupId: Long,
    @JsonProperty("type") val type: String,
    @JsonProperty("event_id") val eventId: String?,
    @JsonProperty("v") val v: String,
    @JsonProperty("object") val `object`: ObjectDto
)

data class ObjectDto(
    @JsonProperty("message") val message: MessageDto?,
    @JsonProperty("client_info") val clientInfo: ClientInfoDto?,
    @JsonProperty("state") val state: String?,
    @JsonProperty("from_id") val fromId: Int?,
    @JsonProperty("to_id") val toId: Int?,
    @JsonProperty("date") val date: Int?,
    @JsonProperty("id") val id: Int?,
    @JsonProperty("out") val out: Int?,
    @JsonProperty("version") val version: Int?,
    @JsonProperty("attachments") val attachments: List<Any>?,
    @JsonProperty("read_message_id") val readMessageId: Int?,
    @JsonProperty("conversation_message_id") val conversationMessageId: Int?,
    @JsonProperty("fwd_messages") val fwdMessages: List<Any>?,
    @JsonProperty("important") val important: Boolean?,
    @JsonProperty("is_hidden") val isHidden: Boolean?,
    @JsonProperty("peer_id") val peerId: Int?,
    @JsonProperty("random_id") val randomId: Int?,
    @JsonProperty("text") val text: String?,
    @JsonProperty("is_mentioned_user") val isMentionedUser: Boolean?
)

data class MessageDto(
    @JsonProperty("date") val date: Long?,
    @JsonProperty("from_id") val fromId: Int?,
    @JsonProperty("id") val id: Int?,
    @JsonProperty("out") val out: Int?,
    @JsonProperty("version") val version: Int?,
    @JsonProperty("attachments") val attachments: List<Any>?,
    @JsonProperty("conversation_message_id") val conversationMessageId: Int?,
    @JsonProperty("fwd_messages") val fwdMessages: List<Any>?,
    @JsonProperty("important") val important: Boolean?,
    @JsonProperty("is_hidden") val isHidden: Boolean?,
    @JsonProperty("peer_id") val peerId: Int?,
    @JsonProperty("random_id") val randomId: Int?,
    @JsonProperty("text") val text: String?,
    @JsonProperty("is_mentioned_user") val isMentionedUser: Boolean?
)

data class ClientInfoDto(
    @JsonProperty("button_actions") val buttonActions: List<String>?,
    @JsonProperty("keyboard") val keyboard: Boolean?,
    @JsonProperty("inline_keyboard") val inlineKeyboard: Boolean?,
    @JsonProperty("carousel") val carousel: Boolean?,
    @JsonProperty("lang_id") val langId: Int?
)
