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

import java.io.Serializable;


public class Location implements Serializable {


	//TODO
	private String moonRise;
	private  String moonSet;
	private String sunRise;
	private String sunSet;
	private String condition;
	private String tempC;
	private String tempF;
	private String feelslikeC;
	private String feelslikeF;
	private String humidity;
	private String pressure;
	private String winddir16point;
	private String windspeedKmph;
	private String imageIcon;
	private String cityCountry;

	public String getCityCountry() {
		return cityCountry;
	}

	public void setCityCountry(String cityCountry) {
		this.cityCountry = cityCountry;
	}





	public String getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(String imageIcon) {
		this.imageIcon = imageIcon;
	}



	public String getWindspeedKmph() {
		return windspeedKmph;
	}

	public void setWindspeedKmph(String windspeedKmph) {
		this.windspeedKmph = windspeedKmph;
	}



	public String getWinddir16point() {
		return winddir16point;
	}

	public void setWinddir16point(String winddir16point) {
		this.winddir16point = winddir16point;
	}



	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}


	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}


	public String getMoonRise() {
		return moonRise;
	}
	public void setMoonRise(String moonRise) {
		this.moonRise = moonRise;
	}

	public String getMoonSet() {
		return moonSet;
	}
	public void setMoonSet(String moonSet) {
		this.moonSet = moonSet;
	}

	public String getSunRise() {
		return sunRise;
	}
	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}


	public String getSunSet() {
		return sunSet;
	}
	public void setSunSet(String sunSet) {
		this.sunSet = sunSet;
	}

	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTempC() {
		return tempC;
	}
	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public String getTempF() {
		return tempF;
	}
	public void setTempF(String tempF) {
		this.tempF = tempF;
	}

	public String getFeelslikeC() {
		return feelslikeC;
	}
	public void setFeelslikeC(String feelslikeC) {
		this.feelslikeC = feelslikeC;
	}

	public String getFeelslikeF() {
		return feelslikeF;
	}
	public void setFeelslikeF(String feelslikeF) {
		this.feelslikeF = feelslikeF;
	}

	
}
