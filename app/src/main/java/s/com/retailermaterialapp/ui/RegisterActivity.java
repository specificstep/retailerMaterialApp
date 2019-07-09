package s.com.retailermaterialapp.ui;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import s.com.retailermaterialapp.R;

public class RegisterActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    Button btnRegister;
    TextInputEditText edtRegister;
    GoogleApiClient mCredentialsApiClient;
    private static final int RESOLVE_HINT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialize();

        mCredentialsApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(RegisterActivity.this)
                .enableAutoManage(this, RegisterActivity.this)
                .addApi(Auth.CREDENTIALS_API)
                .build();
        requestHint();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,OtpVerificationActivity.class);
                intent.putExtra("number",edtRegister.getText().toString());
                startActivity(intent);
            }
        });

    }

    public void initialize() {
        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtRegister = (TextInputEditText) findViewById(R.id.edtRegister);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESOLVE_HINT) {
            if (resultCode == RESULT_OK) {
                Credential cred = data.getParcelableExtra(Credential.EXTRA_KEY);
                edtRegister.setText(cred.getId().substring(cred.getId().length()-10));
            } else {

            }
        }
    }

    private void requestHint() {
        HintRequest hintRequest = new HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build();

        PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(
                mCredentialsApiClient, hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(),
                    RESOLVE_HINT, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

}
