package ggikko.me.listpopupmenuapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drop) Button drop;

    PopupWindow popupWindow;

    @OnClick(R.id.drop)
    void callDropMenu(){

        if(popupWindow != null){
            Log.e("ggikko","koko1");
            popupWindow.dismiss();
            popupWindow = null;
        }else{
            Log.e("ggikko","koko2");
            popupDisplay();
             // where u want show on view click event popupwindow.showAsDropDown(view, x, y);
        }
        Log.e("ggikko","koko3");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public PopupWindow popupDisplay()
    {

        popupWindow = new PopupWindow(this);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setAnimationStyle(R.style.animationName);

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dropdownlayout, null);

        Button item = (Button) view.findViewById(R.id.button1);

//        popupWindow.setFocusable(true);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        popupWindow.showAsDropDown(drop, -92, -8);
//        popupWindow.showAtLocation(drop, Gravity.TOP|Gravity.RIGHT, 0, 18);

        return popupWindow;
    }

}
