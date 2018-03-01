package ca.ottawacivictech.snaphole.views.ui


import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ca.ottawacivictech.snaphole.R
import java.io.File


/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val openCameraButton = view!!.findViewById<Button>(R.id.openCamera)

        openCameraButton.setOnClickListener{openCameraApp(activity.packageManager)}
    }

    fun openCameraApp(packageManager: PackageManager){
        val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val REQUEST_VALUE = resources.getInteger(R.integer.request_camera)
        Log.d("TEST", Integer.toString(REQUEST_VALUE))
        val imageUri = Uri.fromFile(File(Environment.getExternalStorageDirectory(), "snaphole_" +
                System.currentTimeMillis().toString() + ".jpg"))
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        if(takePhotoIntent.resolveActivity(packageManager) != null){
            startActivityForResult(takePhotoIntent,REQUEST_VALUE)
        }
    }



}// Required empty public constructor
