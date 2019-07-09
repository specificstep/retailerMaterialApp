package s.com.retailermaterialapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import s.com.retailermaterialapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialRechargeBrowsePlansFragment extends Fragment {


    public SpecialRechargeBrowsePlansFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_special_recharge_browse_plans, container, false);
    }

}
