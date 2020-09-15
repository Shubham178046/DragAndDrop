package com.example.draganddrop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), MainFragment.OnListItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar) as Toolbar?)

        if (savedInstanceState == null) {
            val fragment = MainFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.content, fragment)
                .commit()
        }
    }

    override fun onListItemClick(position: Int) {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = RecyclerListFragment()
            1 -> fragment = RecyclerGridFragment()
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.content, fragment!!)
                .addToBackStack(null)
                .commit()
    }
}