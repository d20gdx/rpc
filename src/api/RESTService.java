package api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

@Path("/")
public class RESTService {

	// private static String filePath = "//home//pi/app";
	private static String filePath = "c:\\";
	private static String fileName = "out.csv";
	private static String timeInMins = "9999";

	@GET
	@Path("/frames_secure")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Frame> getFramesSecure(@QueryParam("timeinmins") String timeInMins,
			@QueryParam("spreadingfactor") String spreadingFactor, @QueryParam("key") String apiKey)
			throws JSONException {

		if (apiKey.equals("DFJJ-DFD-223-SD-SDSD")) {
			return getFrames(timeInMins, spreadingFactor);

		}
		return null;
	}

	@GET
	@Path("/frames")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Frame> getFrames(@QueryParam("timeinmins") String timeInMins,
			@QueryParam("spreadingfactor") String spreadingFactor) throws JSONException {

		List<Frame> frames = null;

		try {

			frames = Files.readAllLines(Paths.get(filePath, fileName)).stream()
					.map(s -> new Frame(s.split(",")[0], s.split(",")[1], s.split(",")[2], s.split(",")[3],
							s.split(",")[4], s.split(",")[5], s.split(",")[6], s.split(",")[7], s.split(",")[8],
							s.split(",")[9], s.split(",")[10], s.split(",")[11], s.split(",")[12], s.split(",")[13],
							s.split(",")[14], s.split(",")[15], s.split(",")[16], s.split(",")[17], s.split(",")[18],
							s.split(",")[19], s.split(",")[20], s.split(",")[21], s.split(",")[22], s.split(",")[23],
							s.split(",")[24], s.split(",")[25], s.split(",")[26], s.split(",")[27], s.split(",")[28],
							s.split(",")[29], s.split(",")[30], s.split(",")[31], s.split(",")[32], s.split(",")[33],
							s.split(",")[34], s.split(",")[35], s.split(",")[36], s.split(",")[37]))
					.filter(x -> filterData(x.getTime(), timeInMins, x.getDatr(), spreadingFactor))
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return frames;
	}

	/**
	 * @param aDate
	 * @param timeInMins
	 * @return
	 * 
	 * 		Filter the Lora data by time
	 */
	private boolean filterData(String aDate, String timeInMins, String aDatr, String spreadingFactor) {

		SimpleDateFormat formatnow = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");
		Date date1 = null;
		try {
			date1 = formatnow.parse(aDate.substring(4, aDate.length() - 15));
		} catch (Exception e) {
			return false;
		}

		// filter on time
		if ((System.currentTimeMillis() - date1.getTime()) < (Integer.parseInt(timeInMins) * 1000 * 60)) {

			// filter on spreading factor
			if (spreadingFactor.equals("0") || aDatr.equals("SF" + spreadingFactor + "BW125")) {
				return true;
			}

		}

		// set to true for testing
		return false;

	}

	@GET
	@Path("/map")
	@Produces(MediaType.TEXT_HTML)
	public String getMap(@QueryParam("timeinmins") String timeInMins,
			@QueryParam("spreadingfactor") String spreadingFactor) throws JSONException {

		List<Frame> frames = getFrames(timeInMins, spreadingFactor);

		String str = "<!DOCTYPE html>" + //
				"<html>" + //
				"  <head>" + //
				"    <title>Lora Coverage Map</title>" + //
				"    <meta name=\"viewport\" content=\"initial-scale=1.0\">" + //
				"    <meta charset=\"utf-8\">" + //
				"    <style>" + //
				"      /* Always set the map height explicitly to define the size of the div" + //
				"       * element that contains the map. */" + //
				"      #map {" + //
				"        height: 100%;" + //
				"      }" + //
				"      /* Optional: Makes the sample page fill the window. */" + //
				"      html, body {" + //
				"        height: 100%;" + //
				"        margin: 0;" + //
				"        padding: 0;" + //
				"      }" + //
				"    </style>" + //
				"  </head>" + //
				"  <body>" + //
				"    <div id=\"map\"></div>" + //
				"    <script>" + //
				"      var map;" + //
				"      function initMap() {" + //
				"        map = new google.maps.Map(document.getElementById('map'), {" + //
				"          center: {lat: 51.73113, lng: -0.36209}," + //
				"          zoom: 15" + //
				"        });" + //
				"        " + //
				"        	" + //
				"        	";

		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i < frames.size(); i++) {

			// choose colour depending on spreading factor

			String strokeColor = "";

			if (frames.get(i).getDatr().equals("SF7BW125")) {
				strokeColor = "#7DFF33";
			}

			if (frames.get(i).getDatr().equals("SF8BW125")) {
				strokeColor = "#33FF38";
			}

			if (frames.get(i).getDatr().equals("SF9BW125")) {
				strokeColor = "#33FF78";
			}

			if (frames.get(i).getDatr().equals("SF10BW125")) {
				strokeColor = "#F8FF33";
			}

			if (frames.get(i).getDatr().equals("SF11BW125")) {
				strokeColor = "#FF9233";
			}

			if (frames.get(i).getDatr().equals("SF12BW125")) {
				strokeColor = "#FF4133";
			}

			str += "          var flightPath = new google.maps.Polyline({" + //
					"              path: [{lat: " + frames.get(i).getGw_lat() + ", lng: " + frames.get(i).getGw_lon()
					+ "},{lat: " + frames.get(i).getNode_lat() + ", lng:" + frames.get(i).getNode_long() + "}]," + //
					"              geodesic: true," + //
					"              map: map," + //
					"              strokeColor: ' " + strokeColor + "'," + //
					"              strokeOpacity: 1.0," + //
					"              strokeWeight: 1" + //
					"            });";

		}

		str += "      }" + //
				"    </script>" + //
				"    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAPA4oCk_64JNHmu64WTmLqq8e1--21wYU&callback=initMap\""
				+ //
				"    async defer></script>" + //
				"  </body>" + //
				"</html>";

		return str;
	}

	@GET
	@Path("/config")
	@Produces(MediaType.TEXT_HTML)
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
				" Number of Mins:<br>" + //
				"  <input type=\"text\" name=\"nsecs\" value=\"" + timeInMins + "\">" + //
				"  <br><br>" + //
				"  <input type=\"submit\" value=\"Submit\">" + //
				"</form> " + //
				"<p>Click submit to update</p>" + //
				"</body>" + //
				"</html>";

		return str;
	}

	@POST
	@Path("/postform")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String writeFormResult(@FormParam("fpath") String fpath, @FormParam("fname") String fname,
			@FormParam("nsecs") String nsecs) {

		filePath = fpath.trim();
		fileName = fname.trim();
		timeInMins = nsecs.trim();

		String str = "<!DOCTYPE html>" + "<html>" + //
				"<body>" + "values updated!" + "</body>" + //
				"</html>";

		return str;
	}

}