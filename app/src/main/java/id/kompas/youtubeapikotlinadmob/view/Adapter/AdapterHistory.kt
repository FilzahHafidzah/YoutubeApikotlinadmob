package id.kompas.youtubeapikotlinadmob.view.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import id.kompas.youtubeapikotlinadmob.R
import id.kompas.youtubeapikotlinadmob.model.ItemsItem
import id.kompas.youtubeapikotlinadmob.view.FullscreenDemoActivity
import kotlinx.android.synthetic.main.history_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by nandoseptianhusni on 12/18/17.
 */
class AdapterHistory(var data: List<ItemsItem?>?) : RecyclerView.Adapter<AdapterHistory.MyHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {


        var view = LayoutInflater.from(parent?.context).inflate(R.layout.history_item, parent, false)


        return MyHolder(view)

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.bind( data?.get(position))
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {

        return data?.size!!
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind( data: ItemsItem?) {

            itemView.name.text = data?.snippet?.title
            itemView.subtitle.text = data?.snippet?.channelTitle
            itemView.onClick {
                itemView.context.startActivity(Intent(itemView.context,FullscreenDemoActivity::class.java))
            }
            Picasso.with(itemView.context).load(data?.snippet?.thumbnails?.high?.url)
                    .into(itemView.img)
        }


    }
}