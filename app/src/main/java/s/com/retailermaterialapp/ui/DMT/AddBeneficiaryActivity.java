package s.com.retailermaterialapp.ui.DMT;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import s.com.retailermaterialapp.R;

public class AddBeneficiaryActivity extends AppCompatActivity {

    EditText edtFirstName, edtLastName, edtMobile, edtAccountNumber, edtBank,
            edtIfsc;
    Spinner spnAccountType;
    Button btnCancel, btnSubmit;
    ImageButton imgBack;
    ArrayAdapter<String> adapter, adapterType;
    String[] accountType = {"Saving","Current"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beneficiary);

        initialize();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddBeneficiaryActivity.this.finish();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddBeneficiaryActivity.this,BeneficiaryListActivity.class);
                startActivity(intent);
            }
        });

        adapterType = new ArrayAdapter<String>(AddBeneficiaryActivity.this, android.R.layout.simple_dropdown_item_1line, accountType);
        spnAccountType.setAdapter(adapterType);

    }

    public void initialize() {
        edtFirstName = (EditText) findViewById(R.id.edtAddBeneficiaryFirstName);
        edtLastName = (EditText) findViewById(R.id.edtAddBeneficiaryLastName);
        edtMobile = (EditText) findViewById(R.id.edtAddBeneficiaryMobile);
        edtAccountNumber = (EditText) findViewById(R.id.edtAddBeneficiaryAccountNumber);
        edtBank = (EditText) findViewById(R.id.edtAddBeneficiaryBank);
        edtIfsc = (EditText) findViewById(R.id.edtAddBeneficiaryIfsc);
        spnAccountType = (Spinner) findViewById(R.id.spnAddBeneficiaryAccountType);
        btnCancel = (Button) findViewById(R.id.btnAddBeneficiaryCancel);
        btnSubmit = (Button) findViewById(R.id.btnAddBeneficiarySubmit);
        imgBack = (ImageButton) findViewById(R.id.imgAddBeneficiaryBack);
    }

}
