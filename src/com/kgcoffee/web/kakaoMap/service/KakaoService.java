package com.kgcoffee.web.kakaoMap.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class KakaoService {

	private final static String uri = "https://dapi.kakao.com/v2/local/search/keyword.json?";
	private final static String apiKey = "KakaoAK 4811118d83cc4f11769af7407cf75b6e";

	private static String query = "megacoffee";
	private final static int size = 15;
	private static int page = 1;

	private static double offset = 0.01;
	


	public static void getStoreList(double startX, double startY, double endX, double endY) {

		try {

			StringBuilder reqUri = new StringBuilder();
			reqUri.append(uri)
			.append("query=" + query)
			.append("&size=" + size)
			.append("&page=" + page)
			.append("&rect="+(startX-offset))
			.append(",")
			.append(startY-offset)
			.append(",")
			.append(endX+offset)
			.append(",")
			.append(endY+offset)
			;

			System.out.println("URL : "+reqUri.toString());
			URL url = new URL(reqUri.toString());

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestProperty("Authorization", apiKey);
			conn.setRequestProperty("Content-type", "application/json; charset=utf-8");

			
			System.out.println();
			System.out.println("응답코드 : "+conn.getResponseCode() + conn.getResponseMessage());
			
			System.out.println("ContentType : "+conn.getContentType());
			System.out.println();
			
			
			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {

				
				String responseData = br.readLine();
				System.out.println("responseData : "+ responseData);

				
				
				JsonElement element = JsonParser.parseString(responseData);
				
				System.out.println();
				
				
				JsonObject object = element.getAsJsonObject();
				JsonObject meta = object.get("meta").getAsJsonObject();
				JsonArray documents = object.get("documents").getAsJsonArray();
				System.out.println("meta : "+ meta);
			
				System.out.println("document : "+ documents);
				int searchCnt = meta.get("total_count").getAsInt();
				System.out.println("검색결과 :"+searchCnt);
				
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	


}
