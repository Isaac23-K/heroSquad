import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Integer port;
        if (processBuilder.environment().get("PORT") != null) {
            port = Integer.parseInt(processBuilder.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        staticFileLocation("/public");
        Map<String,Object> model = new HashMap<String,Object>();
        String layout = "templates/layout.hbs";

        get("/", (request, response) -> {
            model.put("squads", Squad.getInstances());
            return new ModelAndView(model, "homepage.hbs");
        } , new HandlebarsTemplateEngine());

        post("/homepage", (request, response) -> {
//            model.put("squads", Squad.all());
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());


        get("/squads", (request, response) -> {
            List<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get("squads/new", (request, response) -> {
//            model.put("template", "templates/squadform.hbs");
            return new ModelAndView(model, "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squads",(request, response) -> {
            String squad_name = request.queryParams("squad_name");
            String cause = request.queryParams("cause");
            String maxsize = request.queryParams("maxsize");
            Squad squad = new Squad(squad_name,cause,Integer.parseInt(maxsize));
            model.put("squad_name",squad.getName());
            model.put("cause", squad.getCause());
            model.put("maxsize", squad.getMax());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            List<Hero> heroes = Hero.getInstance();
            model.put("heroes",heroes);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/new", (request, response) -> {
            //  model.put("template", "templates/squadform.hbs");
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());


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

