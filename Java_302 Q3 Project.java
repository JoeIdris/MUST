
/* 
	Vigenere cipher, uses each character in a keyword as
	as a cipher to encrypt the given string

	Usage:
		keyword:	<alphabetical letters string>	<ex: 	Viking>
		plaintext:	<string to be ciphered>			<ex: 	Ragnar Lothbrok>
		ciphertext:	<ciphered string>				<out: 	Miqvnx Gwdpoxjs>
*/

import java.util.Scanner;

public class MUST 
{
	// a function that calls printf without having to type it all out every single time =(
	static void printf(String format, Object ... args) 
	{
		System.out.printf(format, args);
	}

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		char keyword[];
		char plainText[];

		// enter key used to cipher (converted to array for easy element access)
		printf("keyword: ");
		keyword = keyboard.nextLine().toUpperCase().toCharArray();

		// Validate key input
		for (int i = 0, n = keyword.length; i < n; i++) 
		{
			if ( !Character.isLetter( keyword[i] ) ) 
			{
				printf("keyword: (alpahetical only): ");
				keyword = keyboard.nextLine().toUpperCase().toCharArray();
				n = keyword.length;
				i = 0;
			}
		}

		// enter plaintext to be ciphered (converted to array for easy element access)
		printf("plaintext: ");
		plainText = keyboard.nextLine().toCharArray();

		printf("ciphertext: ");

		// loop with vars required to iterate through each string, text and keyword
		for(int i = 0, j = 0, n = plainText.length, m = keyword.length; i < n; i++)
		{
			// cipherChar = ( letter - 'A' + keyword[j] - 'A' ) % 26 + 'A'

			char letter = plainText[i];
			char cipherChar;
			boolean isAlpha = Character.isLetter(letter);
			boolean isUpper = Character.isUpperCase(letter);

			if( isAlpha && isUpper ) // check if letter in plaintext is alpha and uppercase
			{
				cipherChar = (char) ( ( letter - 'A' + keyword[j] - 'A' ) % 26 + 'A' ); // ascii conversion (uppercase)
				printf("%c", cipherChar);
				j++; // move to next letter in keyword
			}
			else if( isAlpha && !isUpper )
			{
				cipherChar = (char) ( ( letter - 'a' + keyword[j] - 'A' ) % 26 + 'a' ); // ascii conversion (lowercase)
				printf("%c", cipherChar);
				j++; // move to next letter in keyword
			}
			else
			{
				printf("%c", letter); // if the letter in plaintext is not an alphabetic character, print it normally
			}

			if(j == m) // if we reached the end of the keyword, go back to its beginning
				j = 0;
		}

		printf("\n");

		keyboard.close();
	}
}
