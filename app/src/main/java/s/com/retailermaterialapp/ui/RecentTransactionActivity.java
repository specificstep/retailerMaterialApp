package s.com.retailermaterialapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.TransactionAdapter;

public class RecentTransactionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_transaction);

        initialize();

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecentTransactionActivity.this.finish();
            }
        });

    }

    public void initialize() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewRecentTransactionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecentTransactionActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(RecentTransactionActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new TransactionAdapter(RecentTransactionActivity.this, getTransactionDemoList()));
        imgBack = (ImageButton) findViewById(R.id.imgRecentBack);

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
