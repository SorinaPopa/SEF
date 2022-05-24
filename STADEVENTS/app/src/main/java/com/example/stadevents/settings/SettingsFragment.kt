package com.example.stadevents.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.example.stadevents.R
import com.example.stadevents.login.LoginActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val frameLayout: FrameLayout =
            inflater.inflate(R.layout.settings_fragment, container, false) as FrameLayout

        //help Button
        val help: Button = frameLayout.findViewById(R.id.help)
        help.setOnClickListener(){
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.help))
                .setMessage(resources.getString(R.string.help_message))
                .setNegativeButton(resources.getString(R.string.close)) { dialog, which ->
                    // Respond to negative button press
                }
                .show()
        }

        //aboutUs Button
        val aboutUsButton: Button = frameLayout.findViewById(R.id.aboutUs)
        aboutUsButton.setOnClickListener() {
            val uri: Uri =
                Uri.parse("https://docs.google.com/document/d/1y3zjEaym6cxBmqID8pS_jAN6VqgonNBtmdlxi_vhgXU/edit?usp=sharing")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        //share Button
        val shareButton: Button = frameLayout.findViewById(R.id.share)
        shareButton.setOnClickListener() {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Check out my new app, STADEVENTS! https://docs.google.com/document/d/1y3zjEaym6cxBmqID8pS_jAN6VqgonNBtmdlxi_vhgXU/edit?usp=sharing"
                )
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        //SignOut Button
        val signOutButton: Button = frameLayout.findViewById(R.id.signOut)
        signOutButton.setOnClickListener(){
            val intent =Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return frameLayout
    }

}