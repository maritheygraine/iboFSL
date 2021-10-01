package com.techknow.bigkas.voice;

import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

    public class VoiceFeedback extends AppCompatActivity {
        private TextToSpeech mTTS;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mTTS = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS){
                        mTTS.setLanguage(Locale.ENGLISH);
                    }
                }
            });
        }
        public void speak(String text){
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }

}
