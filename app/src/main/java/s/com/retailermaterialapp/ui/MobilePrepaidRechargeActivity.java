package s.com.retailermaterialapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.TransactionAdapter;

public class MobilePrepaidRechargeActivity extends AppCompatActivity {

    LinearLayout lnrRecharge;
    ImageButton imgBack, imgContacts;
    public static ImageButton imgCancel;
    RecyclerView recyclerViewRecentPayment;
    TextView txtViewAll;
    public static EditText edtMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_prepaid_recharge);

        initialize();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobilePrepaidRechargeActivity.this.finish();
            }
        });

        txtViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobilePrepaidRechargeActivity.this, AllTransactionReportsActivity.class);
                intent.putExtra("position","0");
                startActivity(intent);
            }
        });

       edtMobile.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MobilePrepaidRechargeActivity.this, RechargeContactListActivity.class);
               startActivity(intent);
           }
       });

       imgContacts.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MobilePrepaidRechargeActivity.this,RechargeSearchContactListActivity.class);
               startActivity(intent);
           }
       });

       imgCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               edtMobile.setText("");
               imgCancel.setVisibility(View.INVISIBLE);
           }
       });

    }

    public void initialize() {
        lnrRecharge = (LinearLayout) findViewById(R.id.lnrMobPrepaidRecharge);
        imgBack = (ImageButton) findViewById(R.id.imgMobPrepaidBack);
        imgCancel = (ImageButton) findViewById(R.id.imgMobPrepaidCancel);
        imgContacts = (ImageButton) findViewById(R.id.imgMobPrepaidContacts);
        edtMobile = (EditText) findViewById(R.id.edtMobPrepaidMobile);
        recyclerViewRecentPayment = (RecyclerView) findViewById(R.id.recyclerViewMobPrepaidRecentPayment);
        txtViewAll = (TextView) findViewById(R.id.txtMobPrepaidViewAll);

        recyclerViewRecentPayment.setLayoutManager(new LinearLayoutManager(MobilePrepaidRechargeActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerViewRecentPayment.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRecentPayment.addItemDecoration(new DividerItemDecoration(MobilePrepaidRechargeActivity.this, DividerItemDecoration.VERTICAL));
        recyclerViewRecentPayment.setAdapter(new TransactionAdapter(MobilePrepaidRechargeActivity.this, getTransactionDemoList()));

    }

    private ArrayList<String> getTransactionDemoList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("success");
        list.add("pending");
        list.add("cancel");
        list.add("success");
        return list;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MobilePrepaidRechargeActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
