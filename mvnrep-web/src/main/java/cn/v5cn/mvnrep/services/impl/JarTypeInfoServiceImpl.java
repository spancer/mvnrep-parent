package cn.v5cn.mvnrep.services.impl;

import cn.v5cn.mvnrep.dao.JarTypeInfoDao;
import cn.v5cn.mvnrep.entity.JarTypeClickRatio;
import cn.v5cn.mvnrep.entity.JarTypeInfo;
import cn.v5cn.mvnrep.services.JarTypeClickRatioService;
import cn.v5cn.mvnrep.services.JarTypeInfoService;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/29.
 */
@Service("searchInfoService")
public class JarTypeInfoServiceImpl implements JarTypeInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JarTypeInfoServiceImpl.class);

    @Autowired
    private JarTypeInfoDao jarTypeInfoDao;

    @Autowired
    private JarTypeClickRatioService jarTypeClickRatioService;

    @Override
    public List<JarTypeInfo> addSearchJarInfo(List<Map<String,Object>> httpResults) {
        List<JarTypeInfo> result = Lists.newArrayList();
        JarTypeInfo dbObj = null;
        for(Map<String,Object> httpResult : httpResults){
            dbObj = new JarTypeInfo();
            dbObj.setId(httpResult.get("id").toString());
            dbObj.setLatestVersion(httpResult.get("latestVersion").toString());
            dbObj.setVersionCount(Integer.valueOf(httpResult.get("versionCount").toString()));
            dbObj.setGroupId(httpResult.get("g").toString());
            dbObj.setArtifactId(httpResult.get("a").toString());
            dbObj.setRepositoryId(httpResult.get("repositoryId").toString());
            dbObj.setPack(httpResult.get("p").toString());
            dbObj.setUpdatetime(new DateTime(Long.valueOf(httpResult.get("timestamp").toString())).toString("YYYY-MM-dd"));


            JarTypeInfo si = jarTypeInfoDao.findByIdAndLastVersion(dbObj.getId());
            if(si != null){
                JarTypeClickRatio byGaJTCR = jarTypeClickRatioService.findByGaJTCR(si.getId());
                if(byGaJTCR != null){
                    si.setClickRatio(byGaJTCR.getClickRatio());
                }else{
                    si.setClickRatio(0L);
                }
            }
            if(si != null && si.getLatestVersion().equals(dbObj.getLatestVersion())){
                result.add(si);
                continue;
            }else if(si != null && !si.getLatestVersion().equals(dbObj.getLatestVersion())){
                jarTypeInfoDao.updateLastVersionAndVersionCount(dbObj.getLatestVersion(),dbObj.getVersionCount(),si.getJtiId());
                result.add(si);
                LOGGER.info("db-jarType-update:{}",si);
                continue;
            }
            dbObj.setClickRatio(0L);
            LOGGER.info("db-jarType-non:{}",dbObj);
            result.add(dbObj);
            jarTypeInfoDao.addSearchJarInfo(dbObj);

        }
        Collections.sort(result,new Comparator<JarTypeInfo>() {
            @Override
            public int compare(JarTypeInfo o1, JarTypeInfo o2) {
                return Integer.valueOf(((o2.getClickRatio().longValue())-(o1.getClickRatio().longValue()))+"");
            }
        });
        return result;
    }
}
