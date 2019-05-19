package com.iwh.bpr.dao;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CompetitorDaoImpl implements CompetitorDao {

	public static final String GOOGLE_SEARCH_URL = "https://www.google.com/search";

	@Override
	public String findCompetitors(String typOfService) {

		String searchURL = GOOGLE_SEARCH_URL + "?q=" + "Top 10 " + typOfService + " sites in India" + "&num=" + 1;

		Document doc = null;
		try {
			doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements results = doc.select("h3.r > a");

		String url = null;
		for (Element result : results) {
			String linkHref = result.attr("href");
			url = linkHref.substring(6, linkHref.indexOf("&"));
		}

		return url;
	}


	}


