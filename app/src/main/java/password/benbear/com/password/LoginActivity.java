package password.benbear.com.password;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import password.benbear.com.password.view.*;
import password.benbear.com.password.view.GestureLockViewGroup.OnGestureLockViewListener;
import android.content.Intent;

public class LoginActivity extends Activity
{
    private GestureLockViewGroup mGestureLockViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mGestureLockViewGroup = (GestureLockViewGroup) findViewById(R.id.id_gestureLockViewGroup);
        mGestureLockViewGroup.setAnswer(new int[] { 1, 2, 3, 4,5 });
        mGestureLockViewGroup.setOnGestureLockViewListener(new OnGestureLockViewListener()
            {
                @Override
                public void onUnmatchedExceedBoundary()
                {
                    Toast.makeText(LoginActivity.this, "错误5次...",Toast.LENGTH_SHORT).show();
                    mGestureLockViewGroup.setUnMatchExceedBoundary(5);
                }

                @Override
                public void onGestureEvent(boolean matched)
                {
                    Toast.makeText(LoginActivity.this, matched+"", Toast.LENGTH_SHORT).show();

                    if(matched)
                    {
                        Intent intent2=new Intent();
                        intent2.setClass(getBaseContext(),MainActivity.class);
                        startActivity(intent2);
                    }
                }

                @Override
                public void onBlockSelected(int cId)
                {
                }
            });
    }

}
