package s.com.retailermaterialapp.ui.DMT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.fragments.PaymentListActivity;
import s.com.retailermaterialapp.ui.AllTransactionReportsActivity;

public class IMPSPaymentActivity extends AppCompatActivity {

    ImageButton imgBack;
    Button btnTransactionList, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impspayment);

        initialize();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMPSPaymentActivity.this.finish();
            }
        });

        btnTransactionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IMPSPaymentActivity.this,AllTransactionReportsActivity.class);
                intent.putExtra("position","3");
                startActivity(intent);
            }
        });

    }

    public void initialize() {
        imgBack = (ImageButton) findViewById(R.id.imgImpsPaymentBack);
        btnTransactionList = (Button) findViewById(R.id.btnImpsTransactionList);
        btnSubmit = (Button) findViewById(R.id.btnImpsSubmit);
    }

}
