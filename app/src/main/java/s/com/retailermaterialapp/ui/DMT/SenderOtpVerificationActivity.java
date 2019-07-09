package s.com.retailermaterialapp.ui.DMT;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.ui.HomeActivity;
import s.com.retailermaterialapp.ui.OtpVerificationActivity;

public class SenderOtpVerificationActivity extends AppCompatActivity {

    TextView txtMessage;
    Button btnOtp;
    String registerNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_otp_verification);

        initialize();

        registerNo = SenderSearchActivity.senderMobile;
        txtMessage.setText(getResources().getString(R.string.otp_message) + " " + registerNo);
        btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SenderOtpVerificationActivity.this.finish();
                Intent intent = new Intent(SenderOtpVerificationActivity.this,AddBeneficiaryActivity.class);
                startActivity(intent);
            }
        });

    }

    public void initialize() {
        txtMessage = (TextView) findViewById(R.id.txtSenderOtpMessage);
        btnOtp = (Button) findViewById(R.id.btnSenderOtp);
    }

}
