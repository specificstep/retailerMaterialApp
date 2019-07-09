package s.com.retailermaterialapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.ui.DMT.TransactionListDetailActivity;

public class DMTPaymentListAdapter extends RecyclerView.Adapter<DMTPaymentListAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> albumList;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMobNo, txtId, txtStatus;
        public View viewStatus;
        public LinearLayout lnr;

        public MyViewHolder(View view) {
            super(view);
            txtMobNo = (TextView) view.findViewById(R.id.txtDmtMobNo);
            txtId = (TextView) view.findViewById(R.id.txtDmtId);
            viewStatus = (View) view.findViewById(R.id.viewDmtStatus);
            txtStatus = (TextView) view.findViewById(R.id.txtDmtRechargeStatus);
            lnr = (LinearLayout) view.findViewById(R.id.lnrDmtPaymentList);
        }
    }


    public DMTPaymentListAdapter(Context mContext, List<String> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        activity = (Activity) mContext;
    }

    @Override
    public DMTPaymentListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_dmt_payment_list, parent, false);

        return new DMTPaymentListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DMTPaymentListAdapter.MyViewHolder holder, int position) {

//        holder.txtService.setText(albumList.get(position));

        if (albumList.get(position).equalsIgnoreCase("success")) {
            holder.viewStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorGreen));
            holder.txtStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorGreen));
            holder.txtStatus.setText("Success");
        } else if (albumList.get(position).equalsIgnoreCase("pending")) {
            holder.viewStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorOrange));
            holder.txtStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorOrange));
            holder.txtStatus.setText("Pending");
        } else if (albumList.get(position).equalsIgnoreCase("cancel")) {
            holder.viewStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorRed));
            holder.txtStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
            holder.txtStatus.setText("Cancel");
        }
        holder.lnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TransactionListDetailActivity.class);
                activity.startActivity(intent);
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
