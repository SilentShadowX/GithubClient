package com.kpiega.githubclient.dialog

import android.app.Dialog
import android.app.DialogFragment
import android.app.FragmentManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.kpiega.githubclient.R
import com.kpiega.githubclient.data.model.UserDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_user_details.*

class UserDetailsDialog constructor(var details: UserDetails) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.dialog_user_details, container, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.attributes
        return dialog
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.with(view?.context).load(details.avatar).into(userImg)

        userLogin.text = "Login: ${details.login}"

        if (!details.email.isNullOrEmpty()) {
            userEmail.text = "Email: ${details.email}"
        } else {
            userEmail.text = "Email: empty :)"
        }

        if(!details.location.isNullOrEmpty()) {
            userLocation.text = "Location: ${details.location}"
        } else {
            userLocation.text = "Location: empty :) "
        }
    }

    companion object {
        fun showDialog(circle: UserDetails, fm: FragmentManager) {
            val circleDialog = UserDetailsDialog(circle)
            circleDialog.show(fm, null)
        }
    }
}