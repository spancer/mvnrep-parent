package cn.v5cn.mvnrep.dao;

import cn.v5cn.mvnrep.entity.SearchKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ZYW on 2014/8/29.
 */
@Repository("searchKeyDao")
public interface SearchKeyDao {
    Long addSearchKey(SearchKey searchKey);
    SearchKey findBySkw(String skw);
    Long updateSeachKeyNum(@Param("searchNum")Long searchNum,@Param("skId")Long skId);
}
