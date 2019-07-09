package s.com.retailermaterialapp.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import s.com.retailermaterialapp.Models.RechargeContactModel;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.RechargeContactAdapter;
import s.com.retailermaterialapp.adapter.TransactionAdapter;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class RechargeContactListActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    ArrayList<RechargeContactModel> StoreContacts ;
    ArrayList<RechargeContactModel> subStoreContacts ;
    RechargeContactModel contactModel;
    Cursor cursor ;
    String name, phonenumber ;
    public  static final int RequestPermissionCode  = 1 ;
    ImageButton imgBack, imgCancel;
    EditText edtMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge_contact_list);
        initialize();
        EnableRuntimePermission();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RechargeContactListActivity.this.finish();
            }
        });

        edtMobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
                if(s.length()>0) {
                    imgCancel.setVisibility(View.VISIBLE);
                } else {
                    imgCancel.setVisibility(View.INVISIBLE);
                }
            }
        });

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCancel.setVisibility(View.INVISIBLE);
                edtMobile.setText("");
                subStoreContacts = StoreContacts;
                recyclerView.setAdapter(new RechargeContactAdapter(RechargeContactListActivity.this, subStoreContacts));
            }
        });

    }

    public void initialize() {
        recyclerView = (RecyclerView) findViewById(R.id.rcvContactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(RechargeContactListActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(RechargeContactListActivity.this, DividerItemDecoration.VERTICAL));
        imgBack = (ImageButton) findViewById(R.id.imgContactListBack);
        imgCancel = (ImageButton) findViewById(R.id.imgContactListCancel);
        edtMobile = (EditText) findViewById(R.id.edtContactListMobile);
        subStoreContacts = new ArrayList<RechargeContactModel>();
    }

    public void filter(String text) {
        ArrayList<RechargeContactModel> temp = new ArrayList();
        for(RechargeContactModel d: StoreContacts){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getNumber().contains(text)){
                temp.add(d);
            }
        }
        subStoreContacts = temp;
        recyclerView.setAdapter(new RechargeContactAdapter(RechargeContactListActivity.this, subStoreContacts));
    }

    public void GetContactsIntoArrayList(){

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);
        StoreContacts = new ArrayList<RechargeContactModel>();
        while (cursor.moveToNext()) {
            contactModel = new RechargeContactModel();
            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactModel.setName(name);
            contactModel.setNumber(phonenumber);
            StoreContacts.add(contactModel);
        }

        cursor.close();
        Collections.sort(StoreContacts, new Comparator<RechargeContactModel>() {
            @Override
            public int compare(RechargeContactModel s1, RechargeContactModel s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });
        subStoreContacts = StoreContacts;
        recyclerView.setAdapter(new RechargeContactAdapter(RechargeContactListActivity.this, subStoreContacts));

    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                RechargeContactListActivity.this,
                Manifest.permission.READ_CONTACTS)) {
            GetContactsIntoArrayList();
        } else {
            ActivityCompat.requestPermissions(RechargeContactListActivity.this,new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
                    GetContactsIntoArrayList();
                } else {
                    Toast.makeText(RechargeContactListActivity.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

}
