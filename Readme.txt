Readme


Swagger URL: http://localhost:8080/swagger-ui.html#/
H2 URL: http://localhost:8080/h2-console

1.Seller should be able to post products. 

URL : http://localhost:8080/seller/addProduct/ - POST
RequestBody :  {
	"productId": 1
        "productName": "Soap",
        "productDescription": "Bath Soap",
        "productPrice": 10.0,
        "productCount": 2,
        "productCategory": {
                     "id": 1,
                     "type":"Personal"
                   }       
 }
 {
	"productId": 2
        "productName": "Sugar",
        "productDescription": "Sugar",
        "productPrice": 10.0,
        "productCount": 2,
        "productCategory": {
                     "id": 2,
                     "type":"Grocery"
                   }
        
 }

 {
	"productId": 3
        "productName": "Oil",
        "productDescription": "Soybean Oil",
        "productPrice": 100.0,
        "productCount": 2,
        "productCategory": {
                     "id": 2,
                     "type":"Grocery"
                   }
        
 }

ResponseBody:
{
    "productId": 2,
    "productName": "Sugar",
    "productDescription": "Sugar",
    "productPrice": 10.0,
    "productCount": 2,
    "productCategory": {
        "id": 2,
        "type": "Grocery"
    }
}


2. User Add product to the cart

URL : http://localhost:8080/user/addProductToCart/23/cart1 -POST

RequestBody :
 {
   "productName":"Sugar",
   "productDescription":"Sugar",
   "productPrice":10.0,
   "productQuantity":3
}

ResponseBody : 
{
    "cartId": 1,
    "cartName": "cart1",
    "userId": 23,
    "prodName": "Sugar",
    "prodDescription": "Sugar",
    "prodPrice": 10.0,
    "prodQty": 3
}


3. Place order

URL : http://localhost:8080/user/placeOrder/23/1/ - POST

ResponseBody : 
{
    "orderId": 2,
    "cartName": "cart1",
    "userName": "Khushboo",
    "productList": [
        {
            "productName": "Sugar",
            "productDescription": "Sugar",
            "productPrice": 10.0,
            "productQuantity": 3
        }
    ],
    "totalPrice": 30.0
}

---> For Exception case of Payment Failed pass URL
URL : http://localhost:8080/user/placeOrder/23/1/ - POST

Response: Payment Failed


4. Search Product

URL : http://localhost:8080/user/searchProducts/ - POST

RequestBody :
{
    "title":"Soap",

	"minPrice":10,

	"maxPrice":10	
}

ResponseBody: array of products

[
    {
        "productId": 2,
        "productName": "Sugar",
        "productDescription": "Sugar",
        "productPrice": 10.0,
        "productCount": 2
    }
]
