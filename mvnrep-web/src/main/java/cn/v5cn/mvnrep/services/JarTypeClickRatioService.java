package cn.v5cn.mvnrep.services;

import cn.v5cn.mvnrep.entity.JarTypeClickRatio;

/**
 * Created by ZYW on 2014/8/29.
 */
public interface JarTypeClickRatioService {
    Long addOrUpdateClickRatio(String g,String a);
    JarTypeClickRatio findByGaJTCR(String jarga);
}
