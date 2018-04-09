package com.example.a46639.testdownload;

import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Timeout;

/**
 * Created by 46639 on 2018/3/14.
 */

public class HttpUtil {

    //使用Get方式获取服务器上数据
   /* public static void sendOkHttpRequest(final String address, final okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        Call call=client.newCall(request);
        call.enqueue(callback);
       // client.newCall(request).enqueue(callback);

    }*/

    public static Call sendOkHttpRequest(final String address, final okhttp3.Callback callback) {
        //OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        OkHttpClient client=new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2,TimeUnit.MINUTES)
                .build();
        Call call=client.newCall(request);
        call.enqueue(callback);
        // client.newCall(request).enqueue(callback);
        return call;

    }

    //使用Post方式向服务器上提交数据并获取返回提示数据
    public static void sendOkHttpResponse(final String address, final RequestBody requestBody, final okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
//        JSONObject object;
        Request request = new Request.Builder()
                .url(address).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }

    public static Response getOKhttp(final String address) throws IOException {
        OkHttpClient client =new OkHttpClient();
        Request request=new Request.Builder()
                .url(address)
                .build();
       return client.newCall(request).execute();
    }
}
