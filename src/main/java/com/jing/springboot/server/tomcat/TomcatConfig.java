package com.jing.springboot.server.tomcat;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jingsir
 **
 *         开启ssl端口服务
 */
//@Configuration
public class TomcatConfig {

	private String keyStorePath;
	private String keyAlias;
	private String keyPass;

	public TomcatConfig(String keypass, String keyStorePath, String keyAlias) {
		this.keyAlias = keyAlias;
		this.keyStorePath = keyStorePath;
		this.keyAlias = keyAlias;
	}

//	@Bean
	public EmbeddedServletContainerFactory serverContainer() {
		TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory();

		// 添加新的监听端口
		containerFactory.addAdditionalTomcatConnectors(createSslConector(keyStorePath, keyPass, keyAlias));
		return containerFactory;
	}

	public Connector createSslConector(String keyStorePath, String keypass, String keyAlias) {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			File storeFile = new File(keyStorePath);
			if (storeFile.exists() && storeFile.isFile()) {
				connector.setScheme("https");
				connector.setSecure(true);
				connector.setPort(8843);
				// keystore文件设置
				protocol.setSSLEnabled(true);
				protocol.setKeystoreFile(storeFile.getAbsolutePath());
				protocol.setKeystorePass(keypass);
				protocol.setKeyAlias(keyAlias);
			}
		} catch (Exception e) {
		}
		return connector;
	}
}
