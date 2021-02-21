package com.solitardj9.msa.application.routeManager.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solitardj9.msa.application.routeFilters.service.RouteFilterManager;
import com.solitardj9.msa.application.routeManager.service.RouteManager;
import com.solitardj9.msa.application.routeManager.service.data.RouteConfig;
import com.solitardj9.msa.application.routeManager.service.data.RouteConfigList;

@Service("routeManager")
public class RouteManagerImpl implements RouteManager {

    private static final Logger logger = LogManager.getLogger(RouteManagerImpl.class);

    @Autowired
    private RefreshableRoutesLocator refreshableRoutesLocator;

    @Autowired
    RouteFilterManager routeFilterManager;

    @Value("${route.config}")
	private String routeConfig;

    private Map<String, RouteConfig> routeConfigMap = new HashMap<>();

    private RouteConfigList routeConfigList;

    private ObjectMapper om = new ObjectMapper();

    @PostConstruct
    public void init() {

        setRouteFilterConfigList(routeConfig);

        buildRoutes();
    }

    private void setRouteFilterConfigList(String routeConfig) {

        try {
            routeConfigList = om.readValue(routeConfig, RouteConfigList.class);

            for (RouteConfig iter : routeConfigList.getConfigs()) {
                routeConfigMap.put(iter.getServiceName(), iter);
            }
        } catch (JsonProcessingException e) {
            logger.error("[RouteManager].setRouteFilterConfigList : error = " + e);
        }
    }

    private List<RouteConfig> getEnabledRouteFilterConfigList() {

        List<RouteConfig> configs = new ArrayList<>();

        for (Map.Entry<String, RouteConfig> iter : routeConfigMap.entrySet()) {

            if (iter.getValue().getEnable().equals(true)) {
                configs.add(iter.getValue());
            }
        }

        return configs;
    }

    private void buildRoutes() {

        logger.info("[RouteManager].buildRoutes : building routes = starts.");

        refreshableRoutesLocator.clearRoutes();

        List<RouteConfig> configs = getEnabledRouteFilterConfigList();

        try {
            refreshableRoutesLocator.addRoute(configs, routeFilterManager);
            refreshableRoutesLocator.buildRoutes();
        } catch (URISyntaxException e) {
            logger.error("[RouteManager].setRouteFilterConfigList : error = " + e);
        }

        logger.info("[RouteManager].buildRoutes : building routes = ends.");
    }
}