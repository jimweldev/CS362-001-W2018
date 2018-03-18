
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
   //You can use this function to implement your manual testing
      String validURL = "https://youtube.com/";
      //UrlValidator validator = new UrlValidator();
      String[] schemes = {"http","https"};
      UrlValidator validator = new UrlValidator(schemes);

      //assertTrue(validator.isValid(validURL));
      //assertTrue(validator.isValid("http://google.com/"));
      //assertFalse(validator.isValid("http://google.com/"));


      String[] regexs = new String[] {".", "/", "\"^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\\\?([^#]*))?(#(.*))?\""};
      RegexValidator regexValid = new RegexValidator(regexs, false);

      UrlValidator validator2 = new UrlValidator(schemes, regexValid, UrlValidator.ALLOW_ALL_SCHEMES);

      assertTrue(validator2.isValid("http://google.com/"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing

      String[] schemes = new String[] {"http://", "ftp://", "http:", "://"};

      UrlValidator validator = new UrlValidator();

      for(int i=0; i<schemes.length; i++) {
         if(i < 2) {
            assertTrue(validator.isValidScheme(schemes[i]));
         }
         else {
            assertFalse(validator.isValidScheme(schemes[i]));
         }
      }
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing

      String[] UrlAuthorities = new String[] {"go.com", "0.0.0.0", "1.2.3.4.5", "go.a"};

      UrlValidator validator = new UrlValidator();

      for(int i=0; i<UrlAuthorities.length; i++) {
         if(i < 2) {
            assertTrue(validator.isValidAuthority(UrlAuthorities[i]));
         }
         else {
            assertFalse(validator.isValidAuthority(UrlAuthorities[i]));
         }
      }

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid() {
      //You can use this function for programming based testing

      String[] schemes = new String[]{"http://", "ftp://", "http:", "://"};
      String[] UrlAuthorities = new String[]{"go.com", "0.0.0.0", "1.2.3.4.5", "go.a"};

      UrlValidator validator = new UrlValidator();

      for (int i = 0; i < schemes.length; i++) {
         for (int y = 0; y < UrlAuthorities.length; y++) {
            if (validator.isValidScheme(schemes[i]) && validator.isValidAuthority(UrlAuthorities[y])) {
               assertTrue(validator.isValid(schemes[i].concat(UrlAuthorities[y])));
            } else {
               assertFalse(validator.isValid(schemes[i].concat(UrlAuthorities[y])));
            }
         }

      }

   }

}
