package ag.aboutme_android_lesson_2;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView get_fio;
    ListView my_skills;
    ListView my_contacts;

    ImageView my_image;

    Button btt1;
    Button btt2;
    Button btt3;

    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    LinearLayout linearLayout3;

    String[] fio;
    String[] skills;
    String [] contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Interpolator over = new OvershootInterpolator(3);

        get_fio = (ListView) findViewById(R.id.get_fio);
        my_skills = (ListView) findViewById(R.id.my_skills);
        my_contacts = (ListView) findViewById(R.id.my_contacts);

        my_image = (ImageView) findViewById(R.id.my_image);

        btt1 = (Button) findViewById(R.id.btt1);
        btt2 = (Button) findViewById(R.id.btt2);
        btt3 = (Button) findViewById(R.id.btt3);

        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        linearLayout3 = (LinearLayout) findViewById(R.id.linearLayout3);

        my_image.setImageResource(R.drawable.brunya1);
        Resources res = getResources();
        fio = res.getStringArray(R.array.fio);
        skills = res.getStringArray(R.array.skills);
        contacts = res.getStringArray(R.array.contacts);

        for (String p : fio) {
            Log.d("Список массива ФИО", p);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fio);
            get_fio.setAdapter(adapter);
        }
        for (String p : skills) {
            Log.d("Список массива НАВЫКИ", p);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, skills);
            my_skills.setAdapter(adapter);
        }
        for (String p : contacts) {
            Log.d("Список массива КОНТАКТЫ", p);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
            my_contacts.setAdapter(adapter);
        }

        btt1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (linearLayout1 != linearLayout2) {
                    switch (event.getAction()) {
                        case 0:
                            Log.d("Сработал ФИО", "DOWN");
                            btt1.animate().scaleX(0.75f).scaleY(0.75f).setDuration(750);
                            linearLayout1.setVisibility(View.VISIBLE);
                            linearLayout2.setVisibility(View.GONE);
                            linearLayout3.setVisibility(View.GONE);
                            break;
                        case 1:
                            Log.d("Сработал ФИО", "UP");
                            btt1.animate().scaleX(1f).scaleY(1f).setDuration(750).setInterpolator(over);
                            break;
                    }

                }
                return false;

            }
        });

        btt2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (linearLayout1 != linearLayout2) {
                    switch (event.getAction()) {
                        case 0:
                            Log.d("Сработал НАВЫКИ", "DOWN");
                            btt2.animate().scaleX(0.75f).scaleY(0.75f).setDuration(750);
                            linearLayout1.setVisibility(View.GONE);
                            linearLayout2.setVisibility(View.VISIBLE);
                            linearLayout3.setVisibility(View.GONE);
                            break;
                        case 1:
                            Log.d("Сработал НАВЫКИ", "UP");
                            btt2.animate().scaleX(1f).scaleY(1f).setDuration(750).setInterpolator(over);
                            break;
                    }

                }
                return false;

            }
        });
        btt3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (linearLayout1 != linearLayout2) {
                    switch (event.getAction()) {
                        case 0:
                            Log.d("Сработал КОНТАКТЫ", "DOWN");
                            btt3.animate().scaleX(0.75f).scaleY(0.75f).setDuration(750);
                            linearLayout1.setVisibility(View.GONE);
                            linearLayout2.setVisibility(View.GONE);
                            linearLayout3.setVisibility(View.VISIBLE);
                            break;
                        case 1:
                            Log.d("Сработал КОНТАКТЫ", "UP");
                            btt3.animate().scaleX(1f).scaleY(1f).setDuration(750).setInterpolator(over);
                            break;
                    }

                }
                return false;

            }
        });
    }
}
