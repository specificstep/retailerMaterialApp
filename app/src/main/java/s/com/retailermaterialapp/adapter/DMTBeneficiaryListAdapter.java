package s.com.retailermaterialapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.ui.CircleListActivity;
import s.com.retailermaterialapp.ui.DMT.IMPSPaymentActivity;

public class DMTBeneficiaryListAdapter extends RecyclerView.Adapter<DMTBeneficiaryListAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> albumList;
    Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtService;
        public ImageButton imgMore;
        public CardView crd;
        public LinearLayout lnrVerify;
        public Button btnDelete, btnImps;

        public MyViewHolder(View view) {
            super(view);
            txtService = (TextView) view.findViewById(R.id.txtBeneficiaryListName);
            imgMore = (ImageButton) view.findViewById(R.id.imgBeneficiaryListMore);
            crd = (CardView) view.findViewById(R.id.crdBeneficiaryListMore);
            lnrVerify = (LinearLayout) view.findViewById(R.id.lnrBeneficiaryListVerified);
            btnDelete = (Button) view.findViewById(R.id.btnBeneficiaryListDelete);
            btnImps = (Button) view.findViewById(R.id.btnBeneficiaryListImps);
        }
    }

    public DMTBeneficiaryListAdapter(Context mContext, List<String> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        activity = (Activity) mContext;
    }

    @Override
    public DMTBeneficiaryListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_beneficiary_list, parent, false);

        return new DMTBeneficiaryListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DMTBeneficiaryListAdapter.MyViewHolder holder, final int position) {

        holder.txtService.setText(albumList.get(position));
        holder.imgMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.crd.getVisibility() == View.VISIBLE) {
                    holder.crd.setVisibility(View.GONE);
                } else {
                    holder.crd.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.btnImps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, IMPSPaymentActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}
