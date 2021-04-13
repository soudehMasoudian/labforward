# labforward
This project is created to complete a task that Labforward assigned to me, which implemented using Spring Boot. The simple task of this project is to gather labratovary experiments results. There are some categories which the results are placed there. With regards to the design, there are several objects, including Category, Item and Attributes, so that every category's attribute is saved in Attribute table, while every item's attribute value pairs which saved in AttributeValuePairs table.

Here is a sample POST which saves a category row.
```json
{
    "id": "1",
    "title":"test", 
    "version":"1", 
    "attributes": 
    [
        {
            "id":"1"
        }
    ]
}
 ```
 Regarding to the Item creation, below is a sample POST body.
 ```json
 {
     "category": 
         {
             "id": "۱"
         },
         "attributeValuePairs":
         [
             {
                 "attribute": 
                     {
                     "id": "1"
                     }, 
             "value": "100"
             }
         ]
 }
  ```
  
 ### Database
 I've chosen Mysql Database, so that we will use docker-compose to bring it up for simplicity.  