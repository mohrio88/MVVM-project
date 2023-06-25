package com.mvvm

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class AppViewModel : BaseObservable() {
    // creating object of Model class
    private val model: Model = Model("", "")

    // string variables for
    // toast messages
    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    // getter and setter methods
    // for toast message

    // string variable for
    // toast message
    @get:Bindable
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }

    // getter and setter methods
    // for email variable
    @get:Bindable
    var userEmail: String?
        get() = model.email
        set(email) {
            //model.setEmail(email)
            model.email = email
            notifyPropertyChanged(BR.userEmail)
        }

    // getter and setter methods
    // for password variable
    @get:Bindable
    var userPassword: String?
        get() = model.password
        set(password) {
            //model.setPassword(password)
            model.password = password
            notifyPropertyChanged(BR.userPassword)
        }

    // constructor of ViewModel class
    init {

        // instantiating object of
        // model class
    }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    fun onButtonClicked() {
        if (isValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    private val isValid: Boolean
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail.toString())
            .matches() && userPassword!!.length > 5
}