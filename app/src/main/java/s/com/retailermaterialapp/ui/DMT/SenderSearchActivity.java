package s.com.retailermaterialapp.ui.DMT;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import s.com.retailermaterialapp.R;

public class SenderSearchActivity extends AppCompatActivity {

    ImageButton btnBack;
    EditText edtMobile;
    Button btnSearch;
    BottomSheetDialog dialogError;
    public static String senderMobile = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_search);

        initialize();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SenderSearchActivity.this.finish();
            }
        });

        edtMobile.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senderMobile = edtMobile.getText().toString();
                if(edtMobile.getText().toString().equals("4444444444")) {
                    Intent intent = new Intent(SenderSearchActivity.this, BeneficiaryListActivity.class);
                    startActivity(intent);
                } else {
                    showErrorDialog();
                }
            }
        });

    }

    public void initialize() {
        btnBack = (ImageButton) findViewById(R.id.imgSenderSearchBack);
        edtMobile = (EditText) findViewById(R.id.edtSenderSearchMobile);
        btnSearch = (Button) findViewById(R.id.btnSenderSearch);
        dialogError = new BottomSheetDialog(SenderSearchActivity.this);
        dialogError.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void showErrorDialog() {
        dialogError.setContentView(R.layout.popup_dmt_search_error);
        FrameLayout bottomSheet = (FrameLayout) dialogError.findViewById(android.support.design.R.id.design_bottom_sheet);
        BottomSheetBehavior.from(bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
        dialogError.getWindow().getAttributes().windowAnimations = R.style.Animation;

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogError.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        dialogError.setCanceledOnTouchOutside(false);
        Button add_sender = (Button) dialogError.findViewById(R.id.btnDMTAddSender);
        Button try_again = (Button) dialogError.findViewById(R.id.btnDMTTryAgain);
        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogError.dismiss();
            }
        });
        add_sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SenderSearchActivity.this,AddSenderActivity.class);
                startActivity(intent);
                dialogError.dismiss();
            }
        });
        dialogError.show();
    }

}
