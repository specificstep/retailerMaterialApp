package s.com.retailermaterialapp.ui.DMT;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import s.com.retailermaterialapp.Models.DMTSenderBeneficiaryModel;
import s.com.retailermaterialapp.Models.SwipeControllerActions;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.DMTBeneficiaryListAdapter;
import s.com.retailermaterialapp.adapter.TransactionAdapter;

public class BeneficiaryListActivity extends AppCompatActivity {

    private DMTBeneficiaryListAdapter mAdapter;
    RecyclerView recyclerView;
    FloatingActionButton fabAdd;
    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary_list);

        initialize();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeneficiaryListActivity.this.finish();
            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeneficiaryListActivity.this,AddBeneficiaryActivity.class);
                startActivity(intent);
            }
        });

    }

    public void initialize() {
        recyclerView = (RecyclerView)findViewById(R.id.rcvBeneficiaryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new DMTBeneficiaryListAdapter(BeneficiaryListActivity.this, getTransactionDemoList()));
        fabAdd = (FloatingActionButton) findViewById(R.id.fabBeneficiaryList);
        imgBack = (ImageButton) findViewById(R.id.imgBeneficiaryListBack);
    }

    private ArrayList<String> getTransactionDemoList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("success");
        list.add("pending");
        list.add("cancel");
        list.add("success");
        return list;
    }

}
