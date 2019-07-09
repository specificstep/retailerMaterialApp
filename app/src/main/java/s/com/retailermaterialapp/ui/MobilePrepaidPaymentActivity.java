package s.com.retailermaterialapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;

public class MobilePrepaidPaymentActivity extends AppCompatActivity {

    ImageButton imgBack;
    TextView txtChangeOperator, txtBrowsePlans, txtName, txtNumber, txtDetail;
    Button btnRecharge;
    public static EditText edtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_prepaid_payment);
        initialize();

        txtName.setText(Constants.mob_prepaid_selected_name);
        txtNumber.setText(Constants.mob_prepaid_selected_number);
        txtDetail.setText("Prepaid, " + Constants.mob_prepaid_selected_company +
                " " + Constants.mob_prepaid_selected_circle);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobilePrepaidPaymentActivity.this.finish();
            }
        });

        txtChangeOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobilePrepaidPaymentActivity.this, CompanyListActivity.class);
                intent.putExtra("service_id", Constants.mobile_prepaid_id);
                startActivity(intent);
            }
        });

        txtBrowsePlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobilePrepaidPaymentActivity.this,BrowsePlanActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in,R.anim.no_change);
            }
        });

    }

    public void initialize() {
        imgBack = (ImageButton) findViewById(R.id.imgMobPrepaidPaymentBack);
        txtChangeOperator = (TextView) findViewById(R.id.txtMobPrepaidPaymentChangeOperator);
        txtBrowsePlans = (TextView) findViewById(R.id.txtMobPrepaidPaymentBrowsePlan);
        txtName = (TextView) findViewById(R.id.txtMobPrepaidPaymentName);
        txtNumber = (TextView) findViewById(R.id.txtMobPrepaidPaymentNumber);
        txtDetail = (TextView) findViewById(R.id.txtMobPrepaidPaymentDetail);
        btnRecharge = (Button) findViewById(R.id.btnMobPrepaidPaymemtRecharge);
        edtAmount = (EditText) findViewById(R.id.edtMobPrepaidPaymentAmount);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(MobilePrepaidPaymentActivity.this,MobilePrepaidRechargeActivity.class);
        startActivity(intent);
        MobilePrepaidPaymentActivity.this.finish();
    }
}
