package com.apkfuns.xprogressdialog.sample;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/17.
 */

public class MyProgressDialog extends AlertDialog {

    private String msg;

    protected MyProgressDialog(Context context) {
        super(context);
    }

    protected MyProgressDialog(Context context, String message) {
        super(context);
        msg = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundDrawable(getBackgroundDrawable());
        linearLayout.setMinimumWidth(dipToPx(getContext(), 150));
        linearLayout.setPadding(dipToPx(getContext(), 12), dipToPx(getContext(), 12), dipToPx(getContext(), 12), dipToPx(getContext(), 12));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ProgressBar progressBar = new ProgressBar(getContext());
        LinearLayout.LayoutParams progressBarParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        progressBarParams.gravity = Gravity.CENTER_HORIZONTAL;
        linearLayout.addView(progressBar, progressBarParams);

        TextView textView = new TextView(getContext());
        textView.setText(msg);
        textView.setTextColor(0xffC1C1C1);
        textView.setMaxLines(2);
        textView.setMaxWidth(dipToPx(getContext(), 150));
        LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewParams.setMargins(0, dipToPx(getContext(), 5), 0, 0);
        textViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        linearLayout.addView(textView, textViewParams);

        // 为了在window中居中
        LinearLayout rootParentLayout = new LinearLayout(getContext());
        rootParentLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        rootParentLayout.addView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setContentView(rootParentLayout);

//        setContentView(R.layout.view_xprogressdialog_circle_progress);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    private int dipToPx(Context context, float value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    private GradientDrawable getBackgroundDrawable() {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xEE515151);
        gd.setCornerRadius(dipToPx(getContext(), 8));
        return gd;
    }
}
