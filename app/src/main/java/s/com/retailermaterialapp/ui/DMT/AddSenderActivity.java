package s.com.retailermaterialapp.ui.DMT;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import s.com.retailermaterialapp.R;

public class AddSenderActivity extends AppCompatActivity {

    ImageButton imgBack;
    Button btnCancel, btnSubmit;
    EditText edtFirstName, edtLastName, edtMobile, edtEmail, edtAddress,
            edtPincode, edtDob;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sender);

        initialize();
        edtMobile.setText(SenderSearchActivity.senderMobile);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSenderActivity.this.finish();
            }
        });

        edtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddSenderActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis() + (1000 * 60 * 60 * 1));
                dialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSenderActivity.this.finish();
                Intent intent = new Intent(AddSenderActivity.this,SenderOtpVerificationActivity.class);
                startActivity(intent);
            }
        });

    }

        public void initialize () {
            imgBack = (ImageButton) findViewById(R.id.imgAddSenderBack);
            btnCancel = (Button) findViewById(R.id.btnAddSenderCancel);
            btnSubmit = (Button) findViewById(R.id.btnAddSenderSubmit);
            edtFirstName = (EditText) findViewById(R.id.edtAddSenderFirstName);
            edtLastName = (EditText) findViewById(R.id.edtAddSenderLastName);
            edtMobile = (EditText) findViewById(R.id.edtAddSenderMobile);
            edtEmail = (EditText) findViewById(R.id.edtAddSenderEmail);
            edtAddress = (EditText) findViewById(R.id.edtAddSenderAddress);
            edtPincode = (EditText) findViewById(R.id.edtAddSenderPincode);
            edtDob = (EditText) findViewById(R.id.edtAddSenderDob);
            myCalendar = Calendar.getInstance();
            date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

            };
        }

        void updateLabel() {
            String myFormat = "yyyy-MM-dd"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            edtDob.setText(sdf.format(myCalendar.getTime()));
        }

}
