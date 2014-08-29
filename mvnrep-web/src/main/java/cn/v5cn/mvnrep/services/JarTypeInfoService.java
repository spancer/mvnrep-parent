package cn.v5cn.mvnrep.services;

import cn.v5cn.mvnrep.entity.JarTypeInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/29.
 */
public interface JarTypeInfoService {
    List<JarTypeInfo> addSearchJarInfo(List<Map<String,Object>> httpResults);
}
