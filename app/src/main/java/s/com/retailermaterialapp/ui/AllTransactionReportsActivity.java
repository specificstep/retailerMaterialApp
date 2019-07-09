package s.com.retailermaterialapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.legendmohe.slidingdrawabletablayout.SlidingDrawableTabLayout;

import s.com.retailermaterialapp.GlobalClasses.Constants;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.Utility.Dlog;
import s.com.retailermaterialapp.fragments.DTHListFragment;
import s.com.retailermaterialapp.fragments.MobilePostPaidListFragment;
import s.com.retailermaterialapp.fragments.MobilePrepaidListFragment;
import s.com.retailermaterialapp.fragments.PaymentListActivity;

public class AllTransactionReportsActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    ImageButton imgBack;

    private ViewPager mViewPager;
    Toolbar toolbar;
    SlidingDrawableTabLayout tabLayout;
    String pos = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transaction_reports);

        initalize();
        try{
            pos = getIntent().getStringExtra("position");
        } catch (Exception e) {
            Dlog.d(e.toString());
        }
        mViewPager.setCurrentItem(Integer.valueOf(pos));
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllTransactionReportsActivity.this.finish();
            }
        });
    }

    public void initalize() {
        toolbar = (Toolbar) findViewById(R.id.toolbarAllTransactionReports);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.containerAllTransactionReports);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (SlidingDrawableTabLayout) findViewById(R.id.tabsAllTransactionReports);
        tabLayout.setupWithViewPager(mViewPager);
        imgBack = (ImageButton) findViewById(R.id.imgAllTransactionReportsBack);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            if(position == 0) {
                return MobilePrepaidListFragment.newInstance((String) getPageTitle(position));
            } else if(position == 1){
                return MobilePostPaidListFragment.newInstance((String) getPageTitle(position));
            } else if(position == 2) {
                return DTHListFragment.newInstance((String) getPageTitle(position));
            } else if(position == 3) {
                return PaymentListActivity.newInstance((String) getPageTitle(position));
            } else {
                return MobilePrepaidListFragment.newInstance((String) getPageTitle(position));
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return Constants.KEY_MOB_PREPAID_TEXT;
                case 1:
                    return Constants.KEY_MOB_POSTPAID_TEXT;
                case 2:
                    return Constants.KEY_DTH_TEXT;
                case 3:
                    return Constants.KEY_DMT_TEXT;
            }
            return null;
        }
    }

}
