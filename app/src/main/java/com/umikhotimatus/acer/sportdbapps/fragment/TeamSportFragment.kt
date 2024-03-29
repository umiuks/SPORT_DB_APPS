package com.umikhotimatus.acer.sportdbapps.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.umikhotimatus.acer.sportdbapps.R
import com.umikhotimatus.acer.sportdbapps.adapter.TeamAdapter
import com.umikhotimatus.acer.sportdbapps.model.ApiClient
import com.umikhotimatus.acer.sportdbapps.model.ApiService
import com.umikhotimatus.acer.sportdbapps.model.ItemsSport
import com.umikhotimatus.acer.sportdbapps.model.TeamsItem
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@Suppress("UNCHECKED_CAST")
/**
 * A simple [Fragment] subclass.
 *
 */
class TeamSportFragment : Fragment() {
    private var items : ArrayList<TeamsItem> = arrayListOf()
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate (R.layout.fragment_team_sport, container, false)
        val recyclerView:RecyclerView = view.findViewById(R.id.rv_list)


        val service : ApiService = ApiClient.provideApi()
        service.getTeamByLigaId("4328")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                items.clear()
                items = it.teams as ArrayList<TeamsItem>
                teamAdapter = TeamAdapter(activity,items)
                recyclerView.adapter = teamAdapter
                recyclerView.layoutManager = LinearLayoutManager(activity)
            })



        return view
    }


}
