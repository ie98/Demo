package com.exmaple.Demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapMergePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.exmaple.Demo.config.AlipayConfig;
import com.exmaple.Demo.model.FoodRecord;
import com.exmaple.Demo.service.AlipayServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.MidiChannel;

@RestController
@CrossOrigin("http://localhost:9000")
public class AlipayController {
    @Autowired
    private AlipayServiceImpl alipayService;
    @PostMapping("/pay")
    public String pay(@RequestBody FoodRecord foodRecord) throws AlipayApiException, JsonProcessingException {
        return alipayService.pay(foodRecord);
    }
}
