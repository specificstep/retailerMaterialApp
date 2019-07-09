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
import android.widget.TextView;

import com.github.florent37.hollyviewpager.HollyViewPagerBus;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.TransactionAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MobilePostPaidListFragment extends Fragment {

    ObservableScrollView scrollView;
    TextView title;
    View view;
    RecyclerView recyclerView;
    ImageView imgNoData;

    public MobilePostPaidListFragment() {
        // Required empty public constructor
    }

    public static MobilePostPaidListFragment newInstance(String title){
        Bundle args = new Bundle();
        args.putString("title",title);
        MobilePostPaidListFragment fragment = new MobilePostPaidListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mobile_post_paid, container, false);

        initialize();

        return view;
    }

    public void initialize() {

        scrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        title = (TextView) view.findViewById(R.id.txtMobPostPaid);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMobilePostpaid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new TransactionAdapter(getActivity(), getTransactionDemoList()));
        imgNoData = (ImageView) view.findViewById(R.id.imgMobilePostpaidNoData);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        title.setText(getArguments().getString("title"));
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
