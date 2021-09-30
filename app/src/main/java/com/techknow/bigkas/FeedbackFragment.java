package com.techknow.bigkas;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.android.material.textfield.TextInputEditText;
import com.techknow.bigkas.base.BaseFragment;

public class FeedbackFragment extends BaseFragment {

    public FeedbackFragment() {
        super(R.layout.fragment_feedback);
    }

    @Override
    public void initView(View view) {

        super.toolbarPopBackStack(view.findViewById(R.id.toolbar));

        TextInputEditText body = view.findViewById(R.id.feedback_edit_text);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);

        view.findViewById(R.id.translate_btn).setOnClickListener(e -> {
            String inputText = getInputs(body);

            if (!TextUtils.isEmpty(inputText)) {
                assert body.getText() != null;

                String s = String.valueOf(ratingBar.getRating());
                /**
                 * Making an email in-app then redirect it to an email client
                 */
                Intent sendMail = new Intent();
                sendMail.setData(Uri.parse("mailto:"));
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"techknow.feutech@gmail.com"});                    // receiver of the email
                intent.putExtra(Intent.EXTRA_SUBJECT, "Customer Feedback");                                   // subject of the email
                intent.putExtra(Intent.EXTRA_TEXT, "My rating of Bigkas App is "+s+"\n\n"+body.getText().toString());
                intent.setSelector( sendMail );
                startActivity(Intent.createChooser(intent, "Choose an Email Client"));                         // make user choose an email client like gmail/ymail
            }
        });
    }

    private static String getInputs(TextInputEditText editText) {
        return editText.getText().toString();
    }
}