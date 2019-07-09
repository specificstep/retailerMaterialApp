package s.com.retailermaterialapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.SecureRandom;
import java.util.List;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.Models.RechargeContactModel;
import s.com.retailermaterialapp.Models.RechargeServiceModels;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.ui.CompanyListActivity;
import s.com.retailermaterialapp.ui.HomeActivity;
import s.com.retailermaterialapp.ui.MobilePrepaidPaymentActivity;
import s.com.retailermaterialapp.ui.MobilePrepaidRechargeActivity;

public class RechargeContactAdapter extends RecyclerView.Adapter<RechargeContactAdapter.MyViewHolder> {

    private Context mContext;
    private List<RechargeContactModel> albumList;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle, txtName, txtNumber;
        public LinearLayout lnrContactList, lnrTitle;

        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtContactListTitle);
            txtName = (TextView) view.findViewById(R.id.txtContactListName);
            txtNumber = (TextView) view.findViewById(R.id.txtContactListNumber);
            lnrContactList = (LinearLayout) view.findViewById(R.id.lnrRechargeContactList);
            lnrTitle = (LinearLayout) view.findViewById(R.id.lnrContactListTitle);
        }
    }


    public RechargeContactAdapter(Context mContext, List<RechargeContactModel> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        activity = (Activity) mContext;
    }

    @Override
    public RechargeContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recharge_contact_list, parent, false);

        return new RechargeContactAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RechargeContactAdapter.MyViewHolder holder, final int position) {

        holder.txtTitle.setText(String.valueOf(albumList.get(position).getName().charAt(0)));
        holder.txtName.setText(albumList.get(position).getName());
        holder.txtNumber.setText(albumList.get(position).getNumber());
        holder.lnrContactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constants.mob_prepaid_selected_name = albumList.get(position).getName();
                Constants.mob_prepaid_selected_number = albumList.get(position).getNumber();
                Intent intent = new Intent(activity, MobilePrepaidPaymentActivity.class);
                activity.startActivity(intent);
            }
        });
        GradientDrawable draw = new GradientDrawable();
        draw.setShape(GradientDrawable.OVAL);
        draw.setColor(getRandomColor());
        holder.lnrTitle.setBackground(draw);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    private int getRandomColor() {
        SecureRandom rgen = new SecureRandom();
        return Color.HSVToColor(150, new float[]{
                rgen.nextInt(359), 1, 1
        });
    }

}
