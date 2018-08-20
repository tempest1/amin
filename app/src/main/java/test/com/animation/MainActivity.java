package test.com.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn10 = (Button)findViewById(R.id.btn10);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                //透明度度动画

                //1.创建透明度动画对象，数值越小越透明
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0.1f);
                //设置动画的持续时间
                alphaAnimation.setDuration(3000);
                //设置是否保留最终状态
                alphaAnimation.setFillAfter(true);
                //设置重复次数，填-1无限循环
                alphaAnimation.setRepeatCount(1);
                //设置动画的重复模式，默认是Restart,Reverse是反方向执行
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                //通过控件启动动画
                img.startAnimation(alphaAnimation);

                break;
            case R.id.btn2:
                //缩放

                //相对控件自己的左上角为原点缩放
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 2, 0.2f, 2);
                //相对点（200，300）进行缩放
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f,2,0.2f,2,200,300);
                //相对控件自己的中心点进行缩放
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f,2,0.2f,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);


                //相对父容器的中心点进行缩放
                // fromX：开始缩放的X轴倍数。如1.0f：本身大小；如2.0f：从自己两倍开始
                // toX：结束缩放的X轴倍数。同上...
                // fromY：始缩放的Y轴倍数。
                // toY：结束缩放的Y轴倍数。
                /** pivotXType：X轴缩放中心点类型；可选值有：
                 Animation.RELATIVE_TO_SELF相对自己--常用
                 Animation.RELATIVE_TO_PARENT相对父窗体
                 Animation.ABSOLUTE 绝对的---不常用
                 */

                // pivotXValue：在pivotXType的基础上，X轴缩放中心的位置。如：0.5f：缩放中心就在控件的一半的位置。如果是0.0f，则会在控件本身的左边位置
                // pivotYType：X轴缩放中心点类型；同上 ...
                // pivotYValue：在pivotYType的基础上，Y轴缩放中心的位置。

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 2, 0.5f, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(3000);
                scaleAnimation.setFillAfter(true);
                img.startAnimation(scaleAnimation);

                break;
            case R.id.btn3:
                //旋转

                //相对自己的左上角旋转，正数代表顺时针，负数逆时针
                RotateAnimation rotateAnimation = new RotateAnimation(0,-180);
                //相对(200,300)点旋转

                //相对于中心旋转
                //RotateAnimation rotateAnimation = new RotateAnimation(0,-180,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

                //RotateAnimation rotateAnimation = new RotateAnimation(0,-180,200,300);
                rotateAnimation.setDuration(3000);
                img.startAnimation(rotateAnimation);

                break;
            case R.id.btn4:
                //平移

/*new TranslateAnimation(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
        例如：从控件自己的位置开始，向下移动自己的一倍距离。*/
                //TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                //       Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1f);
//        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,0);
                //获得屏幕宽度：
                int screenWidth = getResources().getDisplayMetrics().widthPixels;
                int imgeWidth = img.getWidth();
                //TranslateAnimation translateAnimation = new TranslateAnimation(0,screenWidth-imgeWidth,0,0);
                TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,0);
                translateAnimation.setDuration(3000);
                translateAnimation.setFillAfter(true);
                img.startAnimation(translateAnimation);

                break;
            case R.id.btn5:
                //透明动画
                Animation alpha_anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
                img.setAnimation(alpha_anim);
                img.startAnimation(alpha_anim);
                break;
            case R.id.btn6:
                //缩放动画
                Animation scale_anim = AnimationUtils.loadAnimation(this, R.anim.scale);
                img.setAnimation(scale_anim);
                img.startAnimation(scale_anim);
                break;
            case R.id.btn7:
                //旋转
                Animation rotate_anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
                img.setAnimation(rotate_anim);
                img.startAnimation(rotate_anim);
                break;
            case R.id.btn8:

                Animation translat_anim = AnimationUtils.loadAnimation(this, R.anim.translat);
                img.setAnimation(translat_anim);
                img.startAnimation(translat_anim);
                break;
            case R.id.btn9:
                img.setImageResource(R.drawable.animation_img);
                //给动画资源赋值
                animationDrawable = (AnimationDrawable) img.getDrawable();
                animationDrawable.start();//开始
                break;
            case R.id.btn10:
                animationDrawable = (AnimationDrawable) img.getDrawable();
                animationDrawable.stop();//结束
                break;
        }
    }
}
