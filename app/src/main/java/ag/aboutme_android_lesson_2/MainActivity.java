package ag.aboutme_android_lesson_2;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView get_fio;

    TextView my_skills;
    ImageView my_image;
    String[] firstandlast;
    String[] skills;
    TypedArray my_foto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_fio = (TextView) findViewById(R.id.get_fio);

        my_skills = (TextView) findViewById(R.id.my_skills);
        my_image = (ImageView) findViewById(R.id.my_image);
        Resources res = getResources();
        firstandlast = res.getStringArray(R.array.firstandlast);
        skills = res.getStringArray(R.array.skills);
        my_foto = res.obtainTypedArray(R.array.my_foto);
        for (String p: firstandlast) {
            Log.d("Список массива1", p);
        }
        for (String p: skills) {
            Log.d("Список массива2", p);
        }

    }

    public void onButtonClick(View view) {

        int rnd = new Random().nextInt(firstandlast.length);
        get_fio.setText(firstandlast[rnd]);
        my_image.setImageDrawable(my_foto.getDrawable(rnd));
        my_skills.setText(skills[rnd]);
    }
}
