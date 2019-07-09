package s.com.retailermaterialapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.ui.MobilePrepaidPaymentActivity;
import s.com.retailermaterialapp.ui.NewPaymentActivity;

public class CircleListAdapter extends RecyclerView.Adapter<CircleListAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtService;
        public LinearLayout lnrService;

        public MyViewHolder(View view) {
            super(view);
            txtService = (TextView) view.findViewById(R.id.txtCircleName);
            lnrService = (LinearLayout) view.findViewById(R.id.lnrCircleList);
        }
    }


    public CircleListAdapter(Context mContext, List<String> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public CircleListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_circle_list, parent, false);

        return new CircleListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CircleListAdapter.MyViewHolder holder, final int position) {

        holder.txtService.setText(albumList.get(position));
        holder.lnrService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constants.mob_prepaid_selected_circle = albumList.get(position);
                Activity activity = (Activity) mContext;
                if(Constants.selected_service_id.equals(Constants.mobile_prepaid_id)) {
                    Intent intent = new Intent(mContext, MobilePrepaidPaymentActivity.class);
                    activity.startActivity(intent);
                } else {
                    Intent intent = new Intent(mContext, NewPaymentActivity.class);
                    activity.startActivity(intent);
                }
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */


    @Override
    public int getItemCount() {
        return albumList.size();
    }

}
