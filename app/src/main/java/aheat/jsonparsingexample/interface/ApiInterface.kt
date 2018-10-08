package aheat.jsonparsingexample.`interface`

import aheat.jsonparsingexample.model.ContactsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by aheat on 9/22/18.
 */
interface ApiInterface {

    @GET(".")
    fun getContacts(): Call<ContactsResponse>

    companion object {

    }

}