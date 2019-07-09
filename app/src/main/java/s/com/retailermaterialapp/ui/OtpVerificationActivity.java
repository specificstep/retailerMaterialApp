package s.com.retailermaterialapp.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import s.com.retailermaterialapp.R;

public class OtpVerificationActivity extends AppCompatActivity {

    TextView txtMessage;
    Button btnOtp;
    String registerNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        initialize();

        registerNo = getIntent().getStringExtra("number");
        txtMessage.setText(getResources().getString(R.string.otp_message) + " " + registerNo);
        btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                successDialog();
            }
        });

    }

    public void initialize() {
        txtMessage = (TextView) findViewById(R.id.txtOtpMessage);
        btnOtp = (Button) findViewById(R.id.btnOtp);
    }

    public void successDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_registration_success, null);
        dialogBuilder.setView(dialogView);
        dialogView.setBackgroundResource(android.R.color.transparent);

        Button btnRegister = (Button) dialogView.findViewById(R.id.btnRegisterDialog);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtpVerificationActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog b = dialogBuilder.create();
        b.show();

    }

}
