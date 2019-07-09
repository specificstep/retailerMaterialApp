package s.com.retailermaterialapp.ui;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.CompanyListAdapter;
import s.com.retailermaterialapp.adapter.ServicesAdapter;
import s.com.retailermaterialapp.recyclerview.GridSpacingItemDecoration;

public class CompanyListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewCompanyList)
    RecyclerView recyclerViewServices;
    String service_id = "";
    ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        ButterKnife.bind(this);
        try {
            service_id = getIntent().getStringExtra("service_id");
        } catch (Exception e) {
            System.out.println("getIntent error: " + e.toString());
        }

        initialize();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompanyListActivity.this.finish();
            }
        });
    }

    public void initialize() {

        imgBack = (ImageButton) findViewById(R.id.imgProviderListBack);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewServices.setLayoutManager(mLayoutManager);
        recyclerViewServices.addItemDecoration(new GridSpacingItemDecoration(2, Constants.dpToPx(CompanyListActivity.this,10), true));
        recyclerViewServices.setItemAnimator(new DefaultItemAnimator());
        recyclerViewServices.setAdapter(new CompanyListAdapter(CompanyListActivity.this, getDemoList()));

    }

    private ArrayList<String> getDemoList() {
        ArrayList<String> list = new ArrayList<>();
        if(service_id.equals(Constants.mobile_prepaid_id)) {
            list.add("Vodafone");
            list.add("Idea");
            list.add("Aircel");
            list.add("Telenor");
            list.add("Jio");
            list.add("Tata Docomo");
            list.add("Mtnl");
            list.add("Bsnl");
        } else if(service_id.equals(Constants.mobile_postpaid_id)) {
            list.add("Vodafone Postpaid");
        } else if(service_id.equals(Constants.dth_id)) {
            list.add("Airtel digital tv");
            list.add("Dish tv");
            list.add("Reliance digital tv");
            list.add("Sun direct");
            list.add("Tata sky");
            list.add("Videocon d2h");
        } else if(service_id.equals(Constants.electricity_id)) {
            list.add("Torrent Power");
        } else if(service_id.equals(Constants.gas_id)) {
            list.add("Adani");
        } else if(service_id.equals(Constants.water_id)) {
            list.add("UIT Bhiwadi");
            list.add("Uttarakhand Jal Sansthan");
        }

        return list;
    }

}
