package com.example.pdfparser

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.pdfparser.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val PICK_PDF_REQUEST = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpload.setOnClickListener {
            pickPdfFile()
        }
    }

    private fun pickPdfFile() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "application/pdf"
        startActivityForResult(Intent.createChooser(intent, "Select PDF"), PICK_PDF_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PDF_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                uploadFile(uri)
            }
        }
    }

    private fun uploadFile(uri: Uri) {
        lifecycleScope.launch {
            try {
                val file = copyToTempFile(uri)
                val requestFile = file.asRequestBody("application/pdf".toMediaTypeOrNull())
                val body = MultipartBody.Part.createFormData("file", file.name, requestFile)

                val response: Response<String> = withContext(Dispatchers.IO) {
                    ApiClient.apiService.parseDocument(body)
                }

                if (response.isSuccessful) {
                    val text = response.body() ?: "Empty Response"
                    binding.tvOutput.append("\n\n📄 File: ${file.name}\n$text\n----------------------\n")
                } else {
                    binding.tvOutput.append("\n❌ Error: ${response.code()} - ${response.message()}\n")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                binding.tvOutput.append("\n⚠️ Failed: ${e.message}\n")
            }
        }
    }

    private fun copyToTempFile(uri: Uri): File {
        val inputStream = contentResolver.openInputStream(uri)!!
        val tempFile = File(cacheDir, "upload_${System.currentTimeMillis()}.pdf")
        FileOutputStream(tempFile).use { output ->
            inputStream.copyTo(output)
        }
        return tempFile
    }
}
