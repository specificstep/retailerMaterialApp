package s.com.retailermaterialapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import s.com.retailermaterialapp.R;

public class NewPaymentActivity extends AppCompatActivity {

    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment);

        initialize();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewPaymentActivity.this.finish();
            }
        });

    }

    public void initialize() {

        imgBack = (ImageButton) findViewById(R.id.imgNewPaymentBack);

    }

}
