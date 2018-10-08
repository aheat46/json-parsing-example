package aheat.jsonparsingexample.activity

import aheat.jsonparsingexample.R
import aheat.jsonparsingexample.model.Phone
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

/**
 * Created by aheat on 10/1/18.
 */
class DetailActivity: AppCompatActivity() {

    var name: TextView? = null
    var address: TextView? = null
    var email: TextView? = null
    var gender: TextView? = null
    var mobile: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        name = findViewById(R.id.name)
        address = findViewById(R.id.address)
        email = findViewById(R.id.email)
        gender = findViewById(R.id.gender)
        mobile = findViewById(R.id.phone_number)

        val _name = intent.extras.getString("name")
        val _address = intent.extras.getString("address")
        val _email = intent.extras.getString("email")
        val _gender = intent.extras.getString("gender")
        val _mobile = intent.extras.getString("number")

        name!!.setText(_name)
        address!!.setText(_address)
        email!!.setText(_email)
        gender!!.setText(_gender)
        mobile!!.setText(_mobile)


    }
}