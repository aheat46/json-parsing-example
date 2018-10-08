package aheat.jsonparsingexample.adapter

import aheat.jsonparsingexample.R
import aheat.jsonparsingexample.activity.DetailActivity
import aheat.jsonparsingexample.model.Contacts
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by aheat on 9/20/18.
 */
class CustomAdapter: BaseAdapter {

    val activity: Activity
    var contactList: List<Contacts>

    var name: TextView? = null
    var email: TextView? = null
    var phone: TextView?  = null

    constructor(activity: Activity, contactList: List<Contacts>) {
        this.activity = activity
        this.contactList = contactList
    }

    override fun getItem(position: Int): Any {
        return contactList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return contactList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = LayoutInflater.from(activity).inflate(R.layout.list_item, parent, false)

        name = view.findViewById(R.id.name)
        email = view.findViewById(R.id.email)
        phone = view.findViewById(R.id.phone_number)

        name!!.setText(contactList.get(position).getNames())
        email!!.setText(contactList.get(position).getEmails())

        val data = contactList.get(position)

        view.setOnClickListener{
            openDetailActivity(data.id!!, data.name!!, data.email!!, data.address!!, data.gender!!, data.mobile!!.toString())
        }

        return view
    }

    private fun openDetailActivity(vararg datas: String) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("id", datas[0])
        intent.putExtra("name", datas[1])
        intent.putExtra("email", datas[2])
        intent.putExtra("address", datas[3])
        intent.putExtra("gender", datas[4])
        intent.putExtra("number", datas[5])
        activity.startActivity(intent)
    }
}