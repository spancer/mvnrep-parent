package cn.v5cn.mvnrep.services.impl;

import cn.v5cn.mvnrep.dao.JarInfoDao;
import cn.v5cn.mvnrep.entity.JarInfo;
import cn.v5cn.mvnrep.services.JarInfoService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/29.
 */
@Service("jarInfoService")
public class JarInfoServiceImpl implements JarInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JarInfoServiceImpl.class);

    @Autowired
    private JarInfoDao jarInfoDao;

    @Override
    public List<JarInfo> addJarInfo(List<Map<String, Object>> httpData) {
        List<JarInfo> result = Lists.newArrayList();
        JarInfo dbObj = null;
        for (Map<String,Object> jarInfo : httpData){
            dbObj = new JarInfo();
            dbObj.setGroupId(jarInfo.get("g").toString());
            dbObj.setArtifactId(jarInfo.get("a").toString());
            dbObj.setVersion(jarInfo.get("v").toString());
            String[] vInfo = versionType(dbObj.getVersion());
            dbObj.setJartype(vInfo[0]);
            dbObj.setJarcolor(vInfo[1]);
            dbObj.setBuilderTime(new DateTime(Long.valueOf(jarInfo.get("timestamp").toString())).toString("YYYY-MM-dd"));
            dbObj.setClickRatio(0L);
            JarInfo sji = jarInfoDao.findByGAR(dbObj.getGroupId(),dbObj.getArtifactId(),dbObj.getVersion());
            if(sji != null ) {
                result.add(sji);
                continue;
            }
            LOGGER.info("db-jar-add:{}",dbObj);
            result.add(dbObj);
            jarInfoDao.addJarInfo(dbObj);

        }

//        for (JarInfo jarInfo : result){
//            JarInfo sji = jarInfoDao.findByGAR(jarInfo.getGroupId(),jarInfo.getArtifactId(),jarInfo.getVersion());
//            if(sji != null ) {
//                jarInfo.setClickRatio(sji.getClickRatio());
//                jarInfo.setClickRatio(sji.getClickRatio());
//                continue;
//            }
//            jarInfoDao.addJarInfo(jarInfo);
//        }
        return result;
    }

    private String[] versionType(String version){
        if(StringUtils.contains(version.toLowerCase(),"-a")){
            return new String[]{"alpha","bg-red"};
        }
        if(StringUtils.contains(version.toLowerCase(),"-b")){
            return new String[]{"beta","bg-yellow"};
        }
        if(StringUtils.contains(version.toLowerCase(),"-rc") || StringUtils.contains(version.toLowerCase(),"cr")){
            return new String[]{"release candidate","bg-blue"};
        }
        if(StringUtils.contains(version.toLowerCase(),"-m")){
            return new String[]{"milestone","bg-main"};
        }
        if(StringUtils.contains(version.toLowerCase(),"ga")){
            return new String[]{"general availability","bg-green"};
        }

        return new String[]{"release","bg-green"};
    }
}
