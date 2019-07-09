package s.com.retailermaterialapp.GlobalClasses;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class Constants {

    //services names
    public static String KEY_MOB_POSTPAID_TEXT = "Mobile Postpaid";
    public static String KEY_GAS_TEXT = "Gas";
    public static String KEY_WATER_TEXT = "water";
    public static String KEY_DMT_TEXT = "DMT";
    public static String KEY_ELECTRICITY_TEXT = "Electricity";
    public static String KEY_DTH_TEXT = "DTH";
    public static String KEY_MOB_PREPAID_TEXT = "Mobile Prepaid";
    public static String KEY_MORE_TEXT = "More";

    //service titles
    public static String KEY_TITLE_KEY_MOB_PREPAID = "Mobile Prepaid Recharge";
    public static String KEY_TITLE_KEY_MOB_POSTPAID = "Mobile Postpaid Bill Pay";
    public static String KEY_TITLE_KEY_DTH = "DTH Recharge";
    public static String KEY_TITLE_KEY_DMT = "DMT";
    public static String KEY_TITLE_KEY_ELECTRICITY = "Electricity Bill Pay";
    public static String KEY_TITLE_KEY_GAS = "Gas Bill Pay";
    public static String KEY_TITLE_KEY_WATER = "Water Bill Pay";

    //services ids
    public static String water_id = "11";
    public static String dmt_id = "21";
    public static String gas_id = "6";
    public static String electricity_id = "3";
    public static String mobile_prepaid_id = "1";
    public static String dth_id = "2";
    public static String mobile_postpaid_id = "22";
    public static String more_id = "0";

    public static String mob_prepaid_selected_name = "";
    public static String mob_prepaid_selected_number = "";
    public static String mob_prepaid_selected_company = "";
    public static String mob_prepaid_selected_circle = "";
    public static String selected_service_id = "";

    public static int dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
