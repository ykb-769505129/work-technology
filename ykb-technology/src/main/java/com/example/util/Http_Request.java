package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 主动请求其他接口
 * @author 76950
 */
@Component
public class Http_Request {

    /**
     * 该接口也可以调用PUT请求方式的接口，只需要在请求方式里将POST改为PUT即可
     * http调用post接口
     * @param methodUrl 请求地址
     * @param param 参数（Json字符串）
     * @return
     */
    public static JSONObject postInterface(String param, String methodUrl){
        try {
            URL url = new URL(methodUrl);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式 这里设置你需要请求的方式
            conn.setRequestMethod("POST");
            //有些参数可以放在Head里,比如Token什么的
            //conn.setRequestProperty("Token","");
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            //  这里设置请求头
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
//            conn.connect();
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(param);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            JSONObject jsonss = null;
            while ((str = br.readLine()) != null) {
                jsonss = JSONObject.parseObject(str);
            }
            System.out.println("获取到的报文数据为："+jsonss);
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被
            //其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上
            //disconnect后正常一些。
            conn.disconnect();
            System.out.println("结束");
            return jsonss;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  ****************************************************************************************************************
     */


    //平安辛子寨 用到的方法，具体可行否看实际情况，可用概率应该较低
    /**
     * 请根据技术支持提供的实际的平台IP/端口和API网关中的合作方信息更换static静态块中的三个参数.
     * [1 host]
     * 		host格式为IP：Port，如10.0.0.1:443
     * 		当使用https协议调用接口时，IP是平台（nginx）IP，Port是https协议的端口；
     *     当使用http协议调用接口时，IP是artemis服务的IP，Port是artemis服务的端口（默认9016）。
     * [2 appKey和appSecret]
     * 		请按照技术支持提供的合作方Key和合作方Secret修改
     * 	    appKey：合作方Key
     * 	    appSecret：合作方Secret
     * 调用前看清接口传入的是什么，是传入json就用doPostStringArtemis方法，是表单提交就用doPostFromArtemis方法
     *
     */
    static {
        ArtemisConfig.host = "124.93.23.27:443"; // 平台/nginx的IP和端口（https端口默认为443）
        ArtemisConfig.appKey = "23833075"; // 合作方Key
        ArtemisConfig.appSecret = "GUGxBbxpXPqP6gQ3QTD8";// 合作方Secret
    }

    /**
     * API网关的后端服务上下文为：/artemis
     */
    private static final String ARTEMIS_PATH = "/artemis";

    /**
     * 调用POST请求类型接口，这里以分页获取区域列表为例
     * 接口实际url：https://ip:port/artemis/api/api/resource/v1/regions
     * @param b 请求的参数
     * @return
     */
    public static String calltest(String b){
        /**
         * https://ip:port/artemis/api/resource/v1/regions
         * 过查阅AI Cloud开放平台文档或网关门户的文档可以看到分页获取区域列表的定义,这是一个POST请求的Rest接口, 入参为JSON字符串，接口协议为https。
         * ArtemisHttpUtil工具类提供了doPostStringArtemis调用POST请求的方法，入参可传JSON字符串, 请阅读开发指南了解方法入参，没有的参数可传null
         */
        String getCamsApi = ARTEMIS_PATH + "/api/v1/alarm/deviceAlarm/findAlarmPage";
        String body = JSON.toJSON(b).toString();
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", getCamsApi);
            }
        };
        String result;
        try {
            result = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, "application/json");
        }catch (Exception e){
            result = null;
        }
        return result;
    }

}
