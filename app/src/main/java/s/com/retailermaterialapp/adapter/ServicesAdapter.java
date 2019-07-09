package s.com.retailermaterialapp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.Models.RechargeServiceModels;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.ui.CompanyListActivity;
import s.com.retailermaterialapp.ui.DMT.SenderSearchActivity;
import s.com.retailermaterialapp.ui.HomeActivity;
import s.com.retailermaterialapp.ui.MobilePrepaidRechargeActivity;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {

    private Context mContext;
    private List<RechargeServiceModels> albumList;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtService;
        public ImageView img;
        public LinearLayout lnrService;

        public MyViewHolder(View view) {
            super(view);
            txtService = (TextView) view.findViewById(R.id.txtService);
            img = (ImageView) view.findViewById(R.id.img);
            lnrService = (LinearLayout) view.findViewById(R.id.lnrService);
        }
    }


    public ServicesAdapter(Context mContext, List<RechargeServiceModels> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        activity = (Activity) mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txtService.setText(albumList.get(position).getName());
        holder.lnrService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constants.selected_service_id = albumList.get(position).getId();
                if(albumList.get(position).getId().equals(Constants.mobile_prepaid_id)) {
                    Intent intent = new Intent(activity, MobilePrepaidRechargeActivity.class);
                    activity.startActivity(intent);
                } else if(albumList.get(position).getId().equals(Constants.dmt_id)) {
                    Intent intent = new Intent(activity, SenderSearchActivity.class);
                    activity.startActivity(intent);
                } else if(albumList.get(position).getId().equals(Constants.more_id)) {
                    HomeActivity.slidingRootNav.openMenu();
                } else {
                    Intent intent = new Intent(activity, CompanyListActivity.class);
                    intent.putExtra("service_id", albumList.get(position).getId());
                    activity.startActivity(intent);
                }
            }
        });
        holder.img.setImageResource(albumList.get(position).getLogo());

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
