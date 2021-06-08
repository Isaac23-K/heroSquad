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

        post("/homepage", (request, response) -> {
            return new ModelAndView(model,layout);
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            List<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get ("/heroes/new", (request, response) -> {
            // model.put("template", "templates/squadform.hbs");
            return new ModelAndView(model, "heroform.hbs");
        } , new HandlebarsTemplateEngine());

        //get: delete all squads and all heroes
        get("/squads/delete", (req, res) -> {
            //Map<String, Object> model = new HashMap<>();
            model.clear();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete all heroes
        get("/heroes/delete", (req, res) -> {
            //Map<String, Object> model = new HashMap<>();
            model.clear();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        post("/heroes", (request, response) -> {
            String hero_name = request.queryParams("hero_name");
            String age = request.queryParams("age");
            String powers = request.queryParams("powers");
            String weakness = request.queryParams("weakness");
            Hero hero = new Hero(hero_name,Integer.parseInt(age),powers,weakness);
            model.put("hero_name",hero.getHero_name());
            model.put("age" , hero.getAge());
            model.put("powers",hero.getPowers());
            model.put("weakness", hero.getWeakness());
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
