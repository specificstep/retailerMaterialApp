package s.com.retailermaterialapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.PoplarBrowsePlanAdapter;
import s.com.retailermaterialapp.adapter.TransactionAdapter;
import s.com.retailermaterialapp.ui.MobilePrepaidRechargeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopularBrowsePlansFragment extends Fragment {

    ImageView imgNoData;
    View view;
    RecyclerView recyclerView;

    public PopularBrowsePlansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_popular_browse_plans, container, false);

        initialize();

        return view;
    }

    public void initialize() {
        imgNoData = (ImageView) view.findViewById(R.id.imgPopularNoData);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcvPopularBrowsePlan);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new PoplarBrowsePlanAdapter(getActivity(), getTransactionDemoList()));
    }

    private ArrayList<String> getTransactionDemoList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1699");
        list.add("999");
        list.add("599");
        list.add("459");
        return list;
    }

}
