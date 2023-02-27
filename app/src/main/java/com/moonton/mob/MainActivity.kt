package com.moonton.mob

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moonton.mob.xzoosidh.Xosowiusdhw
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.util.*
import javax.crypto.*

class MainActivity : AppCompatActivity() {
    val sdjifjiji by viewModel <Xosowiusdhw>(named("MainModel"))

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sdjifjiji.llxozckskodijs(this@MainActivity)
    }


}