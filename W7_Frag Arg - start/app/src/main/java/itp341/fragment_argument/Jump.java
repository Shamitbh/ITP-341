package itp341.fragment_argument;

import android.animation.ObjectAnimator;

/**
 * Created by R on 2/15/2016.
 */
public class Jump {
    public static void animation(Object o){
        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(o,"y", 0 , 50).setDuration(500);
        //Animator places object at 0 and takes it 50 from the top view
        //Pressing quickly creates jumping illusion
        //Adding more int values such as 0, 50, 0 will animate from 0, 50, to 0.
        heightAnimator.start();
    }

}
