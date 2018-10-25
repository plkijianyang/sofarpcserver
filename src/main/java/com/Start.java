package com;

import api.PayMessage;
import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.RegistryConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import com.server.PayServiceImpl;

/**
 * @Author:wjy
 * @Date: 2018/10/25.
 */
public class Start {

	public static void main(String[] args) {
		ServerConfig serverConfig = new ServerConfig()
				.setProtocol("bolt")
				.setPort(12200)
				.setDaemon(false);

		RegistryConfig registryConfig = new RegistryConfig()
				.setAddress("140.143.244.92:2181")
				.setRegister(true)
				.setSubscribe(true)
				.setProtocol("zookeeper");



		ProviderConfig<PayMessage> providerConfig = new ProviderConfig<PayMessage>()
				.setInterfaceId(PayMessage.class.getName())
				.setRef(new PayServiceImpl())
				.setRegistry(registryConfig)
				.setServer(serverConfig);

		//发布服务
		providerConfig.export();

		System.out.println("服务发布成功");
	}
}
