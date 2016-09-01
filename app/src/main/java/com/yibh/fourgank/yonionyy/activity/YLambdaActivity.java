package com.yibh.fourgank.yonionyy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yibh.fourgank.R;
import com.yibh.fourgank.utils.ToastSnackUtil;

import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * java8 lambda 语法测试
 * 参考: http://note.youdao.com/noteshare?id=568d95891776dcedbb3aa61046fb44e4
 */
public class YLambdaActivity extends BaseActivity {

    @BindView(R.id.but1)
    Button mButton1;


    public static void startYYActivity(Context context) {
        Intent intent = new Intent(context, YLambdaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_yy;
    }

    @Override
    protected void initData() {
        //普通的点击
        mButton1.setOnClickListener(v -> ToastSnackUtil.snackbarShort(mButton1, "我是第一个点击!"));

    }

    @OnClick(R.id.but2)
    protected void runnableTest(View v) {
        new Thread(() -> ToastSnackUtil.snackbarShort(v, "我是第Runnable测试!")).start();
    }

    @OnClick(R.id.but3)
    protected void forTest1(View view) {

        /*-----------------API24才能用---------------------*/
//        List<String> yList= Arrays.asList("Android","Java","Ios","Python");
//        yList.forEach(o -> System.out.print(o));
//
//        yList.stream().map(o -> o + " 加个尾巴~").collect(Collectors.toList()).forEach(s -> System.out.print(s));

        //普通写法
//        Comparator testComparator=new Comparator() {
//            @Override
//            public int compare(Object o, Object t1) {
//                return 0;
//            }
//        };
        /*------------------------*/


        /*----------嵌套--------------*/
        //嵌套
        Callable<Runnable> callable1 = new Callable<Runnable>() {
            @Override
            public Runnable call() throws Exception {
                return new Runnable() {
                    @Override
                    public void run() {
                        ToastSnackUtil.snackbarShort(view, "其实我也不知道这是什么鬼...");
                    }
                };
            }
        };

        try {
            Callable<Runnable> callable = () -> () -> ToastSnackUtil.snackbarShort(view, "其实我也不知道这是什么鬼...");
            callable.call().run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*------------------------*/

        /*-----------条件表达式-------------*/
        //条件表达式
        Callable<Integer> integerCallable = true ? (() -> 42) : (() -> 24);

        Callable<Integer> integerCallable1 = true ? (new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42;
            }
        }) : (new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 24;
            }
        });


        /*------------------------*/

        /*----------方法引用--------------*/
        /**方法引用
         * Integer::parseInt //静态方法引用
         * System.out::print //实例方法引用
         * Person::new       //构造器引用
         */

//        //静态方法引用
//        Comparator<Integer> integerComparator=new Comparator<Integer>() {
//            @Override
//            public int compare(Integer t1, Integer t2) {
//                return Integer.compare(t1,t2);
//            }
//        } ;
//        //lambda一般写法
//        Comparator<Integer> yComparator=(a, b)->Integer.compare(a,b);
//        //lambda 方法引用写法
//        Comparator<Integer> yComparator1 = Integer::compare;


        //实例方法引用
//        List<String> yList= Arrays.asList("Android","Java","Ios","Python");
//        yList.forEach();//api24以下不能用

//        TestBean testBean = new TestBean("yibh", "男", 1);
//        List<TestBean> mTestBeenList=Arrays.asList(testBean,testBean,testBean);
//        mTestBeenList.forEach(TestBean::toString);

        /*------------------------*/

        new Handler().postDelayed(() -> Log.w("测试", "测试msg"), 3000);

    }




}
