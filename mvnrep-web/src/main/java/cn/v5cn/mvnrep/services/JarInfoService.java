package cn.v5cn.mvnrep.services;

import cn.v5cn.mvnrep.entity.JarInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/29.
 */
public interface JarInfoService {
    List<JarInfo> addJarInfo(List<Map<String,Object>> httpData);
    JarInfo findByGAR(String g,String a,String v);
    Long updateClickRatio(Long jarInfoId,Long clickRatio);
}
