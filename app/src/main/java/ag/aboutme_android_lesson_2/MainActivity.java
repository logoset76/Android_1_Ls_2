package ag.aboutme_android_lesson_2;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toast mCurrentToast;

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
    String[] contacts;

// Dobavlyaem MENU *********

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.CopyAll:
                copyAll();
                showToast("CopyAll successfully copied");
                return true;
            case R.id.CopyName:
                copyName();
                showToast("CopyName successfully copied");
                return true;
            case R.id.CopyContacts:
                copyContacts();
                showToast("Contacts successfully copied");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void copyContacts(CharSequence ch) {
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

        CharSequence clipText = get_fio.toString()+ my_skills.toString() + my_contacts.toString();
        ClipData clip = ClipData.newPlainText(ch, clipText);
        clipboard.setPrimaryClip(clip);
    }

    private void copyName(CharSequence ch) {
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(ch, get_fio.toString());
        clipboard.setPrimaryClip(clip);

    }

    private void copyAll()(CharSequence ch) {
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(ch, my_contacts.toString());
        clipboard.setPrimaryClip(clip);
    }

    private void showToast(String s) {

        if (mCurrentToast != null) {mCurrentToast.cancel();}
        mCurrentToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        mCurrentToast.show();
    }

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
                            linearLayout1.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left));

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
                            linearLayout2.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left));

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
                            linearLayout3.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.slide_in_left));
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
