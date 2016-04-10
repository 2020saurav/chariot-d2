package in.cs654.chariot.d2;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;
import static in.cs654.chariot.d2.JsonUtil.*;

public class D2Server {

    private static List<Prashti> prashtiList = new ArrayList<>();

    public static void main(String[] args) {

        get("/prashtis", (req, res) -> prashtiList, json());

        post("/prashtis", (req, res) -> {
            String ipAddr1 = req.queryParams("ip1");
            String ipAddr2 = req.queryParams("ip2");
            prashtiList.clear();
            prashtiList.add(new Prashti(ipAddr1));
            prashtiList.add(new Prashti(ipAddr2));
            return prashtiList;
        }, json());
    }
}
