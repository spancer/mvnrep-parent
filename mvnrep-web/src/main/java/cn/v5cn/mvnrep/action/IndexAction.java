package cn.v5cn.mvnrep.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String searchUrl = "http://search.maven.org/solrsearch/select?q="+s+"&rows=20&wt=json";
        try {
            HttpGet httpget = new HttpGet(searchUrl);

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());

                // Get hold of the response entity
                HttpEntity entity = response.getEntity();
                ObjectMapper mapper = new ObjectMapper();
                Map<String,Map> abc = mapper.readValue(entity.getContent(),Map.class);

                modelMap.addAttribute("list", abc.get("response").get("docs"));
                // If the response does not enclose an entity, there is no need
                // to bother about connection release

            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return "search_list";
    }

    @RequestMapping(value = "/cvl/{g}/{a}",method = RequestMethod.GET)
    public String componesVersionList(@PathVariable String g,@PathVariable String a,ModelMap modelMap) throws IOException{
        String q = "http://search.maven.org/solrsearch/select?q=g%3A%22";
        String z = "%22%20AND%20a%3A%22";
        String h = "%22&rows=20&core=gav&wt=json";
        String zh = q+g+z+a+h;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(zh);

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());

                // Get hold of the response entity
                HttpEntity entity = response.getEntity();
                ObjectMapper mapper = new ObjectMapper();
                Map<String,Map> abc = mapper.readValue(entity.getContent(),Map.class);

                modelMap.addAttribute("list", abc.get("response").get("docs"));
                // If the response does not enclose an entity, there is no need
                // to bother about connection release

            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }

        return "cvl_list";
    }
}
