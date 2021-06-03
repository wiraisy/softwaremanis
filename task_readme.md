# softwaremanis
JAVA TECHNICAL TEST 

Name 		 : 
Date of Test	 : 

Overview 
1.	You have maximum 5 hours to work on all tests.
2.	Please submit your work via email. 

Good luck!
================================================================================

PART 1

1. As Java programmer what’s your comments about this code in a code review session
 

ANSWER:
a method of type list has the following function: Initialize a connection method with the input parameter of the mulemessage object and then

enter all message data into a map . Give an validation provides validation and then iif the input is a boolean that has a value = true then it will start the process of moving data from map to list 


2. Make a function to count the occurrences of a char in a string. Result string should be char immediately followed by its number of occurrences.:

 

Answer:
public String countChar(String str){
int wordCount = 0;
String result = "";
for (char letter = 'a'; letter <= 'z'; letter++) {
     for (int i = 0; i < str.length(); i++) {
	if (str.charAt(i) == letter) {
		wordCount++;
				}
			}
	if (wordCount > 0) {
		System.out.print(letter + String.valueOf(wordCount));
		wordCount = 0;
			}
		}

}

3. There are two frogs on an x-axis ready to jump in the positive direction (i.e, toward positive infinity). The first frog starts at location x1 and moves at a rate of v1 meters per jump. The second frog starts at location x2 and moves at a rate of v2 meters per jump. Given the starting locations and movement rates for each frog, can you determine if they'll ever land at the same location at the same time?
 
Example output:
frogs(0,3,4,2) -> YES



ANSWER:
public String frogs(int x1, int v1, int x2, int v2){
String result = “”;
if(x2>x1 && v2> v1){
            result = “NO”;
        }else{
            while(x2 > x1){
                x2 = x2 + v2;
                x1 = x1 + v1;
                if(x1 == x2){
                    result=”YES”;
                    break;
                }
                if(x1 > x2){
                   result =”NO”;
                    break;
                }
            }
System.out.print(result);
        }
   

PART 2
0.1 Challenge

If you’re familiar with Spring framework, please create the solution below with Spring framework, if you’re not familiar with it, using another framework is fine.

We would like to have a RESTful web service that stores some transactions (in memory is fine) and returns information about those transactions. The transactions to be stored have a type and an amount. The service should support returning all transactions of a type. Also, transactions can be linked to each other (using a ”parent id”) and we need to know the total amount involved for all transactions linked to a particular transaction.

0.2 Api Spec

PUT /transactionservice/transaction/$transaction_id
Body:
{ "amount":double,"type":string,"parent_id":long }

where:
• transaction id is a long specifying a new transaction
• amount is a double specifying the amount
• type is a string specifying a type of the transaction
• parent id is an optional long that may specify the parent transaction of
this transaction.

GET /transactionservice/transaction/$transaction_id
Returns: { "amount":double,"type":string,"parent_id":long }

GET /transactionservice/types/$type
Returns: [long, long, ... ]
A json list of all transaction ids that share the same type $type.

GET /transactionservice/sum/$transaction_id
Returns: { "sum": double }
A sum of all transactions that are transitively linked by their parent_id to
$transaction_id.

0.3 Examples
PUT /transactionservice/transaction/10 { "amount": 5000, "type":"cars" }
=> { "status": "ok" }

PUT /transactionservice/transaction/11
{ "amount": 10000, "type": "shopping", "parent_id": 10}
=> { "status": "ok" }

GET /transactionservice/types/cars => [10]
GET /transactionservice/sum/10 => {"sum":15000}
GET /transactionservice/sum/11 => {"sum":10000}

Submission:
Please create a project and commit your changes on your github or bitbucket public account and send to us the link so we can clone it.

