package com.example.pdfparser

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface ApiService {
    @Multipart
    @POST("nlm/api/parseDocument")
    suspend fun parseDocument(
        @Part file: MultipartBody.Part,
        @Query("renderFormat") renderFormat: String = "all"
    ): Response<String>
}
