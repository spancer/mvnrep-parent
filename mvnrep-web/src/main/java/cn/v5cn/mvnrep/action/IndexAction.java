package cn.v5cn.mvnrep.action;

import cn.v5cn.mvnrep.entity.JarInfo;
import cn.v5cn.mvnrep.entity.JarTypeInfo;
import cn.v5cn.mvnrep.services.JarInfoService;
import cn.v5cn.mvnrep.services.JarTypeClickRatioService;
import cn.v5cn.mvnrep.services.JarTypeInfoService;
import cn.v5cn.mvnrep.services.SearchKeyService;
import cn.v5cn.mvnrep.utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/27.
 */
@Controller
public class IndexAction {

    @Autowired
    private SearchKeyService searchKeyService;
    @Autowired
    private JarTypeInfoService jarTypeInfoService;

    @Autowired
    private JarTypeClickRatioService jarTypeClickRatioService;

    @Autowired
    private JarInfoService jarInfoService;

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    public String index(ModelMap modelMap) throws IOException {


        return "index";
    }

    @RequestMapping(value = "/search/{s}",method = RequestMethod.GET)
    public String searchList(@PathVariable String s,ModelMap modelMap) throws IOException{
        searchKeyService.addOrUpdateSearchKey(s);
        String searchUrl = "http://search.maven.org/solrsearch/select?q="+s+"&rows=200&wt=json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map> result = mapper.readValue(HttpUtils.getResult(searchUrl),Map.class);
        HttpUtils.closeHttpResponse();
        List<JarTypeInfo> searchInfos = jarTypeInfoService.addSearchJarInfo(((List)(result.get("response").get("docs"))));
        modelMap.addAttribute("list", searchInfos);

        return "search_list";
    }

    @RequestMapping(value = "/cvl/{g}/{a}",method = RequestMethod.GET)
    public String componesVersionList(@PathVariable String g,@PathVariable String a,ModelMap modelMap) throws IOException{
        String q = "http://search.maven.org/solrsearch/select?q=g%3A%22";
        String z = "%22%20AND%20a%3A%22";
        String h = "%22&rows=200&core=gav&wt=json";
        String zh = q+g+z+a+h;

        jarTypeClickRatioService.addOrUpdateClickRatio(g,a);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map> httpRsult = mapper.readValue(HttpUtils.getResult(zh),Map.class);
        HttpUtils.closeHttpResponse();
        List<JarInfo> jarInfos = jarInfoService.addJarInfo((List<Map<String, Object>>) httpRsult.get("response").get("docs"));
        modelMap.addAttribute("list", jarInfos);

        return "cvl_list";
    }
}