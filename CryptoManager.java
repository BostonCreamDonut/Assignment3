public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	//the amazing thing about this class is that each class is very very similar in the way it is written. You will see, many of the comments will be very similar in each method because of how similar the code is. Every method
	//in the program is just going through each character in the given text and changing each value by the key and then storing it into a variable
	public static boolean stringInBounds (String plainText){
		boolean check=true;
		//makes sure each letter in plainText is within the range
		for(int i=0; i<plainText.length();i++)
		{
			//when value is not in range, returns false
			if(plainText.charAt(i)<LOWER_BOUND || plainText.charAt(i)>UPPER_BOUND)
			{
				check=false;
				break;
			}
		}
		return check;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String caesar=""; //holds the encrypted code
		//add used to hold char value, make process fore efficient
		int add=0;
		//encrypts each letter in plainText
		for(int i=0; i<plainText.length(); i++)
		{
			add= (plainText.charAt(i)+key);
			//in case there is an obsured key or values towards the end get out of range, I added the lower bound while loop in case too low, and higher bound while loop in case too high
			while(add<LOWER_BOUND)
			{
				add+=RANGE;
			}
			while(add>UPPER_BOUND)
			{
				add-=RANGE;
			}
			//add turned into char, each char at value of i stored in new string
			caesar+=(char)add;
			
		}
		return caesar;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String bellaso="";//holds the encrypted code
		//add used to hold char value, make process fore efficient
		int add=0;
		while(bellasoStr.length()<plainText.length())//if bellasoStr is not longer than the text, it makes it the same size so every char in text can be changed
		{
			bellasoStr+=bellasoStr;
		}
		//encrypts each letter in plainText
		for(int i=0; i<plainText.length(); i++)
		{
			add=(char) (plainText.charAt(i)+bellasoStr.charAt(i));
			//if add too high, subtract by range
			while(add>UPPER_BOUND)
			{
				add-=RANGE;
			}
			//add turned into char, each char at value of i stored in new string
			bellaso+=(char)add;
			
		}
		return bellaso;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String caesar="";//holds the decrypted code
		//add used to hold char value, make process fore efficient
		int add=0;
		//decrypts each letter in enryptedText
		for(int i=0; i<encryptedText.length(); i++)
		{
			add=(encryptedText.charAt(i)-key);
			//in case there is an obsured key or values towards the end get out of range, I added the lower bound while loop in case too low, and higher bound while loop in case too high
			while(add<LOWER_BOUND)
			{
				add+=RANGE;
			}
			while(add>UPPER_BOUND)
			{
				add-=RANGE;
			}
			//add turned into char, each char at value of i stored in new string
			caesar+=(char)add;
			
		}
		return caesar;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String bellaso="";//holds the decrypted code
		//add used to hold char value, make process fore efficient
		int add=0;
		while(bellasoStr.length()<encryptedText.length())//if bellasoStr is not longer than the text, it makes it the same size so every char in text can be changed
		{
			bellasoStr+=bellasoStr;
		}
		//decrypts each letter in enryptedText
		for(int i=0; i<encryptedText.length(); i++)
		{
			add=(encryptedText.charAt(i)-bellasoStr.charAt(i));
			//if add too low, add by range
			while(add<LOWER_BOUND)
			{
				add+=RANGE;
			}
			//add turned into char, each char at value of i stored in new string
			bellaso+=(char)add;
			
		}
		return bellaso;
	}
}
