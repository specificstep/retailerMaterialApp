package s.com.retailermaterialapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.fragments.PopularBrowsePlansFragment;
import s.com.retailermaterialapp.fragments.SpecialRechargeBrowsePlansFragment;
import s.com.retailermaterialapp.fragments.TopupBrowsePlansFragment;

public class BrowsePlanActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageButton imgCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_plan);

        initialize();
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowsePlanActivity.this.finish();
                overridePendingTransition(R.anim.no_change,R.anim.slide_out);
            }
        });

    }

    public void initialize() {
        viewPager = (ViewPager) findViewById(R.id.viewpagerBrowsePlans);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabsBrowsePlans);
        tabLayout.setupWithViewPager(viewPager);
        imgCancel = (ImageButton) findViewById(R.id.imgBrowsePlanCancel);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new PopularBrowsePlansFragment(), "Popular");
        adapter.addFrag(new SpecialRechargeBrowsePlansFragment(), "Special Recharge");
        adapter.addFrag(new TopupBrowsePlansFragment(), "Top Up");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.no_change,R.anim.slide_out);
    }
}
