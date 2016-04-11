package in.cs654.chariot.d2;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;
import static in.cs654.chariot.d2.JsonUtil.*;

public class D2Server {

    private static List<Prashti> prashtiList = new ArrayList<>();

    public static void main(String[] args) {

        get(new Route("/prashtis") {
            @Override
            public Object handle(Request request, Response response) {
                return toJson(prashtiList);
            }
        });
        post(new Route("/prashtis") {
            @Override
            public Object handle(Request request, Response response) {
            String ipAddr1 = request.queryParams("ip1");
            String ipAddr2 = request.queryParams("ip2");
            prashtiList.clear();
            prashtiList.add(new Prashti(ipAddr1));
            prashtiList.add(new Prashti(ipAddr2));
            return toJson(prashtiList);
            }
        });
    }
}
