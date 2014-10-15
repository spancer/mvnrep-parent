package cn.v5cn.mvnrep.services.impl;

import cn.v5cn.mvnrep.dao.JarTypeClickRatioDao;
import cn.v5cn.mvnrep.entity.JarTypeClickRatio;
import cn.v5cn.mvnrep.services.JarTypeClickRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/8/29.
 */
@Service("jarTypeClickRatioService")
public class JarTypeClickRatioServiceImpl implements JarTypeClickRatioService {

    @Autowired
    private JarTypeClickRatioDao jarTypeClickRatioDao;

    @Override
    public Long addOrUpdateClickRatio(String g, String a) {
        JarTypeClickRatio jarTypeClickRatio = jarTypeClickRatioDao.findByGaJTCR(g + ":" + a);
        if(jarTypeClickRatio != null){
            return jarTypeClickRatioDao.updateJTCR(jarTypeClickRatio.getJtcrId(),jarTypeClickRatio.getClickRatio()+1L);
        }else{
            JarTypeClickRatio dbObj = new JarTypeClickRatio();
            dbObj.setJarga(g+":"+a);
            dbObj.setClickRatio(1L);
            return jarTypeClickRatioDao.addJTCR(dbObj);
        }
    }

    @Override
    public JarTypeClickRatio findByGaJTCR(String jarga) {
        return jarTypeClickRatioDao.findByGaJTCR(jarga);
    }
}
