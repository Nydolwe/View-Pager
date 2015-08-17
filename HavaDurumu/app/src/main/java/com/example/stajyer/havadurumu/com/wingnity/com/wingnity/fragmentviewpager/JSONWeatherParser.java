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

	public static Location getWeatherData(String data) throws JSONException  {

		JSONObject jObj = new JSONObject(data);
        Location loc = new Location();

        JSONObject maindata = jObj.getJSONObject("data");

        //JSONObject weather = (JSONObject) maindata.getJSONArray("weather").get(0);
        //JSONObject astronomy = (JSONObject) weather.getJSONArray("astronomy").get(0);
        //String moonrise = astronomy.getString("moonrise");


        //TODO
		JSONArray weatherMoonrise = maindata.optJSONArray("weather");
        JSONObject moonRiseObject = (JSONObject)weatherMoonrise.get(0);
        JSONArray moonRiseArray = moonRiseObject.optJSONArray("astronomy");
        JSONObject MoonRiseObject = (JSONObject)moonRiseArray.get(0);
        String moonRise = MoonRiseObject.optString("moonrise").toString();
        loc.setMoonRise(MoonRiseObject.optString("moonrise").toString());



        JSONArray weatherMoonset = maindata.optJSONArray("weather");
        JSONObject moonSetObject = (JSONObject)weatherMoonset.get(0);
        JSONArray moonSetArray = moonSetObject.optJSONArray("astronomy");
        JSONObject MoonSetObject = (JSONObject)moonSetArray.get(0);
        String moonSet = MoonSetObject.optString("moonset").toString();
        loc.setMoonSet(MoonSetObject.optString("moonset").toString());


        JSONArray weatherSunrise = maindata.optJSONArray("weather");
        JSONObject sunRiseObject = (JSONObject)weatherSunrise.get(0);
        JSONArray sunRiseArray = sunRiseObject.optJSONArray("astronomy");
        JSONObject SunRiseObject = (JSONObject)sunRiseArray.get(0);
        String sunRise = SunRiseObject.optString("sunrise").toString();
        loc.setSunRise(SunRiseObject.optString("sunrise").toString());


        JSONArray weatherSunset = maindata.optJSONArray("weather");
        JSONObject sunSetObject = (JSONObject)weatherSunset.get(0);
        JSONArray sunSetArray = sunSetObject.optJSONArray("astronomy");
        JSONObject SunSetObject = (JSONObject)sunSetArray.get(0);
        String sunSet = SunSetObject.optString("sunset").toString();
        loc.setSunSet(SunSetObject.optString("sunset").toString());


        JSONArray weatherCondition = maindata.optJSONArray("current_condition");
        JSONObject conditionObject =(JSONObject)weatherCondition.get(0);
        JSONArray conditionArray = conditionObject.getJSONArray("lang_tr");
        JSONObject ConditionObject = (JSONObject)conditionArray.get(0);
        String condition = ConditionObject.optString("value").toString();
        loc.setCondition(ConditionObject.optString("value").toString());

        JSONArray conditiontempC = maindata.optJSONArray("current_condition");
        JSONObject conditionTempCObject =(JSONObject) conditiontempC.get(0);
        String tempC = conditionTempCObject.optString("temp_C").toString();
        loc.setTempC(conditionTempCObject.optString("temp_C").toString());

        JSONArray conditiontempF = maindata.optJSONArray("current_condition");
        JSONObject conditionTempFObject = (JSONObject) conditiontempF .get(0);
        String tempF = conditionTempFObject.optString("temp_F").toString();
        loc.setTempF(conditionTempFObject.optString("temp_F").toString());


        JSONArray conditionfeelslikeC = maindata.optJSONArray("current_condition");
        JSONObject conditionfeelslikeCObject = (JSONObject) conditionfeelslikeC.get(0);
        String feelslikeC =conditionfeelslikeCObject.optString("FeelsLikeC").toString();
        loc.setFeelslikeC(conditionfeelslikeCObject.optString("FeelsLikeC").toString());


         JSONArray conditionfeelslikeF = maindata.optJSONArray("current_condition");
         JSONObject conditionfeelslikeFObject = (JSONObject)conditionfeelslikeF.get(0);
         String feelslikeF = conditionfeelslikeFObject.optString("FeelsLikeF").toString();
         loc.setFeelslikeF(conditionfeelslikeFObject.optString("FeelsLikeF").toString());



         JSONArray pressureA = maindata.optJSONArray("current_condition");
         JSONObject pressureObject = (JSONObject)pressureA.get(0);
         String pressure = pressureObject.optString("pressure").toString();
         loc.setPressure(pressureObject.optString("pressure").toString());



         JSONArray humidityA = maindata.optJSONArray("current_condition");
         JSONObject humidityObject = (JSONObject)humidityA.get(0);
         String humidity = humidityObject.optString("humidity").toString();
         loc.setHumidity(humidityObject.optString("humidity").toString());


         JSONArray winddir16pointA = maindata.optJSONArray("current_condition");
         JSONObject winddir16pointObject = (JSONObject)winddir16pointA.get(0);
         String winddir16point = winddir16pointObject.optString("winddir16Point").toString();
         loc.setWinddir16point(winddir16pointObject.optString("winddir16Point").toString());


         JSONArray windspeedKmphA = maindata.optJSONArray("current_condition");
         JSONObject windspeedKmphObject = (JSONObject)windspeedKmphA.get(0);
         String windspeedKmph = windspeedKmphObject.optString("windspeedKmph").toString();
         loc.setWindspeedKmph(windspeedKmphObject.optString("windspeedKmph").toString());


         JSONArray imageIconA = maindata.optJSONArray("current_condition");
         JSONObject imageIconObject =(JSONObject) imageIconA.get(0);
         JSONArray imageIconArray = imageIconObject.getJSONArray("weatherIconUrl");
         JSONObject ImageIconObject = (JSONObject) imageIconArray.get(0);
         String imageIcon = ImageIconObject.optString("value").toString();
         loc.setImageIcon(ImageIconObject.optString("value").toString());


        JSONArray cityCountry = maindata.optJSONArray("request");
        JSONObject cityCountryObject = (JSONObject) cityCountry.get(0);
        loc.setCityCountry(cityCountryObject.optString("query").toString());

        //TODO

		return loc;
	}


}
