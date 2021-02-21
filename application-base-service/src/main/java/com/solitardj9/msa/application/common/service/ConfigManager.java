package com.solitardj9.msa.application.common.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;


@Service("configManager")
@RefreshScope
public class ConfigManager {
	
	Logger logger = LoggerFactory.getLogger(ConfigManager.class);
	
	@Value("${application.flag}")
	private String flag;
	
	@PostConstruct
	public void init() {
		logger.info("[ConfigManager].init : flag = " + flag);
	}
}