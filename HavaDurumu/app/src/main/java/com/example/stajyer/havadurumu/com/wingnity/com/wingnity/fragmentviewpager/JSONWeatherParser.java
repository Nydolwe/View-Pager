/**
 * This is a tutorial source code 
 * provided "as is" and without warranties.
 *
 * For any question please visit the web site
 * http://www.survivingwithandroid.com
 *
 * or write an email to
 * survivingwithandroid@gmail.com
 *
 */
package com.example.stajyer.havadurumu.com.wingnity.com.wingnity.fragmentviewpager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;



public class JSONWeatherParser {

	public static Location getLocation(String data) throws JSONException  {
        Location loc = new Location();
		JSONObject jObj = new JSONObject(data);



        //TODO
		JSONArray weatherMoonrise = jObj.optJSONArray("weather");
        JSONObject moonRiseObject = (JSONObject)weatherMoonrise.get(0);
        JSONArray moonRiseArray = moonRiseObject.optJSONArray("astronomy");
        JSONObject MoonRiseObject = (JSONObject)moonRiseArray.get(0);
        String moonRise = MoonRiseObject.optString("moonrise").toString();
        loc.setMoonRise(MoonRiseObject.optString("moonrise").toString());



        JSONArray weatherMoonset = jObj.optJSONArray("weather");
        JSONObject moonSetObject = (JSONObject)weatherMoonset.get(0);
        JSONArray moonSetArray = moonSetObject.optJSONArray("astronomy");
        JSONObject MoonSetObject = (JSONObject)moonSetArray.get(0);
        String moonSet = MoonSetObject.optString("moonset").toString();
        loc.setMoonSet(MoonSetObject.optString("moonset").toString());


        JSONArray weatherSunrise = jObj.optJSONArray("weather");
        JSONObject sunRiseObject = (JSONObject)weatherSunrise.get(0);
        JSONArray sunRiseArray = sunRiseObject.optJSONArray("astronomy");
        JSONObject SunRiseObject = (JSONObject)sunRiseArray.get(0);
        String sunRise = SunRiseObject.optString("sunrise").toString();
        loc.setSunRise(sunRiseObject.optString("sunrise").toString());


        JSONArray weatherSunset = jObj.optJSONArray("weather");
        JSONObject sunSetObject = (JSONObject)weatherSunset.get(0);
        JSONArray sunSetArray = sunSetObject.optJSONArray("astronomy");
        JSONObject SunSetObject = (JSONObject)sunSetArray.get(0);
        String sunSet = SunSetObject.optString("sunset").toString();
        loc.setSunSet(SunSetObject.optString("sunset").toString());


        JSONArray weatherCondition = jObj.optJSONArray("current_condition");
        JSONObject conditionObject =(JSONObject)weatherCondition.get(0);
        JSONArray conditionArray = conditionObject.getJSONArray("lang_tr");
        JSONObject ConditionObject = (JSONObject)conditionArray.get(0);
        String condition = ConditionObject.optString("value").toString();
        loc.setCondition(ConditionObject.optString("value").toString());

        JSONArray conditiontempC = jObj.optJSONArray("current_condition");
        JSONObject conditionTempCObject =(JSONObject) conditiontempC.get(0);
        String tempC = conditionTempCObject.optString("tempC").toString();
        loc.setTempC(conditionTempCObject.optString("tempC").toString());

        JSONArray conditiontempF = jObj.optJSONArray("current_condition");
        JSONObject conditionTempFObject = (JSONObject) conditiontempF .get(0);
        String tempF = conditionTempFObject.optString("tempF").toString();
        loc.setTempF(conditionTempFObject.optString("tempF").toString());


        JSONArray conditionfeelslikeC = jObj.optJSONArray("current_condition");
        JSONObject conditionfeelslikeCObject = (JSONObject) conditionfeelslikeC.get(0);
        String feelslikeC =conditionfeelslikeCObject.optString("FeelsLikeC").toString();
        loc.setFeelslikeC(conditionfeelslikeCObject.optString("FeelsLikeC").toString());


         JSONArray conditionfeelslikeF = jObj.optJSONArray("current_condition");
         JSONObject conditionfeelslikeFObject = (JSONObject)conditionfeelslikeF.get(0);
         String feelslikeF = conditionfeelslikeFObject.optString("FeelsLikeF").toString();
         loc.setFeelslikeF(conditionfeelslikeFObject.optString("FeelsLikeF").toString());



         JSONArray pressureA = jObj.optJSONArray("current_condition");
         JSONObject pressureObject = (JSONObject)pressureA.get(0);
         String pressure = pressureObject.optString("pressure").toString();
         loc.setPressure(pressureObject.optString("pressure").toString());



         JSONArray humidityA = jObj.optJSONArray("current_condition");
         JSONObject humidityObject = (JSONObject)humidityA.get(0);
         String humidity = humidityObject.optString("humidity").toString();
         loc.setHumidity(humidityObject.optString("humidiy").toString());


         JSONArray winddir16pointA = jObj.optJSONArray("current_condition");
         JSONObject winddir16pointObject = (JSONObject)winddir16pointA.get(0);
         String winddir16point = winddir16pointObject.optString("winddir16point").toString();
         loc.setWinddir16point(winddir16pointObject.optString("winddir16point").toString());


         JSONArray windspeedKmphA = jObj.optJSONArray("current_condition");
         JSONObject windspeedKmphObject = (JSONObject)windspeedKmphA.get(0);
         String windspeedKmph = windspeedKmphObject.optString("windspeedKmph").toString();
         loc.setWindspeedKmph(windspeedKmphObject.optString("windspeedKmph").toString());


         JSONArray imageIconA = jObj.optJSONArray("current_condition");
         JSONObject imageIconObject =(JSONObject) imageIconA.get(0);
         JSONArray imageIconArray = imageIconObject.getJSONArray("weatherIconUrl");
         JSONObject ImageIconObject = (JSONObject) imageIconArray.get(0);
         String imageIcon = ImageIconObject.optString("value").toString();
         loc.setImageIcon(ImageIconObject.optString("value").toString());

        //TODO

		return loc;
	}


}
