package aheat.jsonparsingexample.handler

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by aheat on 9/20/18.
 */
class ApiClient {

    val BASE_URL = "https://api.androidhive.info/contacts/"
    var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {

        val gson: Gson = GsonBuilder()
                .setLenient()
                .create()

        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build()
        }

        return retrofit
    }

}