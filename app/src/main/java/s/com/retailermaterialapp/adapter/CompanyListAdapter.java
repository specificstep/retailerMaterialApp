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
import s.com.retailermaterialapp.ui.CircleListActivity;
import s.com.retailermaterialapp.ui.CompanyListActivity;
import s.com.retailermaterialapp.ui.NewPaymentActivity;

public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtService;
        public ImageView img;
        public LinearLayout lnrService;

        public MyViewHolder(View view) {
            super(view);
            txtService = (TextView) view.findViewById(R.id.txtCompanyList);
            img = (ImageView) view.findViewById(R.id.imgCompanyList);
            lnrService = (LinearLayout) view.findViewById(R.id.lnrCompanyList);
        }
    }


    public CompanyListAdapter(Context mContext, List<String> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_company_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.txtService.setText(albumList.get(position));
        holder.lnrService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = (Activity) mContext;
                /*Intent intent = new Intent(mContext, NewPaymentActivity.class);
                activity.startActivity(intent);*/
                Constants.mob_prepaid_selected_company = albumList.get(position);
                Intent intent = new Intent(mContext, CircleListActivity.class);
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
