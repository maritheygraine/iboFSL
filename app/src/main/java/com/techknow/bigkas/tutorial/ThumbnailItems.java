package com.techknow.bigkas.tutorial;

import com.techknow.bigkas.R;

import java.util.ArrayList;
import java.util.List;

public class ThumbnailItems {
    /**
     * Content of the array.
     */
    public static final List<Thumbnail> ITEMS = new ArrayList<Thumbnail>() {
        {
            add(new Thumbnail("Hello", "Kumusta", R.raw.hello));
            add(new Thumbnail("Bye", "Paalam", R.raw.bye));
            add(new Thumbnail("Yes", "Oo", R.raw.yes));
            add(new Thumbnail("No", "Hindi", R.raw.no));
            add(new Thumbnail("Okay", "Sige", R.raw.okay));
            add(new Thumbnail("Thank You", "Salamat", R.raw.thank_you));
            add(new Thumbnail("Welcome", "Walang anuman", R.raw.welcome));
            add(new Thumbnail("Name", "Pangalan", R.raw.name));
            add(new Thumbnail("Help", "Tulong/Tulungan", R.raw.help));
            add(new Thumbnail("Eat", "Kain/Kumain", R.raw.eat));
            add(new Thumbnail("This", "Ito", R.raw.this_sign));
            add(new Thumbnail("Sorry", "Paumanhin/Pasensya ", R.raw.sorry));
            add(new Thumbnail("Stand", "Tumayo/Tumindig", R.raw.stand));
            add(new Thumbnail("Sign", "Senyas", R.raw.sign));
            add(new Thumbnail("I love you", "Mahal kita", R.raw.i_love_you));
        }
    };
}
