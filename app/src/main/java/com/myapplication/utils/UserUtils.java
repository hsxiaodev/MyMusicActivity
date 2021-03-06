package com.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.blankj.utilcode.util.RegexUtils;
import com.myapplication.R;
import com.myapplication.activitys.LoginActivity;

public class UserUtils {

    /**
     * 验证登录用户合法性
     */
    public static boolean validateLogin(Context context,String phone,String password ){

//        RegexUtils.isMobileSimple(phone);//简单的

        //精确的
        if (!RegexUtils.isMobileExact(phone)){
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 退出登录
     */
    public static void logout(Context context){
        Intent intent=new Intent(context, LoginActivity.class);
        //添加intent标志符，清理task栈，并且新生成一个task栈
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        //定义Activity跳转动画
        ((Activity)context).overridePendingTransition(R.anim.open_enter,R.anim.open_exit);
    }
}
