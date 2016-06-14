package ggikko.me.listpopupmenuapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drop) Button drop;

    @OnClick(R.id.drop)
    void callDropMenu(){
        PopupWindow popupwindow_obj = popupDisplay();
        popupwindow_obj.showAsDropDown(drop, -40, 18); // where u want show on view click event popupwindow.showAsDropDown(view, x, y);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    public PopupWindow popupDisplay()
    {

        final PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setAnimationStyle(R.style.animationName);

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.dropdownlayout, null);

        Button item = (Button) view.findViewById(R.id.button1);

        popupWindow.setFocusable(true);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);

        return popupWindow;
    }

}
