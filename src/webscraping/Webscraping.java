/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscraping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import static webscraping.Webscraping.pastResultURL;

/**
 *
 * @author skywood
 */
public class Webscraping {

    /**
     * @param args the command line arguments
     */
    public static final String URL = "http://4d88.com/";
    public static final String class1 = "lvtb12 ln";
    public static final String class2 = "lvtb12";
    public static final String magnumTable = "//table[@class='rs-tbl lvtbl1']";
    public static final String pastResultURL = "http://app.4d88.com/history/date?d=";
    public static final String pastResultTable = "//table[@class='table compact']";
    
    public static final Map<String,Integer> dataSet = initializeDictionary();
    
    public static void main(String[] args) {
        
        try{
        //    HtmlPage page = client.getPage(URL);
          //  System.out.println(page.asXml());
          
          //returning all classes with r1 nomap
//            List<HtmlElement> items = page.getByXPath("//th[@class='r1 nomap']");
//                        items.forEach(x -> System.out.println(x.asText()));
            
        //    List<String> magnumTableAttributes = new ArrayList<>();
       //     magnumTableAttributes.add("[data-c='B']");
       //     magnumTableAttributes.add("[data-d='1']");
       //     magnumTableAttributes.add("[class='rs-tbl lvtb11']");
            
       //    List<HtmlElement> getTable = page.getByXPath(magnumTable);
       ///     System.out.println("List size = " + getTable.size());
            
        //   getTable.forEach(x->System.out.println(x.asText()));
           //getTable.forEach(x->System.out.println(x));
           
         //   if(items.isEmpty())
        //        System.out.println("empty list");

        
      //  String a = //*[@id="magnum-toto-damacai"]/div/div[1]/div[3];
      //          String b = //*[@id="magnum-toto-damacai"]/div/div[1]/div[3]/div/div[1]/span/span;
        //for past result
        //stick with this
        //standardized
        

       
        //year,month,day
     //   int year = -1;
      //  int month = -1;
      //  int day = -1;
       //     System.out.println(calendar.getTime());
        //calendar.set(2020, 8, 20);
        //Initialize year month day to today
     
        //Day_OF_WEEK (1-7) start from Sunday
       
        //check which day is the date
       //     System.out.println(year + " " + month + " " + day);
       //     System.out.println("dayofweek = " + calendar.get(Calendar.DAY_OF_WEEK));
        
            

//excluding tuesday special draw            
//possibleDayWithEvent.add(3);
            System.out.println("Starting");
        int dataSetCount = 280;
               
   //     updateDictionary("1234");
        
    
        ArrayList<JSONObject> extractedDataSet = grabData(populatingDateSet(dataSetCount));
        System.out.println("Total data : " + extractedDataSet.size());
        for(JSONObject jsonObject : extractedDataSet){
          //  System.out.println(jsonObject.toString());
            
            if(jsonObject == null){
         //       System.out.println("null object found");
                continue;
            }
            JSONArray array = jsonObject.getJSONArray("AllData");
            
            
            for(int i =0;i<array.length();i++){
                JSONObject object = array.getJSONObject(i);
           //     System.out.println(object.toString());
                
            //    System.out.println(object.get("Data"));
                
                JSONArray dataArray = object.getJSONArray("Data");
                
       //         System.out.println(dataArray.toString());
                for(int j = 0; j<dataArray.length();j++){
         //           System.out.println(dataArray.getString(j));
                    updateDictionary(dataArray.getString(j));
                }
             //       
         //       }
            }
        }
        
            extractDictionary();
        
        
        
          //  System.out.println(grabData(populatingDateSet(dataSetCount)).get(0).toString());
        
            
    //    Map <String,Integer> dataSet = initializeDictionary();
    
        
        
       // dataSet.keySet().forEach(x->System.out.println(x));
        
        //String date = "2020-09-19";

                
         //   List<HtmlElement> abc  = extraction.get(0).getByXPath("/span[@class='t1']");
       //     System.out.println("printing t1 result");
       //     abc.forEach(x -> System.out.println(x.asText()));
        }
      //  getTable2.forEach(x->System.out.println(x.asText()));
      
        catch(Exception e ){
            e.printStackTrace();
        }
    
    }
    
    public static void extractDictionary(){
      //  positionOne();
      //  positionTwo();
       // positionThree();
       frequency();
       
    }
    
    public static void frequency(){
        dataSet.entrySet()
                .stream()
                .filter(s-> s.getKey().equals("1017"))
            //    .sorted(Map.Entry.comparingByKey())
            //    .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
    
    public static void positionOne(){
        //extract non-zero count key and value in dictionary
        dataSet.entrySet()
                .stream()
                .filter(s -> s.getValue() > 0)
                .filter(x -> x.getKey().length() == 4)
                .filter(x -> x.getKey().substring(0,2).equals("84"))
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }
        public static void positionTwo(){
        //extract non-zero count key and value in dictionary
        dataSet.entrySet()
                .stream()
                .filter(s -> s.getValue() > 0)
                .filter(x -> x.getKey().length() == 4)
                .filter(x -> x.getKey().substring(1,3).equals("84"))
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }
            public static void positionThree(){
        //extract non-zero count key and value in dictionary
        dataSet.entrySet()
                .stream()
                .filter(s -> s.getValue() > 0)
                .filter(x -> x.getKey().length() == 4)
                .filter(x -> x.getKey().substring(2,4).equals("84"))
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
    }
    
    public static void updateDictionary(String data){
        
        //given a number abcd
        //for each of combination, find and increase the count
        //a,b,c,d,ab,bc,cd,abc,bcd,abcd
        
        ArrayList<String> extraction = new ArrayList();
        
        for(int i=0;i<=3;i++){
            extraction.add(data.substring(i, i+1));
        }
        
        for(int i=0;i<=2;i++){
            extraction.add(data.substring(i, i+2));
        }
        
        for(int i=0;i<=1;i++){
            extraction.add(data.substring(i, i+3));
        }
        
        extraction.add(data);
     //   System.out.println(extraction.toString());
        extraction.forEach(x-> dataSet.put(x, dataSet.get(x)+1));
        
       // System.out.println(extraction.toString());
        
    }
    
    public static Map<String,Integer> initializeDictionary(){
        
        Map<String,Integer> dictionary = new HashMap();
        
        //substring 0-999
        for(int i=0;i<1000;i++){
            dictionary.put(Integer.toString(i), 0);
            
            if(i<100){ //00-09
                dictionary.put("0"+Integer.toString(i), 0);
            }
         
        }
        
        for(int i=0;i<10;i++){ //00-09
            dictionary.put("0"+Integer.toString(i), 0);
            //000-009
            dictionary.put("00"+Integer.toString(i),0);
        }
        
        
        //0000-9999
        for(int i =0;i<10000;i++){
            String conversion = Integer.toString(i);
            if(i<10){ //0-9 
                conversion = "000" + conversion;
            }
            else if(i<100){ //10-99
                conversion = "00" + conversion;
            }
            else if(i<1000){ //100-999
                conversion = "0" + conversion;
            }
        //    System.out.println(conversion);
            dictionary.put(conversion,0);
        }
        return dictionary;
    }
    
    public static ArrayList<String> populatingDateSet(int dataSetCount){
                //when get instance, it get the current time
        //month sep ; month value = 8(start from 0)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Set<Integer> possibleDayWithEvent = new HashSet();
            possibleDayWithEvent.add(7);possibleDayWithEvent.add(1);possibleDayWithEvent.add(4);
        
        ArrayList<String> dateSet = new ArrayList();
        
        while(dateSet.size()<dataSetCount){
           int year = calendar.get(Calendar.YEAR);
           int month = calendar.get(Calendar.MONTH);
           int day = calendar.get(Calendar.DATE);
            
            if(possibleDayWithEvent.contains(calendar.get(Calendar.DAY_OF_WEEK))){
                dateSet.add(year + "-"  + (month+1)   +   "-" +   day);
            } 
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            
            
            
            
        }
        System.out.println("checking dateset");
        for(String date:dateSet)
                System.out.println(date);
        return dateSet;
    }
        
    public static ArrayList<JSONObject> grabData(ArrayList<String> dateSet){
        
        ArrayList<JSONObject> product = new ArrayList();
        dateSet.parallelStream().forEach(date -> product.add(retriveData(date)));
            
        
       
        return product;
    
}
    public static JSONObject retriveData(String date){
         WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
    
        //multithreading for this for loop
        
      //  for(int i =0; i <dateSet.size();i++){   
            try{
                HtmlPage page2 = client.getPage(pastResultURL + date);//.get(i));
        
                List<HtmlElement> getTable2 = page2.getByXPath("//div[@class='panel panel-default rs h']");
           //     System.out.println("List size = " + getTable2.size());
                System.out.println("Computing for date : " + date);
                for(HtmlElement element : getTable2){

                    //will have 2 domchildelements
                    //fist
                    /*
                     Magnum 4D 
                         Wed 16-09-2020 406/20.
                     */
                    /*
                    Second = data
                    */

                    //element.getChildElements().forEach(x->System.out.println("domelement \n" + x.asText()));
                    List<DomElement> extraction = new ArrayList<>();
                            element.getChildElements().iterator().forEachRemaining(x->extraction.add(x));
                    // System.out.println("printing = " +extraction.get(0).asText() );
                     if(extraction.get(0).asText().contains("Magnum 4D")){
          //               System.out.println(extraction.get(1).asText());
          //               System.out.println(extraction.get(1).asXml());
                         
                         
                     //    extraction.get(1)
                         //TODO
                         //extract the data from the DOMelement
                         List<HtmlElement> topThree = extraction.get(1).getByXPath(extraction.get(1).getNodeName() + "//th[@class='r1']");
                         topThree.addAll(extraction.get(1).getByXPath(extraction.get(1).getNodeName() + "//th[@class='r2']"));
                         topThree.addAll(extraction.get(1).getByXPath(extraction.get(1).getNodeName() + "//th[@class='r3']"));
                         
                         List<String> topThreeDataSet = new ArrayList();
                         topThree.forEach(x->topThreeDataSet.add(x.asText()));
                         
                       //  System.out.println("abc size = " + topThree.size());
                        // topThree.forEach(x->System.out.println(x.asText()));
                         
                         List<HtmlElement> specialTen = extraction.get(1).getByXPath(extraction.get(1).getNodeName() + "//td[@bgcolor]");
                         
                         //extract data
                         List<String> specialDataSet = new ArrayList();
                         specialTen.forEach(x->specialDataSet.add(x.asText()));
                         
                         //System.out.println("SpecialTen");
                         //specialTen.forEach(x->System.out.println(x.asText()));
           
                         List<HtmlElement> consolationTen = extraction.get(1).getByXPath(extraction.get(1).getNodeName() + "//td[count(@*)=0]");
                         List<String> consolationDataSet = new ArrayList();
                         consolationTen.forEach(x->consolationDataSet.add(x.asText()));
                        // System.out.println("ConsolationTen");
                        // consolationTen.forEach(x->System.out.println(x.asXml()));
                         
                        //JSON CONVERSION PART
                        
                         //Dumps info into JSONObject and JSONArray
                         //so the dataset can easily transferred and use other languages to analyse it
                         JSONObject node = new JSONObject();
                         
                         node.put("Date", date);
            //             System.out.println(node.toString());
                        
                         JSONArray jsonArray = new JSONArray();
                         
                         JSONObject topThreeData = new JSONObject();
                         
                         topThreeData.put("Category", "TopThree");
                         
                         JSONArray array1 = new JSONArray();
                         topThreeDataSet.forEach(x->array1.put(x));
                         
                         topThreeData.put("Data", array1);
            //             System.out.println(topThreeData.toString());
                         
                         JSONObject specialData = new JSONObject();
                         specialData.put("Category", "Special");
                         JSONArray array2 = new JSONArray();
                         specialDataSet.forEach(x->array2.put(x));
                         specialData.put("Data", array2);
                         
                         JSONObject consolationData = new JSONObject();
                         consolationData.put("Category", "Consolation");
                         JSONArray array3 = new JSONArray();
                         consolationDataSet.forEach(x->array3.put(x));
                         consolationData.put("Data", array3);
                         
                         jsonArray.put(topThreeData);jsonArray.put(specialData);jsonArray.put(consolationData);
                         
                         node.put("AllData", jsonArray);
                         
            //             System.out.println("JSONobject to string");
            //             System.out.println(node.toString());
               //          Gson gson = new GsonBuilder().setPrettyPrinting().create();
             //            System.out.println("Printing json product");
            //             System.out.println(gson.toJson(node));
               //         System.out.println(date + ": " + node.toString());
                      //   product.add(node);
                          return node;
                         
                     }
                }
            }catch(Exception e){
                System.out.println("exception occur");
                    e.printStackTrace();
                    }

            
        System.out.println(date + " is failed to scrap");
       return null;
    }
        
    }
    

