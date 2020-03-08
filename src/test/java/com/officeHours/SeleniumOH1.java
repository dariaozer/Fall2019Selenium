package com.officeHours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {
    /*
    -Iterator
     */

    public static void main(String[] args) {
        //Create an ArrayList of Strings -- iterate over it.
        ArrayList<String> keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator iterator = keysToSearch.iterator();
        //iterator(); return Iterator type which we can use with all iterator methods.
        //[fruits, veggies, berries]
        while(iterator.hasNext()){

            System.out.println(iterator.next());
        }
        //print before modification
        //add* to each string and print again.



        //create a map with String, String

        HashMap<String, String> personalInfo = new HashMap<>();
        personalInfo.put("name", "Bryan");
        personalInfo.put("Student id", "2314635541");
        personalInfo.put("major", "computer science");
        Iterator<String> mapIterator = personalInfo.keySet().iterator();
        while(mapIterator.hasNext()){
            String key = mapIterator.next();
            System.out.println(key + " : "+ personalInfo.get(key));
        }
        System.out.println("======SELENIUM============");

        /*
        There are 8 locators in Selenium
        id - always unique --problem with id -- it not always available
              we always prefer to use id when it is available
        class- classname
        name
        tag - every element will have a tag --problem there will be multiple same tags.
               if we want one only then it would be a problem

         will only work with the link
        linktext
        partial linktext

        locator that is using html (special syntax) --to locate
        css
        xpath



        <input id="global-enhancements-search-query" data-id="search-query"
        data-global-enhancements-search-input=""
        type="text" name="search_query"
        class="wt-input wt-input-btn-group__input
        global-enhancements-search-input-btn-group__input wt-pr-xs-7"
        placeholder="Search for items or shops" value="handbags"
        autocomplete="off" autocorrect="off" autocapitalize="off">

         key = "value" - attributes

         input - tag

         id="global-enhancements-search-query" - one of the attributes
         we can use id to locate the element

         name="search_query" - attribute - we can use name to locate the element

         class="wt-input wt-input-btn-group__input
            global-enhancements-search-input-btn-group__input wt-pr-xs-7"
            - we can use class to locate element

            When we want to find element it is always must be unique
            id- always unique
            name, tag, class - are not unique very often

             WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://etsy.com");
        WebElement searchBar = driver.findElement(By.id("global-enhancements-search-query"));
        //findElement() -> returns WebElement
        //as param we put By.locator("value of attribute")
        //                  (id, name, classname, class, ....)


         */



    }

}
