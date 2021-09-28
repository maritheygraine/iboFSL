package com.techknow.bigkas;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.core.util.Preconditions;

import com.google.android.material.textfield.TextInputEditText;
import com.techknow.bigkas.base.BaseFragment;

public class FingerspellingFragment extends BaseFragment {

    public FingerspellingFragment() {
        super(R.layout.fragment_fingerspelling);
    }

    @Override
    public void initView(View view) {
        final TextInputEditText editText = view.findViewById(R.id.edit_text);
        /**
         * Clears the text field when clear button is clicked.
         */
        view.findViewById(R.id.clear_btn).setOnClickListener(e -> {
            String input = getInputs(editText);
            if (!TextUtils.isEmpty(input)) {
                assert editText.getText() != null;
                editText.getText().clear();
            }
        });

        final TextView fingerSpellText = view.findViewById(R.id.fingerspell_view);

        /**
         * Get the input of the user from the editText then
         * set the text to the translated view with different the FSL font.
         */
        view.findViewById(R.id.translate_btn).setOnClickListener(e -> {
            final String inputs = getInputs(editText);

            fingerSpellText.setText(inputs);
        });

    }

    @SuppressWarnings("ConstantConditions")
    private static String getInputs(TextInputEditText editText) {
        return editText.getText().toString();
    }
}