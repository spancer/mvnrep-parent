package cn.v5cn.mvnrep.services.impl;

import cn.v5cn.mvnrep.dao.SearchKeyDao;
import cn.v5cn.mvnrep.entity.SearchKey;
import cn.v5cn.mvnrep.services.SearchKeyService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/8/29.
 */
@Service("searchKeyService")
public class SearchKeyServiceImpl implements SearchKeyService {

    @Autowired
    private SearchKeyDao searchKeyDao;

    @Override
    public Long addOrUpdateSearchKey(String searchKey) {
        Long result = Long.valueOf(0);
        SearchKey sk = searchKeyDao.findBySkw(searchKey);
        if(sk == null){
            SearchKey addSk = new SearchKey();
            addSk.setSkw(searchKey);
            addSk.setStime(DateTime.now().toString("YYYY-MM-dd"));
            result = searchKeyDao.addSearchKey(addSk);
        }else{
            Long sn = sk.getSearchNum();
            result = searchKeyDao.updateSeachKeyNum(Long.valueOf(sn.longValue()+1L),sk.getSkId());
        }
        return result;
    }
}
