package com.solitardj9.msa.application.routeManager.service.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteConfigList {

    private List<RouteConfig> configs;
}