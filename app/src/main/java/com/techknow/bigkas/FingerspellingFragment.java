package com.techknow.bigkas;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.techknow.bigkas.base.BaseFragment;

public class FingerspellingFragment extends BaseFragment {

    public FingerspellingFragment() {
        super(R.layout.fragment_fingerspelling);
    }

    @Override
    public void initView(View view) {
        final TextInputEditText editText = view.findViewById(R.id.edit_text);

        view.findViewById(R.id.clear_btn).setOnClickListener(e -> {
            String input = getInputs(editText);
            if (!TextUtils.isEmpty(input)) {
                assert editText.getText() != null;
                editText.getText().clear();
            }
        });

        final TextView fingerSpellText = view.findViewById(R.id.fingerspell_view);

        view.findViewById(R.id.translate_btn).setOnClickListener(e -> {
            final String inputs = getInputs(editText);

            fingerSpellText.setText(inputs);
        });

    }

    private static String getInputs(TextInputEditText editText) {
        return editText.getText().toString();
    }
}