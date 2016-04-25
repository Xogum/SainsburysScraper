# androidSainsburysScraper
Sainsbury's Scraper is an Android app that scrapes information from a Sainsbury's groceries web page and builds a UI with the given information. 

#Dependencies
Sainsbury's Scraper uses the following libraries:

- Jsoup - (for connecting to the web page) and HTML parsing.
- Picasso - to simplify the load of URL images on Android.
- Junit - for testing

#Note
In attempting to scrape the web-page dynamically, I found that a cookie "TS017d4e39" was needed to make the HTTP request.  I initially obtained the cookie data using developer tools, but it cookie expired after approximately 30 minutes.  I got as far as managing to programatically retrieve the cookie data from a HTTP response, and resubmitting it within a new post request, but for some reason it did not work.  Hence, the app interrogates a saved copy of the page source which has been saved in the assets folder.

#URL
http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true
