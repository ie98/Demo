package com.exmaple.Demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapMergePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.exmaple.Demo.config.AlipayConfig;
import com.exmaple.Demo.model.FoodRecord;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.MidiChannel;

@RestController
@CrossOrigin("http://localhost:9000")
public class AlipayController {
    @PostMapping("/pay")
    public String pay(@RequestBody FoodRecord foodRecord) throws AlipayApiException {
        AlipayConfig alipayConfig = new AlipayConfig();
        //1 封装RSA签名方式   参数 网关 ， id ， 私钥 ， 返回格式 ， 编码格式 ， 公钥 ， 加密方式
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.gatewayUrl, alipayConfig.app_id, alipayConfig.merchant_private_key,
                alipayConfig.FORMAT, alipayConfig.charset, alipayConfig.alipay_public_key, alipayConfig.sign_type);

        //2. 创建Request请求
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();

        //3 封装传入参数
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setBody(foodRecord.getBody());  //商品描述
        model.setSubject(foodRecord.getSubject()); //商品名称
        model.setOutTradeNo(foodRecord.getOut_trade_no()); //商品ID
        model.setTotalAmount(foodRecord.getTotal_amount());  //支付金额
        model.setTimeoutExpress(foodRecord.getTimeout_express());//请求超时时间
        model.setProductCode(foodRecord.getProduct_code()); //商品code
        //4 . 设置参数
        request.setBizModel(model);
        // 异步回调地址
        request.setNotifyUrl(alipayConfig.notify_url);
        //同步回调地址
        request.setReturnUrl(alipayConfig.return_url);
        //生成表单
        String from = alipayClient.pageExecute(request).getBody();
        System.out.println(from);
        return from;
    }
}
