package aheat.jsonparsingexample.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call

/**
 * Created by aheat on 9/23/18.
 */
class ContactsResponse {

    @SerializedName("contacts")
    private var contacts: List<Contacts>? = ArrayList<Contacts>()


    private fun setContacts(contacts: List<Contacts>) {
        this.contacts= contacts
    }

    fun getContacts(): List<Contacts> {
        return contacts!!
    }

//    fun getNumbers(): Call<List<Contacts>> {
//        return
//    }


}