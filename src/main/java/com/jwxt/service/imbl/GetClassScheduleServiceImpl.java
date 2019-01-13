package com.jwxt.service.imbl;

import com.jwxt.service.IGetClassScheduleService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author me@nitmali.com
 * @date 2019/1/13 23:33
 */
@Service
public class GetClassScheduleServiceImpl implements IGetClassScheduleService {
    @Override
    public List<Map<String, String>> getClassSchedule(HttpServletRequest request, String year, String yearNumber) throws IOException {


        HttpSession session = request.getSession();

        Map<String, String> loginPageCookies = (Map<String, String>) session.getAttribute("loginPageCookies");

        Connection.Response classScheduleResponse = Jsoup.connect
                (
                        "http://jwxt.nit.net.cn/xscjcx.aspx?"
                                + "xh=" + session.getAttribute("userId")
                                + "&xm=" + session.getAttribute("userName")
                                + "&gnmkdm=N121603"
                )
                .method(Connection.Method.GET)
                .header("Referer", "http://jwxt.nit.net.cn/xs_main.aspx?xh=" + session.getAttribute("userId"))
                .cookies(loginPageCookies)
                .ignoreContentType(true)
                .execute();

        Document classScheduleDocument = Jsoup.parse(classScheduleResponse.body());
        return null;
    }
}