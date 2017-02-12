/*
 * Created by Rasoul Miri on 2/3/17 9:03 PM.
 */

package io.rmiri.gpuoverdraw;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.MyViewHolder> {

    private Context context;
    private List<Watch> watchList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView brand, color;
        ImageView thumbnail;

        MyViewHolder(View view) {
            super(view);
            brand = (TextView) view.findViewById(R.id.title);
            color = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    WatchAdapter(Context mContext, List<Watch> watchList) {
        this.context = mContext;
        this.watchList = watchList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.watch_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Watch watch = watchList.get(position);
        holder.brand.setText(watch.getBrand());
        holder.color.setText(watch.getColor());
        holder.thumbnail.setImageResource(watch.getThumbnail());
    }


    @Override
    public int getItemCount() {
        return watchList.size();
    }
}
