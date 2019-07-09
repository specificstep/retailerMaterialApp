package s.com.retailermaterialapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import butterknife.BindView;
import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.CircleListAdapter;
import s.com.retailermaterialapp.adapter.CompanyListAdapter;
import s.com.retailermaterialapp.recyclerview.GridSpacingItemDecoration;

public class CircleListActivity extends AppCompatActivity {

    RecyclerView recyclerViewServices;
    String service_id = "";
    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_list);

        initialize();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircleListActivity.this.finish();
            }
        });

    }

    public void initialize() {
        recyclerViewServices = (RecyclerView) findViewById(R.id.recyclerViewCircleList);
        imgBack = (ImageButton) findViewById(R.id.imgCircleListBack);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(CircleListActivity.this);
        recyclerViewServices.setLayoutManager(mLayoutManager);
        recyclerViewServices.setItemAnimator(new DefaultItemAnimator());
        recyclerViewServices.setAdapter(new CircleListAdapter(CircleListActivity.this, getDemoList()));
    }

    private ArrayList<String> getDemoList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Assam");
        list.add("Chennai");
        list.add("Delhi NCR");
        list.add("Gujarat");
        list.add("Kerala");
        return list;
    }

}
