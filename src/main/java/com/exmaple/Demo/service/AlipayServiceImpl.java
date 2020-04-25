package com.exmaple.Demo.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.exmaple.Demo.config.AlipayConfig;
import com.exmaple.Demo.config.RedisConfig;
import com.exmaple.Demo.dto.CartItem;
import com.exmaple.Demo.dto.Meta;
import com.exmaple.Demo.mapper.FoodRecordMapper;
import com.exmaple.Demo.model.FoodRecord;
import com.exmaple.Demo.model.RedisCart;
import com.exmaple.Demo.util.Jackson;
import com.exmaple.Demo.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;


@Service
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    private FoodRecordMapper foodRecordMapper;
    @Autowired
    private RedisTemplate<String ,Object> redisTemplate;
    @Override
    public String pay(FoodRecord foodRecord) throws AlipayApiException, JsonProcessingException {
        if (foodRecord == null){
            return Jackson.classtoJson(new Meta("ERROR"));
        }
        Boolean bool =  foodRecordMapper.insertFoodRecord(foodRecord);  // 存入数据库
        if (!bool){
            return Jackson.classtoJson(new Meta("ERROR"));
        }
//        for (int i = 0; i < foodRecord.getDates().size(); i++) {
//            System.out.println(foodRecord.getDates().get(i));
//        }
        RedisUtil redisUtil = new RedisUtil(redisTemplate);
        RedisCart redisCart = (RedisCart) redisUtil.get("Cart_"+foodRecord.getUserid());
//        for (int j = 0; j < redisCart.getCart().size(); j++) {
//            System.out.println(redisCart.getCart().get(j).getFoodname());
//            System.out.println(redisCart.getCart().get(j).getDate().getTime());
//        }
//        System.out.println(redisCart.getCart().size());

        Iterator<CartItem> it =redisCart.getCart().iterator();
        while (it.hasNext())
        {

            CartItem cartItem = it.next();
//            System.out.println(cartItem.getDate().getTime());
//            System.out.println("//================================");
            for (Long date : foodRecord.getDates()) {
//                System.out.println(date);

                if (date.equals((Long) cartItem.getDate().getTime())){
//                    System.out.println(cartItem.getDate().getTime());
//                    System.out.println("true");
                    it.remove();
                    break;
                }
            }
        }
        System.out.println(redisCart.getCart().size());
//        for (int j = 0; j < redisCart.getCart().size(); j++) {
//            System.out.println(redisCart.getCart().get(j).getFoodname());
//            System.out.println(redisCart.getCart().get(j).getDate());
//        }

        redisUtil.set("Cart_"+foodRecord.getUserid(),redisCart);

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

//        alipayConfig.logResult(alipayClient.pageExecute(request).);
        System.out.println(from);
            return "from";
    }
}
