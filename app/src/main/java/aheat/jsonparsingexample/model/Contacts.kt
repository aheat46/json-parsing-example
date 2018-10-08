package aheat.jsonparsingexample.model

import com.google.gson.annotations.SerializedName

/**
 * Created by aheat on 9/22/18.
 */
class Contacts {

    var id: String? = null
    var name: String? = null
    var email: String? = null
    var address: String? = null
    var gender: String? = null
    var phone: Phone? = null
    var mobile: String? = null
    var home: String? = null
    var office: String? = null


    fun getIds(): String {
        return id!!
    }

    fun setIds(id: String) {
        this.id = id
    }

    fun getNames(): String {
        return name!!
    }

    fun setNames(name: String) {
        this.name = name
    }

    fun getEmails(): String {
        return email!!
    }

    fun setEmails(email: String) {
        this.email = email
    }

    fun getAddres(): String {
        return address!!
    }

    fun setAddres(address: String) {
        this.address = address
    }

    fun getGenders(): String {
        return gender!!
    }

    fun setGenders(gender: String) {
        this.gender = gender
    }

    fun getPhones(): Phone {
        return phone!!
    }

    fun setMobiles(mobile: String) {
        this.mobile = mobile
    }

    fun setHomes(home: String) {
        this.home = home
    }

    fun setOffices(office: String) {
        this.office = office
    }


}

class Phone {

    var mobile: String? = null
    var home: String? = null
    var office: String? = null

    fun getMobiles(): String {
        return mobile!!
    }

    fun getHomes(): String {
        return home!!
    }

    fun getOffices(): String {
        return office!!
    }

}