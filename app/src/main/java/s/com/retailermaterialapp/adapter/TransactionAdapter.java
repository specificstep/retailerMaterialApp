package s.com.retailermaterialapp.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import s.com.retailermaterialapp.R;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMobNo, txtId, txtStatus;
        public View viewStatus;
        LinearLayout lnrHelp;

        public MyViewHolder(View view) {
            super(view);
            txtMobNo = (TextView) view.findViewById(R.id.txtMobNo);
            txtId = (TextView) view.findViewById(R.id.txtId);
            viewStatus = (View) view.findViewById(R.id.viewStatus);
            lnrHelp = (LinearLayout) view.findViewById(R.id.lnrRecentHelp);
            txtStatus = (TextView) view.findViewById(R.id.txtRechargeStatus);
        }
    }


    public TransactionAdapter(Context mContext, List<String> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

//        holder.txtService.setText(albumList.get(position));

        if (albumList.get(position).equalsIgnoreCase("success")) {
            holder.viewStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorGreen));
            holder.txtStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorGreen));
            holder.txtStatus.setText("Success");
            holder.lnrHelp.setVisibility(View.VISIBLE);
        } else if (albumList.get(position).equalsIgnoreCase("pending")) {
            holder.viewStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorOrange));
            holder.txtStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorOrange));
            holder.lnrHelp.setVisibility(View.INVISIBLE);
            holder.txtStatus.setText("Pending");
        } else if (albumList.get(position).equalsIgnoreCase("cancel")) {
            holder.viewStatus.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorRed));
            holder.txtStatus.setTextColor(ContextCompat.getColor(mContext, R.color.colorRed));
            holder.lnrHelp.setVisibility(View.INVISIBLE);
            holder.txtStatus.setText("Cancel");
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
