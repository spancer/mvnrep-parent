package cn.v5cn.mvnrep.services;

import cn.v5cn.mvnrep.entity.SearchInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/29.
 */
public interface SearchInfoService {
    List<SearchInfo> addSearchJarInfo(List<Map<String,Object>> httpResults);
}
