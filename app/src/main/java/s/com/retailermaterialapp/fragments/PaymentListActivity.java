package s.com.retailermaterialapp.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.florent37.hollyviewpager.HollyViewPagerBus;

import java.util.ArrayList;

import butterknife.ButterKnife;
import s.com.retailermaterialapp.R;
import s.com.retailermaterialapp.adapter.DMTPaymentListAdapter;

public class PaymentListActivity extends Fragment {

    RecyclerView recyclerView;
    TextView title;
    View view;

    public PaymentListActivity() {
        // Required empty public constructor
    }

    public static PaymentListActivity newInstance(String title){
        Bundle args = new Bundle();
        args.putString("title",title);
        PaymentListActivity fragment = new PaymentListActivity();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_payment_list, container, false);

        initialize();

        return view;
    }

    public void initialize() {
        recyclerView = (RecyclerView) view.findViewById(R.id.rcvDMTTransactionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new DMTPaymentListAdapter(getActivity(), getTransactionDemoList()));
        title = (TextView) view.findViewById(R.id.txtDMTTransactionList);
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
