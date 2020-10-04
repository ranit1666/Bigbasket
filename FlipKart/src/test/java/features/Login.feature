Feature: Testcase for login into Flipkart

Scenario: Verify if correct product details are displayed in MyBasket 
Given user opens the browser for BigBasket
Then user search for a product
Then user select a product
And user verify if location popup is present
Then user select city
And user select delivery area
And user click continue button after area selection
Then user verify product details in cart
And user verify subTotal in cart

#Then user login with useremail and password
#And user adjust the quantity
#Then user select the pack size
#Then user add the product to basket

@End2End
Scenario: Verify if product quantity is increased or decreased then proper price is displayed in subtotal of MyBasket

Given user opens the browser for BigBasket
Then user search for a product
Then user select a product
And user verify if location popup is present
Then user select city
And user select delivery area
And user click continue button after area selection
Then user verify product details in cart
Then user increase product qty and verify subtotal
Then user decrease product qty and verify subtotal


