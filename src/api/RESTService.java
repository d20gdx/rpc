package api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

@Path ("/")
public class RESTService {

   private static String filePath = "//home//pi/app";
   private static String fileName = "out.csv";
   private static String secsData = "60";

   @GET
   @Path ("/get")
   @Produces (MediaType.APPLICATION_JSON)
   public List<Frame> getdata() throws JSONException {

      List<Frame> frames = null;

      try {
         frames = Files.readAllLines(Paths.get(filePath, fileName)).stream()
               .map(s -> new Frame(s.split(",")[0], s.split(",")[1], s.split(",")[2], s.split(",")[3], s.split(",")[4],
                     s.split(",")[5], s.split(",")[6], s.split(",")[7], s.split(",")[8]))
               .filter(x -> inLastMin(x.getTime())).collect(Collectors.toList());
      }
      catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      return frames;

   }

   @POST
   @Path ("/postform")
   @Produces (MediaType.TEXT_HTML)
   @Consumes (MediaType.APPLICATION_FORM_URLENCODED)
   public String writeFormResult(@FormParam ("fpath") String fpath, @FormParam ("fname") String fname,
         @FormParam ("nsecs") String nsecs) {

      filePath = fpath.trim();
      fileName = fname.trim();
      secsData = nsecs.trim();

      String str = "<!DOCTYPE html>" + "<html>" + //
            "<body>" + "values updated!" +
            "</body>" + //
            "</html>";

      return str;
   }

   @GET
   @Path ("/config")
   @Produces (MediaType.TEXT_HTML)
   public String writeForm() {

      String str = "<!DOCTYPE html>" + "<html>" + //
            "<body>" + //
            "<form action=\"postform\" method=\"post\" >" + //
            " Path:<br>" + //
            "  <input type=\"text\" name=\"fpath\" value=\"" + filePath + " \">" + //
            "  <br>" + //
            " Name:<br>" + //
            "  <input type=\"text\" name=\"fname\" value=\"" + fileName + "\">" + //
            "  <br>" + //
            " Number of Secs:<br>" + //
            "  <input type=\"text\" name=\"nsecs\" value=\"" + secsData + "\">" + //
            "  <br><br>" + //
            "  <input type=\"submit\" value=\"Submit\">" + //
            "</form> " + //
            "<p>click to update</p>" + //
            "</body>" + //
            "</html>";

      return str;
   }

   private boolean inLastMin(String aDate) {

      SimpleDateFormat formatnow = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
      Date date1 = null;
      try {
         date1 = formatnow.parse(aDate.substring(4, aDate.length() - 15));
      }
      catch (Exception e) {
         return false;
      }

      if((System.currentTimeMillis() - date1.getTime()) < ( Integer.parseInt(secsData) * 1000)) {
         return true;
      }

      return false;

   }

}