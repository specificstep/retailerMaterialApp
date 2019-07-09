package s.com.retailermaterialapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.hollyviewpager.HollyViewPagerBus;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import butterknife.ButterKnife;
import s.com.retailermaterialapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScrollViewFragment extends Fragment {

    ObservableScrollView scrollView;
    TextView title;
    View view;

    public ScrollViewFragment() {
        // Required empty public constructor
    }

    public static ScrollViewFragment newInstance(String title){
        Bundle args = new Bundle();
        args.putString("title",title);
        ScrollViewFragment fragment = new ScrollViewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_scroll_view, container, false);

        initialize();

        return view;
    }

    public void initialize() {

        scrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        title = (TextView) view.findViewById(R.id.title);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        title.setText(getArguments().getString("title"));
        HollyViewPagerBus.registerScrollView(getActivity(), scrollView);
    }

}
