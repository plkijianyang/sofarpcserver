package com.server;

import api.PayMessage;

/**
 * @Author:wjy
 * @Date: 2018/10/25.
 */
public class PayServiceImpl implements PayMessage {
	@Override
	public String adviceOfPayment(String s) {
		return s+"我是服务端的回复";
	}
}
