Back end for shopping application - trying to help my sibling be able to find cheapest stores to go to and most convenient.

//ADD products into database
POST coles http://localhost:8080/api/coles/fetch?productName=apples
POST woolworths http://localhost:8080/api/woolies/fetch?productName=apples
GET Aldi http://localhost:8080/api/aldi/fetch?productCode=no-brand-kanzi-apples-800g-000000000000380113

GET http://localhost:8080/search/cheapest/list  -> finds cheapest store to go to and returns total price and money saved
//body : {
    "items": ["milk", "avocado"]
}





