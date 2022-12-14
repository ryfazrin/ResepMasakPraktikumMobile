package com.ryfazrin.resepmasak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<Resep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<Resep>
        get() {
            val dataResepTitle = resources.getStringArray(R.array.resep_title)
            val dataTimes = resources.getStringArray(R.array.times)
            val dataDifficulty = resources.getStringArray(R.array.difficulty)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataDescription = resources.getStringArray(R.array.description)

            val listUser = ArrayList<Resep>()
            for (i in dataResepTitle.indices) {
                val resep = Resep(
                    resep_title = dataResepTitle[i],
                    times = dataTimes[i],
                    difficulty = dataDifficulty[i],
                    avatar = dataAvatar.getResourceId(i, -1),
                    description = dataDescription[i]
                )
                listUser.add(resep)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemCLickCallback {
            override fun onItemClicked(data: Resep) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: Resep) {
        val moveDetailIntent = Intent(this@MainActivity, DetailUserActivity::class.java)
        moveDetailIntent.putExtra(DetailUserActivity.EXTRA_USER, user)
        startActivity(moveDetailIntent)
    }
}