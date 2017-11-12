package com.example.fran.intents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pgWeb(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://campus.somtic.net/"))
        startActivity(intent)
    }

    fun llamadaTelefono(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:966870700"))
                startActivity(intent)
            }
        } else {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:966870700"))
            startActivity(intent)
        }
    }

    fun googleMaps(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.553468,-0.121579"))
        startActivity(intent)
    }

    fun hacerFoto(view: View) {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intent)
    }

    fun mandarCorreo(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "asunto")
        intent.putExtra(Intent.EXTRA_TEXT, "texto del correo")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("smira@iesperemaria.com"))
        startActivity(intent)
    }

    fun busquedaWeb(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.es/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#safe=strict&q=Ies+Pere+Maria+Orts"))
        startActivity(intent)
    }

    fun iniciarDialer(view: View) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:966870700"))
        startActivity(intent)
    }

    fun streetView(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll= 38.553468,-0.121579"))
        startActivity(intent)
    }

    fun compartirCon(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, "Compartido desde IES Pere Maria Orts")
        intent.type = "text/plain"
        val titulo = resources.getString(R.string.compartir)
        val chooser = Intent.createChooser(intent, titulo)

        if (chooser.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        }
    }

}
