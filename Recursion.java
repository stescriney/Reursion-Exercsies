/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author stesc
 */

import java.util.Scanner;
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        for(int i =0; i<10; i++){
            System.out.println(fibRecursive(i));
        }//close for loop
        
        System.out.println("factorial of 5 is " + factorial(5));
        
        System.out.println("Factorial(Rec) Of 5 is "+ factorialRec(5));
        
        System.out.println("5 with exponenet 3 is "+ power(5,3));
        
        String myString = "xhixhixhi";
        
        System.out.println(hiCount(myString));
        System.out.println(removeX(myString));
        
        
        int[] myInt = {1,2,3,4,4,5,6,7};
        System.out.println(nextTen(myInt, 0));
        
        String newString = "XxxxXxxx";
        System.out.println("x to y " + xToy(newString));
        
        
        String nextString = "xxxyyyyzzzzz";
        
        System.out.println("cleanString " + cleanString(nextString));
        
        String revString = "abcdefg";
        
        System.out.println("reverse "+ reverse(revString));
        
        
        String pal = "toooooooot";
        
        System.out.println("palindrome? " + palindrome2(pal));
        
        
        
        
        
        
        System.out.println("Enter word");
        String charStr = sc.next();
        
        char charSearch = charStr.charAt(0);
        System.out.println("count" + charCount(charStr,  charSearch));
        
        
        
    }// close main method
    
    
    public static int fib(int n){
        if(n == 0)
        return 0;
        
        int a =0;
        int b =1;
        
      for(int i =2; i <=n ;i++){
          int c = a + b;
          a = b;//increment a
          b = c;// increment b
      }// close for loop
        return b;
    }// close method
    
    public static int fibRecursive(int n){
        if(n <=1)// this is the base case, similar to termination in for loop
            return n;// will return 0 or 1
        return fibRecursive(n -1)+ fibRecursive(n - 2);
       }//close fibRecursive
    
    
        public static int factorial(int n){
        
            int fact = 1;
            for(int i =1; i <=n; i++){
            fact *= i;//traverse from 1 to n and multiply i
            
            }//close loop
            return fact;
        }//close factorial
        
        public static int factorialRec(int n){
            
            if(n <= 1)
                return 1;
            
            return n * factorialRec(n - 1); 
            //eg. 5! = 5 x 4!
            //4! = 4 x 3! etc...
            
        
        }//close factorialRec
        
        
        public static int power(int n, int e){//n = number, e = exponent
        
            if (e == 0)
                return 1;// anything exponent 0 = 1
            if (e == 1)
                return n;// n exponent 1 = n
            return n *power(n, e -1);
            
        }//close power
        
        
        //Given a string, compute recursively (no loops) the number of times lowercase “hi”
        //appears in the string.
       
        
        public static int hiCount(String str){
        
          if(str.length()<=1)////string is too small to contain target
                return 0;
          
          if(str.substring(0,2).equals ("hi"))//if first two letters are hi
              return 1 + hiCount(str.substring(1));
          //return 1 and repeat from the next letter***
            //eventually the string will be <=1 in size
          
          return hiCount(str.substring(1));
        
        
   }//close method
        
        public static boolean palindrome2(String str){
        
            int len = str.length();
            
            
            if(len == 0||len ==1)
                return true;
            
            else{
                if(str.charAt(0) != str.charAt(len-1))
                return false;
            
               
            else
                    return palindrome2(str.substring(1, len-1));
            
            
            }//close else
            
            
            
            
        
        
        }//close method
        
        
        
        public static int charCount(String str, char c){
        
        
        if(str.length()==0)
            return 0;
        
        if(str.charAt(0)== (c))
            return 1 + charCount(str.substring(1), c);
        
        else
            return charCount(str.substring(1), c);
        
        
        }//close method
        
        
       public static String removeX(String str){
       
           if(str.length()==0)
               return "";
           
           if(str.substring(0,1).equals("x"))
               return "" + removeX(str.substring(1));
           
           
           return str.substring(0,1)+  removeX(str.substring(1));
       
        }//close method
       
       
       
       public static boolean nextTen(int[] arr, int index){
       
            if(arr.length-1<=index)
                return false;
            
            
            if(arr[index]*10 == arr[index +1] )
                return true;
            
            
            return nextTen(arr, index +1);
            
            
       }//close method
        
        
       public static boolean isPalindrome(String str){

           int len = str.length();
           
           if(len==1||len ==0){
               return true;
           }
           else{
               
              String a="";
              String b="";
              if(len%2==0){
               
               
               a = (str.substring(0,len/2));
               b = (str.substring((len/2),len));
              
              }
              else if(len%2!=0){
                  a = (str.substring(0,len/2));
                  b = (str.substring((len/2)+1,len));        
              }
              System.out.println(a + " and " + b);
              if(a.equals(reverse(b))){
                     return true;
                 }

           }//else  
           return false;         
         }//close is palindrome
       
       
       
       
       public static String reverse(String str){
       
       int len = str.length();
       
       if((len==0)||(len <=1)){
        return str;
       }
       
       return reverse(str.substring(1))+ (str.charAt(0));
       
       
       
       
       }//close reverse
        
        
       
      public static int arrSum(int[]arr, int n){
      
      int len = arr.length;
      
      if(len == 0)
          return 0;
      
      else{
      
          for(int i =0;i<len;i++){
          
              return arr[i] + arr[i+1];
          
          }
          
       }//close else
      
      return arrSum(arr, n);
      
      
      
      }//close method
       
       
       
       public static String xToy(String str){
           
           if(str.length()<1)
               return "";
          
           
           if(str.substring(0,1).equals("x")){
           
           return  "y" + xToy(str.substring(1));
           
           }
           
          return str.substring(0,1) +  xToy(str.substring(1));
       
     }//close method
       
       
       
       public static String cleanString(String str){
           
           if(str.length()<=1)
               return "";
           
           if(str.substring(0,1).equals(str.substring(1,2))){
               
               return str.substring(1,2) + cleanString(str.substring(2));
               
               
               
           }
           
               
           return cleanString(str.substring(2));
       
           
      }//close method
       
       
       
      
}// close class
