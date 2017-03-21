import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<>();

      ArrayList<CD> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<CD>();
        request.session().attribute("cds", cds);
      }

      String title = request.queryParams("title");
      String artist = request.queryParams("artist");
      int year = Integer.parseInt(request.queryParams("year"));
      String genre = request.queryParams("genre");
      CD newCD = new CD(title, artist, year, genre);
      cds.add(newCD);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/cds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
