package cn.v5cn.mvnrep.action;

import cn.v5cn.mvnrep.utils.HttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Map;

/**
 * Created by ZYW on 2014/8/27.
 */
@Controller
public class IndexAction {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(ModelMap modelMap) throws IOException {


        return "index";
    }

    @RequestMapping(value = "/search/{s}",method = RequestMethod.GET)
    public String searchList(@PathVariable String s,ModelMap modelMap) throws IOException{
        String searchUrl = "http://search.maven.org/solrsearch/select?q="+s+"&rows=20&wt=json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map> abc = mapper.readValue(HttpUtils.getResult(searchUrl),Map.class);

        modelMap.addAttribute("list", abc.get("response").get("docs"));

        return "search_list";
    }

    @RequestMapping(value = "/cvl/{g}/{a}",method = RequestMethod.GET)
    public String componesVersionList(@PathVariable String g,@PathVariable String a,ModelMap modelMap) throws IOException{
        String q = "http://search.maven.org/solrsearch/select?q=g%3A%22";
        String z = "%22%20AND%20a%3A%22";
        String h = "%22&rows=20&core=gav&wt=json";
        String zh = q+g+z+a+h;

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Map> abc = mapper.readValue(HttpUtils.getResult(zh),Map.class);

        modelMap.addAttribute("list", abc.get("response").get("docs"));

        return "cvl_list";
    }
}
