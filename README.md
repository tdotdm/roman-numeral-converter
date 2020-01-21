# Roman Numeral Converter
Roman Numeral Converter is a Java / Spring Boot application which converts numbers to standard Roman numeral notation.
You can read more about Roman numerals and its standard notation [here](https://en.wikipedia.org/wiki/Roman_numerals#%22Standard%22_forms).
#### Approach
When researching Roman numerals, I noticed that each place value (units, tens, hundreds and thousands)
has the same pattern in generating Roman numerals. For example, the first three iterations of any given place value will be 
the place value's key three times in a row. Likewise, the 4th value for any given place value will have a shorthand 
representation. For example, the number 3 is represented as 'III' and the number 40 is represented as 'XL' as opposed 
to 'XXXX'. Therefore, my plan was to capitalise on this pattern.
#### Assumptions
The assumptions I made for this application are as follows:

* Input exceeding 1 - 3999 lower/upper boundary range will not be supported as 1 - 3999 are the limits for standard Roman
numeral notation. 
* Input should be validated and should not be outwith the configured lower/upper boundary range.
* Leading zeroes should not affect the output. For example, the number 007 and 7 should both return the value 'VII'.
* Users will input numbers in Integer format, i.e. 56 instead of fifty six.
* Only whole numbers will be supported, i.e. 7.5 will be rejected.  
#### Building the application
The application is built using Maven, and can therefore be built by yourself using Maven.
 
* First, clone the repository.
* Second, navigate to the project's root directory, and execute the command "mvn clean install". If you do not have
Maven installed, you can use the "mvnw" or "mvnw.cmd" files depending on your OS. 
#### Running the application
Once packaged/installed, the application can be started by running the Jar.

* First, navigate to the project's "target" directory
* Second, execute the command 'java -jar roman-numeral-converter --numberToConvert=$' where 
$ is the number you want converted into Roman numerals. 

The application has several environment variables:
 
* numberToConvert - this controls which number you wish to convert to Roman numerals. The default value for this environment variable
is 0. Therefore, if this environment variable is not changed, the application will exit. 
* lowerBound - this controls the lowest possible value for numberToConvert, so long as it is not lower than 1. The default value
for this environment variable is 1.
* upperBound - this controls the highest possible value for numberToConvert, so long as it is not higher than 3999. 
The default value for this environment variable is 3999.
