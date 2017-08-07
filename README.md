# Json parser example with jackson

This is a sample standalone application Java / Maven / to parse the json file for user deatil and write those details in json file.

## How to Run 

* Clone this repository 
* Make sure you are using JDK 1.7 and Maven 3.x
* Change the output file path with some json file name in the config.properties under resources folder i.e /src/main/resources
* You can build the project and run the tests by running ```mvn package```
* Once successfully built, you can run the service by one of these two methods:
```
        mvn exec:java

```
* Check the whether the output file is generated in the corresponding path mentioned in the config.properties.
* Check whether all the user details is printed in the json file with the modified text field with no commas in the text.

# Here is the input file for this sample json parser program

{
  "id": 1001,
  "name": "Thomas",
  "location": "London",
  "text": "Lorem,ipsum,dolor,sit,amet,duo cu meis latine atomorum, an perfecto mnesarchum mel. Ad nam agam legendos, ne facilisi perpetua mel. Cu nam duis iudico pertinacia, ad alterum suscipit vel, eos te cibo mutat. Sitan alia facer efficiantur. Ex,vel,porro,fabellas,dignissim, in facer dolorem deleniti eam."
}


Here are corresponding output json file based on the input json file:
{
  "id" : 1001,
  "name" : "Thomas",
  "location" : "London",
  "text" : "Lorem,ipsum,dolor,sit,amet,duo cu meis latine atomorum, an perfecto mnesarchum mel. Ad nam agam legendos, ne facilisi perpetua mel. Cu nam duis iudico pertinacia, ad alterum suscipit vel, eos te cibo mutat. Sitan alia facer efficiantur. Ex,vel,porro,fabellas,dignissim, in facer dolorem deleniti eam.",
  "modifiedText" : "Lorem ipsum dolor sit amet duo cu meis latine atomorum  an perfecto mnesarchum mel. Ad nam agam legendos  ne facilisi perpetua mel. Cu nam duis iudico pertinacia  ad alterum suscipit vel  eos te cibo mutat. Sitan alia facer efficiantur. Ex vel porro fabellas dignissim  in facer dolorem deleniti eam."
}

# if you faced any issue then please follow the below steps in the intellij Idea
1) mvn clean install
2) Rebuild from build-> Rebuild Project
3) mvn package
4) mvn exec:java










