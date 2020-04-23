package com.exmaple.Demo.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092900622741";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDC3fAzsmu4QXofvcrmezFmcSvHbprLV16qc9+w0fGvd/Hyt8PfxQXLBXvc/aLflxhVDpwpMTDCTs8F/ALuqY2z+D1RkiVnmnBkHK9W8yeeWgLvBCgM3XsCUYF0cfc9B4Pr4WU60w1GmCDNNk6HE0tuUcfI98siyVFjs8Icfyr+ZKWnkuk1VLd6pXRCdfMowh5u/5vmyE8V4PtP6Beb6pVY6C4/L/1/KWr9KpKRTXjGRxWkDzlu55mcshR9KVFP3Uce/zUvqI7RgJ5gqKEPRN217U7AVvCGTOlRDBYvxamlpnhJws+XuU3D/zY0wizjszin3MmrQiCtOXtrFM8d1F6RAgMBAAECggEAThiWQJG7/A85u2jb3Tz4El8+tWGNZfrw9I0V1A5/ttvyOl0Ngiu645+iAXIhCUzLsqL1UMjnCqh87aAPKMkJAlx1brCMjxXk/ypD1ywB78ORM2tOBcHpn4c8w4c9F9dgNnORl16oDme/lZ6zIA1KiL77u34biih2luee3r7UYzkM53Or/234UCuNeNz0sOplYOjKRN8FEEY9ldBqqymr6Hhcbl9zxLaGUwQaxpC7coq08r3+ooy/NZlZG6wBLEwOXc2aFkzIPqn/bj2xuxZV+KIuWtvJ9+7dyzdUg7mhXqi7bbXgXkbCxtFtGXMuSTFXsOKh5kXN/x2vSolpCUPeAQKBgQD4RLpKVQIfhYrZ8dvKBrc5/42VIBfVieBc3D8bstiZveSu5PMve9I2q+nFWb5gLIPHKiEXy8zSY4VELy4vYbrWl6c1guczKgyw//xbwnrKuvU+zAqy/mgvonz1PTT9SyTOS2cWtgfYP7unpAm2w/dwIBTdgeZf32XRYLZ9IHgIIQKBgQDI73owaicRG+NGDLOkp9ORCeRJXqEsRXO4bTAtZirRKCKXPBn83UbH1wEjMmXgb9SkL3STQpkC8swyR4SLasFJYIrAXsg2538slVfui7RRlZxEV8+1AA3DFjSaWm98BCsSkBRz5uWQoupnU2uNSdpmMU3YhczQQ2LewkOyNp/IcQKBgQDpsAeKICo3cYQZUccIivm85gdm7yaAIZ/GyKm+cMHhNRUkau1dLLfaLkeFM8w2yq/fsJAlzfelsXenjqFyiBNOGsGRZP4q8tGvacUoug7K9OATlAweH8oBzHjCfjJ6mViztdX7UqxfqN4CFi3uktc9+3Soa7VlWOqGAvrDHOTfAQKBgGD2/9YhQ90Dwjdppb9NpdEWHu4xFkIQ+fkD5/3gkcUBQ0AMJtZZyfBiFxBvH66hCNJ6fB0cRE6h8FxLGvFUgRXx2sNeeevU5xASua5KCKheNFzeq0NDVWDRdG0QO0Bzmn2IvfX4dMvJcqiOHxa9jwFFxbU5TE8sVaf9w0FbDtxhAoGAXhXXC1cN8VGIsfqobcxlaUAHBNKkqbdvRYMmYZCOCld26aFTUU7KlZXRQRhKA9Mm7KGueNaT68S1rUUdwGGrZSCNiPPvlq9+eA0ozyZGIdkhfupNmsLZWMrUaOkvX8g1u51IoRltLDtkHwdVkZQMyP8ODZlXFDGFH1spVR/fn7I=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwt3wM7JruEF6H73K5nsxZnErx26ay1deqnPfsNHxr3fx8rfD38UFywV73P2i35cYVQ6cKTEwwk7PBfwC7qmNs/g9UZIlZ5pwZByvVvMnnloC7wQoDN17AlGBdHH3PQeD6+FlOtMNRpggzTZOhxNLblHHyPfLIslRY7PCHH8q/mSlp5LpNVS3eqV0QnXzKMIebv+b5shPFeD7T+gXm+qVWOguPy/9fylq/SqSkU14xkcVpA85bueZnLIUfSlRT91HHv81L6iO0YCeYKihD0Tdte1OwFbwhkzpUQwWL8WppaZ4ScLPl7lNw/82NMIs47M4p9zJq0IgrTl7axTPHdRekQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "https://www.baidu.com";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    //返回格式
    public static  String FORMAT = "json";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

