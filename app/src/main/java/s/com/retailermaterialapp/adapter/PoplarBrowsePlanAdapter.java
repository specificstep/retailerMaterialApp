package s.com.retailermaterialapp.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.fragments.PopularBrowsePlansFragment;
import s.com.retailermaterialapp.ui.MobilePrepaidPaymentActivity;
import s.com.retailermaterialapp.ui.NewPaymentActivity;

public class PoplarBrowsePlanAdapter extends RecyclerView.Adapter<PoplarBrowsePlanAdapter.MyViewHolder> {

    Activity activity;
    private Context mContext;
    private List<String> albumList;
    BottomSheetDialog dialog;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtAmount, txtData, txtSms, txtDetail, txtValidity;
        public LinearLayout lnrSelect, lnrPopularPlan;
        public RelativeLayout rltDetail;

        public MyViewHolder(View view) {
            super(view);
            txtAmount = (TextView) view.findViewById(R.id.txtPopularPlanAmount);
            txtData = (TextView) view.findViewById(R.id.txtPopularPlanData);
            txtSms = (TextView) view.findViewById(R.id.txtPopularPlanSms);
            txtDetail = (TextView) view.findViewById(R.id.txtPopularPlanDetail);
            txtValidity = (TextView) view.findViewById(R.id.txtPopularPlanValidity);
            lnrSelect = (LinearLayout) view.findViewById(R.id.lnrPopularPlanSelect);
            lnrPopularPlan = (LinearLayout) view.findViewById(R.id.lnrPopularPlan);
            rltDetail = (RelativeLayout) view.findViewById(R.id.rltPopularPlanDetail);
        }
    }


    public PoplarBrowsePlanAdapter(Context mContext, List<String> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
        activity = (Activity) mContext;
        dialog = new BottomSheetDialog(activity);
    }

    @Override
    public PoplarBrowsePlanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular_browse_plan_list, parent, false);

        return new PoplarBrowsePlanAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PoplarBrowsePlanAdapter.MyViewHolder holder, final int position) {

        holder.txtAmount.setText(activity.getResources().getString(R.string.rs)
                + " " + albumList.get(position));
        holder.lnrSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobilePrepaidPaymentActivity.edtAmount.setText(holder.txtAmount.getText().toString());
                activity.finish();
            }
        });
        holder.rltDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetailDialog(holder.txtAmount.getText().toString());
            }
        });

    }

    public void showDetailDialog(final String amount) {
        dialog.setContentView(R.layout.dialog_plan_detail);
        FrameLayout bottomSheet = (FrameLayout) dialog.findViewById(android.support.design.R.id.design_bottom_sheet);
        BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        dialog.setCanceledOnTouchOutside(false);

        TextView txtAmount = (TextView) dialog.findViewById(R.id.txtDialogPlanDetailAmount);
        TextView txtData = (TextView) dialog.findViewById(R.id.txtDialogPlanDetailData);
        TextView txtSms = (TextView) dialog.findViewById(R.id.txtDialogPlanDetailSms);
        TextView txtDetail = (TextView) dialog.findViewById(R.id.txtDialogPlanDetailDetail);
        Button btn = (Button) dialog.findViewById(R.id.btnDialogPlanDetail);
        ImageButton imgCancel = (ImageButton) dialog.findViewById(R.id.imgDialogPlanDetailCancel);

        txtAmount.setText(amount);

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                MobilePrepaidPaymentActivity.edtAmount.setText(amount);
                activity.finish();
            }
        });

        dialog.show();
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}
