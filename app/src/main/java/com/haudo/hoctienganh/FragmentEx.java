package com.haudo.hoctienganh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 8/18/2017.
 */

public class FragmentEx extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_1, container, false);
    }

   /* private void customTextView(TextView view) {
        SpannableStringBuilder spanTxt = new SpannableStringBuilder(
                getString(R.string.check_dieukhoan_1));
        spanTxt.append(" " + "Welcome to Spotlight. I'm Colin Lowther");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        }, spanTxt.length() - getString(R.string.dieu_khoan_su_dung).length(), spanTxt.length(), 0);
        spanTxt.append(" " + getString(R.string.va));
        spanTxt.append(" " + getString(R.string.quy_tac_bao_hiem));
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        }, spanTxt.length() - getString(R.string.quy_tac_bao_hiem).length(), spanTxt.length(), 0);
        spanTxt.append(" " + getString(R.string.check_dieukhoan_2));
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(spanTxt, TextView.BufferType.SPANNABLE);
    }*/
}
