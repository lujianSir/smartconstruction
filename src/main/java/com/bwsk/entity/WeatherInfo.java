package com.bwsk.entity;

public class WeatherInfo {

	private String date;// 时间
	private String cityname;// 城市名
	private String weather;// 天气
	private String temperature;// 气温
	private String fengli;// pm2.5

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

}
