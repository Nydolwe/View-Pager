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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpClient {
	public WeatherListener getListener() {
		return listener;
	}

	public void setListener(WeatherListener listener) {
		this.listener = listener;
	}

	public WeatherListener listener;
	static final String API_KEY = "22a430501f9f8ed2b55a1245d6768";
	private static String BASE_URL = "http://api.worldweatheronline.com/free/v2/weather.ashx?q=%s&format=json&num_of_days=1&cc=yes&showlocaltime=no&lang=tr&key="+ API_KEY;
	public void getWeatherData(final String location) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection con = null ;
				InputStream is = null;
				try {
					con = (HttpURLConnection) ( new URL(String.format(BASE_URL,location))).openConnection();
					con.setRequestMethod("GET");
					con.setDoInput(true);
					con.setDoOutput(true);
					con.connect();
					// Let's read the response
					StringBuffer buffer = new StringBuffer();
					is = con.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String line = null;
					while (  (line = br.readLine()) != null )
						buffer.append(line + "\r\n");
					is.close();
					con.disconnect();
					listener.onSucceed(buffer.toString());
				}
				catch(Throwable t) {
					t.printStackTrace();
					listener.onFailed("Error occoured");
				}
				finally {
					try { is.close(); } catch(Throwable t) {listener.onFailed("Error occoured");}
					try { con.disconnect(); } catch(Throwable t) {listener.onFailed("Error occoured");}
				}
			}
		});
		thread.start();

	}

}
