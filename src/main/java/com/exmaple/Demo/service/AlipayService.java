package com.exmaple.Demo.service;

import com.alipay.api.AlipayApiException;
import com.exmaple.Demo.model.FoodRecord;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AlipayService {
    public String pay(FoodRecord foodRecord) throws AlipayApiException, JsonProcessingException;
}
