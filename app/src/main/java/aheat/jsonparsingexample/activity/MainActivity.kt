package aheat.jsonparsingexample.activity

import aheat.jsonparsingexample.R
import aheat.jsonparsingexample.`interface`.ApiInterface
import aheat.jsonparsingexample.adapter.CustomAdapter
import aheat.jsonparsingexample.handler.ApiClient
import aheat.jsonparsingexample.model.ContactsResponse
import aheat.jsonparsingexample.model.Contacts
import aheat.jsonparsingexample.model.Phone
import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    var lisview: ListView? = null
    var adapter: Adapter? = null
    lateinit var pDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DisplayProgressDialog()

        lisview = findViewById(R.id.listview)

        passDataContact()

    }

    private fun passDataContact() {

        val apiClinet = ApiClient()
        val apis: ApiInterface = apiClinet.getApiClient()!!.create(ApiInterface::class.java)

        val call: Call<ContactsResponse> = apis.getContacts()

        call.enqueue(object: Callback<ContactsResponse>{

            override fun onResponse(call: Call<ContactsResponse>?, response: Response<ContactsResponse>?) {

                val contactList = ArrayList<Contacts>()

                val list: List<Contacts> = response!!.body()!!.getContacts()

                for (i in list) {

                    val index = list.indexOf(i)

                    val contact = Contacts()
                    val numbers: Phone = list.get(index).getPhones()

                    contact.setIds(i.getIds())
                    contact.setNames(i.getNames())
                    contact.setEmails(i.getEmails())
                    contact.setAddres(i.getAddres())
                    contact.setGenders(i.getGenders())
                    contact.setMobiles(numbers.getMobiles())

                    contactList.add(contact)
                }

                adapter = CustomAdapter(this@MainActivity, contactList)
                lisview!!.adapter = adapter as CustomAdapter

                pDialog.dismiss()

            }

            override fun onFailure(call: Call<ContactsResponse>?, t: Throwable?) {
                if (pDialog != null && pDialog.isShowing) {
                    pDialog.dismiss()
                }
                Log.d("TAG", "error "+ t!!.message)
            }

        })

    }

    fun DisplayProgressDialog() {
        pDialog = ProgressDialog(this@MainActivity)
        pDialog.setMessage("Loading...")
        pDialog.setCancelable(false)
        pDialog.isIndeterminate = false
        pDialog.show()
    }

}
