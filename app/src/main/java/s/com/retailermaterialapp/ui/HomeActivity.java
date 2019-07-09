package s.com.retailermaterialapp.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import s.com.library.SlidingRootNav;
import s.com.library.SlidingRootNavBuilder;
import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.Models.RechargeServiceModels;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.DrawerAdapter;
import s.com.retailermaterialapp.adapter.DrawerItem;
import s.com.retailermaterialapp.adapter.ServicesAdapter;
import s.com.retailermaterialapp.adapter.SimpleItem;
import s.com.retailermaterialapp.adapter.SpaceItem;
import s.com.retailermaterialapp.adapter.TransactionAdapter;
import s.com.retailermaterialapp.recyclerview.GridSpacingItemDecoration;
import s.com.retailermaterialapp.ui.DMT.SenderSearchActivity;

public class HomeActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    @BindView(R.id.recyclerViewServices)
    RecyclerView recyclerViewServices;

    @BindView(R.id.recyclerViewRecentPayment)
    RecyclerView recyclerViewRecentPayment;

    ImageButton imgSearch;
    Toolbar toolbar;
    TextView txtViewAll;
    LinearLayout lnrTransactionReport, lnrPaymentReport, lnrAccountLedger;

    private static final int POS_DASHBOARD = 0;
    private static final int POS_MOBILE_PREPAID = 1;
    private static final int POS_MOBILE_POSTPAID = 2;
    private static final int POS_DTH = 3;
    private static final int POS_DMT = 4;
    private static final int POS_ELECTRICITY = 5;
    private static final int POS_GAS = 6;
    private static final int POS_WATER = 7;
    private static final int POS_RECENT_TRANSACTION = 8;
    private static final int POS_COMPLAIN_REPORT = 9;
    private static final int POS_ACCOUNT_LEDGER = 10;
    private static final int POS_TRANSACTION_REPORTS = 11;
    private static final int POS_PAYMENT_REQUEST = 12;
    private static final int POS_PARENT_USER = 13;
    private static final int POS_CHANGE_PASSWORD = 14;
    private static final int POS_NOTIFICATION = 15;
    private static final int POS_SHARE = 16;
    private static final int POS_LOGIN_WITH_OTHER_NUMBER = 17;
    private static final int POS_UPDATE_DATA = 18;
    private static final int POS_LOGOUT = 19;
    private String[] screenTitles;
    private Drawable[] screenIcons;
    public static SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        init();

        lnrAccountLedger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,AccountLedgerActivity.class);
                startActivity(intent);
            }
        });

        lnrTransactionReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,AllTransactionReportsActivity.class);
                intent.putExtra("position","0");
                startActivity(intent);
            }
        });

        lnrPaymentReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,PaymentReportActivity.class);
                startActivity(intent);
            }
        });

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_MOBILE_PREPAID),
                createItemFor(POS_MOBILE_POSTPAID),
                createItemFor(POS_DTH),
                createItemFor(POS_DMT),
                createItemFor(POS_ELECTRICITY),
                createItemFor(POS_GAS),
                createItemFor(POS_WATER),
                createItemFor(POS_RECENT_TRANSACTION),
                createItemFor(POS_COMPLAIN_REPORT),
                createItemFor(POS_ACCOUNT_LEDGER),
                createItemFor(POS_TRANSACTION_REPORTS),
                createItemFor(POS_PAYMENT_REQUEST),
                createItemFor(POS_PARENT_USER),
                createItemFor(POS_CHANGE_PASSWORD),
                createItemFor(POS_NOTIFICATION),
                createItemFor(POS_SHARE),
                createItemFor(POS_LOGIN_WITH_OTHER_NUMBER),
                createItemFor(POS_UPDATE_DATA),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);

        txtViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,RecentTransactionActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 4);
        recyclerViewServices.setLayoutManager(mLayoutManager);
        recyclerViewServices.addItemDecoration(new GridSpacingItemDecoration(4, Constants.dpToPx(HomeActivity.this,10), true));
        recyclerViewServices.setItemAnimator(new DefaultItemAnimator());
        recyclerViewServices.setAdapter(new ServicesAdapter(HomeActivity.this, getDemoList()));
        recyclerViewServices.setNestedScrollingEnabled(false);

        recyclerViewRecentPayment.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerViewRecentPayment.setItemAnimator(new DefaultItemAnimator());
        recyclerViewRecentPayment.addItemDecoration(new DividerItemDecoration(HomeActivity.this, DividerItemDecoration.VERTICAL));
        recyclerViewRecentPayment.setAdapter(new TransactionAdapter(HomeActivity.this, getTransactionDemoList()));
        recyclerViewRecentPayment.setNestedScrollingEnabled(false);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtViewAll = (TextView) findViewById(R.id.txtViewAll);
        lnrTransactionReport = (LinearLayout) findViewById(R.id.lnrHomeTransactionReport);
        lnrPaymentReport = (LinearLayout) findViewById(R.id.lnrHomePaymentReport);
        lnrAccountLedger= (LinearLayout) findViewById(R.id.lnrHomeAcledger);
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    private ArrayList<RechargeServiceModels> getDemoList() {
        ArrayList<RechargeServiceModels> list = new ArrayList<RechargeServiceModels>();
        RechargeServiceModels model;

        model = new RechargeServiceModels();
        model.setId(Constants.mobile_prepaid_id);
        model.setName(Constants.KEY_MOB_PREPAID_TEXT);
        model.setLogo(R.drawable.ic_mobile);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.dth_id);
        model.setName(Constants.KEY_DTH_TEXT);
        model.setLogo(R.drawable.dth);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.electricity_id);
        model.setName(Constants.KEY_ELECTRICITY_TEXT);
        model.setLogo(R.drawable.ic_electricity2);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.gas_id);
        model.setName(Constants.KEY_GAS_TEXT);
        model.setLogo(R.drawable.gas);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.dmt_id);
        model.setName(Constants.KEY_DMT_TEXT);
        model.setLogo(R.drawable.ic_dmt);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.mobile_postpaid_id);
        model.setName(Constants.KEY_MOB_POSTPAID_TEXT);
        model.setLogo(R.drawable.mobile);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.water_id);
        model.setName(Constants.KEY_WATER_TEXT);
        model.setLogo(R.drawable.tap);
        list.add(model);

        model = new RechargeServiceModels();
        model.setId(Constants.more_id);
        model.setName(Constants.KEY_MORE_TEXT);
        model.setLogo(R.drawable.ic_more);
        list.add(model);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(Constants.mobile_postpaid_id)) {
                moveService(1, i,list);
            }
            if (list.get(i).getId().equals(Constants.dmt_id)) {
                moveService(2, i,list);
            }
        }

        return list;

    }

    public void moveService(int newPos, int oldPos, ArrayList<RechargeServiceModels> list) {
        list.add(newPos, list.remove(oldPos));
    }

    private ArrayList<String> getTransactionDemoList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("success");
        list.add("pending");
        list.add("cancel");
        list.add("success");
        return list;
    }

    @Override
    public void onItemSelected(int position) {
        if(position == POS_MOBILE_PREPAID) {
            Intent intent = new Intent(HomeActivity.this, MobilePrepaidRechargeActivity.class);
            startActivity(intent);
        } else if(position == POS_MOBILE_POSTPAID) {
            Intent intent = new Intent(HomeActivity.this, CompanyListActivity.class);
            intent.putExtra("service_id", Constants.mobile_postpaid_id);
            startActivity(intent);
        } else if(position == POS_DTH) {
            Intent intent = new Intent(HomeActivity.this, CompanyListActivity.class);
            intent.putExtra("service_id", Constants.dth_id);
            startActivity(intent);
        } else if(position == POS_DMT) {
            Intent intent = new Intent(HomeActivity.this, SenderSearchActivity.class);
            startActivity(intent);
        }  else if(position == POS_ELECTRICITY) {
            Intent intent = new Intent(HomeActivity.this, CompanyListActivity.class);
            intent.putExtra("service_id", Constants.electricity_id);
            startActivity(intent);
        } else if(position == POS_GAS) {
            Intent intent = new Intent(HomeActivity.this, CompanyListActivity.class);
            intent.putExtra("service_id", Constants.gas_id);
            startActivity(intent);
        } else if(position == POS_WATER) {
            Intent intent = new Intent(HomeActivity.this, CompanyListActivity.class);
            intent.putExtra("service_id", Constants.water_id);
            startActivity(intent);
        } else if(position == POS_RECENT_TRANSACTION) {
            Intent intent = new Intent(HomeActivity.this, RecentTransactionActivity.class);
            startActivity(intent);
        }  else if(position == POS_COMPLAIN_REPORT) {

        } else if(position == POS_ACCOUNT_LEDGER) {
            Intent intent = new Intent(HomeActivity.this, AccountLedgerActivity.class);
            startActivity(intent);
        } else if(position == POS_TRANSACTION_REPORTS) {
            Intent intent = new Intent(HomeActivity.this, AllTransactionReportsActivity.class);
            intent.putExtra("position","0");
            startActivity(intent);
        } else if(position == POS_PAYMENT_REQUEST) {

        } else if(position == POS_PARENT_USER) {

        } else if(position == POS_CHANGE_PASSWORD) {

        } else if(position == POS_NOTIFICATION) {

        } else if(position == POS_SHARE) {

        } else if(position == POS_LOGIN_WITH_OTHER_NUMBER) {

        } else if(position == POS_UPDATE_DATA) {

        } else if (position == POS_LOGOUT) {
            finish();
        }
        slidingRootNav.closeMenu();
    }
}
