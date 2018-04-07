package id.kompas.youtubeapikotlinadmob.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import  id.kompas.youtubeapikotlinadmob.R
import id.kompas.youtubeapikotlinadmob.model.ItemsItem
import id.kompas.youtubeapikotlinadmob.model.ResponseYOUTUBE
import id.kompas.youtubeapikotlinadmob.network.Http
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_first.*

import id.kompas.youtubeapikotlinadmob.view.Adapter.AdapterHistory
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_first, container, false)


//Http.retrofit.getyoutube().subscribeOn(Androi)
////part=snippet&maxResults=25&q=tenis%20meja&regionCode=ID&key=
        Http.retrofit.getyoutube("snippet","25","tabletennis","ID","AIzaSyClIAUvVIf497oM6Xukk1f5UYiPYUYnZ8I")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe({t: ResponseYOUTUBE? ->
                    var data = t?.items
                    recyclerview(data)
                },{t: Throwable? ->
                    Log.d("error : " , t?.localizedMessage)
                })




        return view
    }

    private fun recyclerview(data: List<ItemsItem?>?) {
        recycer.adapter = AdapterHistory(data)
        recycer.layoutManager  = LinearLayoutManager(activity)
    }

}// Required empty public constructor
