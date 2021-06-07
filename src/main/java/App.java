import java.util.HashMap ;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");
        Map<String,Object> model = new HashMap<String,Object>();
        String layout = "templates/layout.hbs";

        get ("/", (request, response) -> {
            model.put("squads", Squad.getInstances());
            return new ModelAndView(model, "hompage.hbs");
        } , new HandlebarsTemplateEngine());
    }
}
